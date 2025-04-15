package kware.grocery.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import kware.grocery.domain.RawPublixReceiptEntry;
import kware.grocery.util.RegexUtil;

public class RawPublixReceiptLineParser {

  private static final int NUM_LINES_TO_CONSIDER = 3;
  private static final String PUBLIX_PROMOTION_STRING = "PROMOTION";
  private static final String PUBLIX_SAVING_INFO_STRING = "You Saved";

  public List<RawPublixReceiptEntry> parseRawReceiptLines(List<String> receiptItemLines) {

    int numLines = receiptItemLines.size();
    int i = 0;
    List<RawPublixReceiptEntry> rawEntries = new ArrayList<>();
    while (i < numLines) {
      List<String> entryCandidates = buildEntryCandidates(i, receiptItemLines);
      RawPublixReceiptEntry rawEntry = buildRawEntry(entryCandidates);
      rawEntries.add(rawEntry);

      //Advance index based on entry size
      int delta = rawEntry.getEntryLines().size();
      i = i + delta;
    }
    return rawEntries;
  }

  private List<String> buildEntryCandidates(int startingLineNum, List<String> allLines) {
    return IntStream.range(0, NUM_LINES_TO_CONSIDER).map(i -> i + startingLineNum)
        .filter(i -> i < allLines.size()).boxed().map(allLines::get).toList();
  }

  private RawPublixReceiptEntry buildRawEntry(List<String> receiptLines) {

    List<String> entryLines = new ArrayList<>();
    String firstLine = receiptLines.get(0);
    entryLines.add(firstLine);

    if (receiptLines.size() > 1) {
      String secondLine = receiptLines.get(1);
      if (lineContainsNoPrice(firstLine) || lineIsPromotion(secondLine) || lineIsSavingInfoLine(
          secondLine)) {
        entryLines.add(secondLine);
      }
    }

    if (receiptLines.size() > 2) {
      String thirdLine = receiptLines.get(2);
      if (lineIsPromotion(thirdLine) || lineIsSavingInfoLine(thirdLine)) {
        entryLines.add(thirdLine);
      }
    }
    return RawPublixReceiptEntry.builder().entryLines(entryLines).build();
  }


  private boolean lineIsPromotion(String line) {
    return line.toUpperCase().contains(PUBLIX_PROMOTION_STRING);
  }

  private boolean lineIsSavingInfoLine(String line) {
    return line.contains(PUBLIX_SAVING_INFO_STRING);
  }

  private boolean lineContainsNoPrice(String line) {
    return !RegexUtil.containsPrice(line);
  }

}
