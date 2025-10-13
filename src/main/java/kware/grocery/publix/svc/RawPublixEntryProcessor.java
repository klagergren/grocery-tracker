package kware.grocery.publix.svc;

import kware.grocery.core.domain.GroceryItem;
import kware.grocery.publix.domain.partial.RawPublixReceiptEntry;
import kware.grocery.publix.domain.processed.PublixReceiptEntry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Slf4j
public class RawPublixEntryProcessor {

  private final PublixItemInfoProcessor itemInfoProcessor;

  public PublixReceiptEntry process(RawPublixReceiptEntry rawEntry) {
    //TODO: For now, only work with one-line items
    if (rawEntry.getEntryLines().size() != 1) {
      log.warn("Skipping multi-line entry");
    }

    //First line of a publix receipt entry is always item info. Price may be contained here
    String itemInfo = rawEntry.getEntryLines().getFirst();
    GroceryItem item = itemInfoProcessor.process(itemInfo);

    //Second line, if present, will either be promotion info or "you saved" info... Will be implemented later
    return null;
  }

//  private PublixReceiptEntry processSimpleEntry(RawPublixReceiptEntry rawPublixReceiptEntry) {
//    String entryText = rawPublixReceiptEntry.getEntryLines().getFirst();
//    Matcher priceMatcher = RegexUtil.pricePattern.matcher(entryText);
//    String priceString;
//    if (priceMatcher.find()) {
//      priceString = priceMatcher.group();
//      if (priceString.contains(",")) {
//        priceString.replace(",", ".");
//      }
//    }
//    Double price = Double.parseDouble(priceString);
//  }
//
//  private Double getPrice(String entryText) {
//    Matcher priceMatcher = RegexUtil.pricePattern.matcher(entryText);
//    String priceString = null;
//    if (priceMatcher.find()) {
//      priceString = priceMatcher.group();
//      if (priceString.contains(",")) {
//        priceString = priceString.replace(",", ".");
//      }
//    } else {
//      throw new IllegalArgumentException(
//          "Publix Simple Entry had no price information: " + entryText);
//    }
//    return priceString;
//  }

//  private PublixReceiptEntry processPromotionEntry(RawPublixReceiptEntry rawPublixReceiptEntry) {
//
//  }
//
//  private PublixReceiptEntry processSavingsEntry(RawPublixReceiptEntry rawPublixReceiptEntry) {
//
//  }

}
