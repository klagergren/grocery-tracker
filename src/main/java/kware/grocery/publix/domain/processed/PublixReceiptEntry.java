package kware.grocery.publix.domain.processed;

import kware.grocery.core.enums.Brand;
import kware.grocery.core.enums.ItemType;
import kware.grocery.publix.domain.PublixPromotion;
import kware.grocery.publix.domain.PublixSavingsInfo;
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
