package kware.grocery.core.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import kware.grocery.core.enums.Brand;
import kware.grocery.core.enums.ItemType;
import kware.grocery.core.enums.Store;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonPropertyOrder({"item", "weight", "brand", "store"})
public class GroceryItem {

  String itemString;
  Double price;
  ItemType item;
  Double weightLbs;
  Brand brand;
  Store store;
//  List<Enhancement> enhancements;
}
