package kware.grocery.core.domain;

import kware.grocery.core.enums.Brand;
import kware.grocery.core.enums.ItemType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReceiptEntry {
  private ItemType itemType;
  private Brand brand;
  //TODO: Add other information you want to generally store about receipt entries like weight and name?
}
