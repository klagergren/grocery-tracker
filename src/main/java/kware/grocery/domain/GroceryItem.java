package kware.grocery.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import kware.grocery.domain.enums.Brand;
import kware.grocery.domain.enums.ItemType;
import kware.grocery.domain.enums.Store;
import lombok.Data;

@Data
@JsonPropertyOrder({"item", "weight", "brand", "store"})
public class GroceryItem {

  ItemType item;
  double weight;
  Brand brand;
  Store store;
//  List<Enhancement> enhancements;
}
