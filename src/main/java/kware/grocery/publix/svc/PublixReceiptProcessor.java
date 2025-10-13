package kware.grocery.publix.svc;

import java.util.List;
import kware.grocery.publix.domain.partial.RawHeader;
import kware.grocery.publix.domain.partial.RawPublixReceiptEntry;
import kware.grocery.publix.domain.processed.PublixReceipt;
import kware.grocery.publix.domain.processed.PublixReceiptEntry;
import kware.grocery.publix.domain.processed.PublixReceiptHeader;
import org.springframework.stereotype.Component;

@Component
public class PublixReceiptProcessor {

  private RawPublixReceiptLineParser rawPublixReceiptLineParser;
  private RawPublixEntryProcessor rawPublixEntryProcessor;
  private PublixLineParser parser;
  private PublixHeaderProcessor headerProcessor;

  public PublixReceipt processReceipt(List<String> rawReceiptLines) {

    int indexOfFirstEntry = findFirstEntryLine(rawReceiptLines);
    List<String> receiptHeaderSection = rawReceiptLines.subList(0, indexOfFirstEntry);
    RawHeader rawHeader = RawHeader.builder().headerLines(receiptHeaderSection).build();
    List<String> receiptEntrySection = rawReceiptLines.subList(indexOfFirstEntry,
        rawReceiptLines.size());

    List<RawPublixReceiptEntry> rawEntries = rawPublixReceiptLineParser.parseRawReceiptLines(
        receiptEntrySection);

    List<PublixReceiptEntry> receiptEntries = rawEntries.stream()
        .map(rawPublixEntryProcessor::process).toList();

    PublixReceiptHeader header = headerProcessor.process(rawHeader);

    return PublixReceipt.builder().header(header).entries(receiptEntries).build();
  }

  private int findFirstEntryLine(List<String> rawReceiptLines) {
    for (int i = 0; i < rawReceiptLines.size(); i++) {
      if (parser.containsPrice(rawReceiptLines.get(i))) {
        return i;
      }
    }
    return -1;
  }

}
