package kware.grocery.domain.publix;

import kware.grocery.domain.enums.Brand;
import kware.grocery.domain.enums.ItemType;
import lombok.Data;

@Data
public class PublixReceiptEntry {

  private String itemText;
  private ItemType item;
  private Brand brand;
  private double price;
  private PublixPromotion publixPromotion;
  private PublixSavingsInfo publixSavingsInfo;

}
