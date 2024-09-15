package kware.grocery.domain;

import java.util.List;
import kware.grocery.domain.enums.Enhancement;
import kware.grocery.domain.enums.ItemType;
import kware.grocery.domain.enums.Brand;
import lombok.Data;

@Data
public class GroceryItem
{
  ItemType item;
  double weight;
  Brand brand;
  List<Enhancement> enhancements;
}
