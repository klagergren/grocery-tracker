package kware.grocery.core.domain;

import lombok.Data;

@Data
public class Address {

  private int streetNumber;
  private String streetName;
  private String city;
  private String state;
  private int zip;
}
