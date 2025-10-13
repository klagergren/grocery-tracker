package kware.grocery.publix.svc;

import kware.grocery.core.domain.GroceryItem;
import kware.grocery.publix.domain.ParseResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PublixItemInfoProcessor {

  private PublixLineParser publixLineParser;

  public GroceryItem process(String itemInfoReceiptLine) {
    ParseResult parseResult = publixLineParser.parse(itemInfoReceiptLine).orElseThrow();
    String description = parseResult.getDescription();
    Double price = parseResult.getPrice();

    return GroceryItem.builder().itemString(description).price(price).build();
  }
}
