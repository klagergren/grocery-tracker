package kware.grocery.readers.publix;

import kware.grocery.domain.GroceryItem;
import kware.grocery.util.ParseResult;
import kware.grocery.util.PublixLineParser;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PublixItemInfoProcessor {

  private PublixLineParser publixLineParser;

  public GroceryItem process(String itemInfoReceiptLine) {
    ParseResult parseResult = publixLineParser.parse(itemInfoReceiptLine).orElseThrow();
    String description = parseResult.getDescription();
    Double price = parseResult.getPrice();

    return GroceryItem.builder().itemString(description).price(price).build();
  }
}
