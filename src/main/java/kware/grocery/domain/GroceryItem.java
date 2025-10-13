package kware.grocery.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import kware.grocery.domain.enums.Brand;
import kware.grocery.domain.enums.ItemType;
import kware.grocery.domain.enums.Store;
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
