package kware.grocery.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kware.grocery.domain.PublixRawReceipt;
import kware.grocery.domain.PublixReceiptEntry;
import org.springframework.core.io.Resource;

public class PublixReceiptTextReader {

  private static Pattern pricePattern = Pattern.compile("\\d+[\\.,]\\d+");

  public PublixRawReceipt readFile(Resource textFileResource) throws IOException {
    File file = textFileResource.getFile();
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    List<String> receiptLines = bufferedReader.lines().toList();
    return PublixRawReceipt.builder().lineEntries(receiptLines).build();
  }

  protected List<PublixReceiptEntry> parseLines(List<String> receiptLines) {
    List<PublixReceiptEntry> receiptEntries = new ArrayList<>();
    Iterator<String> receiptLineIterator = receiptLines.iterator();
    while (receiptLineIterator.hasNext()) {
      //TODO Find first entry

      String line = receiptLineIterator.next();
      Matcher matcher = pricePattern.matcher(line);
      if (matcher.find()) {

      }
      if (hasPrice(line)) {
        receiptEntries.add(basicParse(line));
      } else {

      }
    }
    return null;

  }

  private boolean hasPrice(String receiptLine) {
    return false;
  }

  private PublixReceiptEntry basicParse(String receiptLine) {
//    receiptLine.split();
    return null;
  }


}
