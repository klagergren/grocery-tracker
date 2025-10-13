package kware.grocery.publix.domain.processed;

import kware.grocery.core.domain.Address;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PublixReceiptHeader {

  private String storeName;
  private String storeDescription;
  private Address address;
  private String storeManager;
  private String phoneNumber;

}
