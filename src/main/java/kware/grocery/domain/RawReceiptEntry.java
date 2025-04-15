package kware.grocery.domain;

import lombok.Data;

@Data
public class RawReceiptEntry {

  private String itemText;
  private double itemPrice;
}
