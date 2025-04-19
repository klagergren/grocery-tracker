package kware.grocery.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import kware.grocery.domain.publix.RawPublixReceiptEntry;
import kware.grocery.readers.publix.RawPublixReceiptLineParser;
import org.junit.jupiter.api.Test;


class RawPublixReceiptLineParserTest {

  private static final String line1 = "PUB STM PEAS GREEN	2,79 t F";
  private static final String line2 = "PERDUE CHKN STRPS 10,99 t F";
  private static final String line3 = "PHIL CREAM CHEESE";
  private static final String line4 = "1 @ 2 FOR	5,00	2,50 t F";
  private static final String line5 = "You Saved 0.92";
  private static final String line6 = "PUB PEANUT DIL 4.99 1: F";
  private static final String line7 = "You Saved 1.00";
  private static final String line8 = "GM BLNDS BB/BAN 7,79 %. F";
  private static final String line9 = "Promotion -3.90 t F";
  private static final String line10 = "D/H CARROT CAKE MX 2,69 F";


  private final RawPublixReceiptLineParser sut = new RawPublixReceiptLineParser();

  @Test
  void testParseReceiptEntries() {
    List<String> lines = List.of(line1, line2, line3, line4, line5, line6, line7, line8, line9,
        line10);

    List<RawPublixReceiptEntry> entries = sut.parseRawReceiptLines(lines);

    RawPublixReceiptEntry expectedEntry1 = RawPublixReceiptEntry.builder()
        .entryLines(List.of(line1)).build();
    RawPublixReceiptEntry expectedEntry2 = RawPublixReceiptEntry.builder()
        .entryLines(List.of(line2)).build();
    RawPublixReceiptEntry expectedEntry3 = RawPublixReceiptEntry.builder()
        .entryLines(List.of(line3, line4, line5)).build();
    RawPublixReceiptEntry expectedEntry4 = RawPublixReceiptEntry.builder()
        .entryLines(List.of(line6, line7)).build();
    RawPublixReceiptEntry expectedEntry5 = RawPublixReceiptEntry.builder()
        .entryLines(List.of(line8, line9)).build();
    RawPublixReceiptEntry expectedEntry6 = RawPublixReceiptEntry.builder()
        .entryLines(List.of(line10)).build();

    List<RawPublixReceiptEntry> expectedEntries = List.of(expectedEntry1, expectedEntry2,
        expectedEntry3, expectedEntry4, expectedEntry5, expectedEntry6);

    assertEquals(expectedEntries, entries);

    assertEquals(6, entries.size());
  }
}
