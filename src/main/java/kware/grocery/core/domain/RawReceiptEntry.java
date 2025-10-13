package kware.grocery.core.domain;

import lombok.Data;

@Data
public class RawReceiptEntry {

  private String itemText;
  private double itemPrice;
}
