package kware.grocery.core.domain;

import lombok.Data;

@Data
public class VendorInfo {

  private String name;
  private Address address;
  private int phoneNumber;
}
