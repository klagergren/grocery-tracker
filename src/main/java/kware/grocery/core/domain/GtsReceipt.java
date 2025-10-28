package kware.grocery.core.domain;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GtsReceipt {
  //TODO: Implement. Add all data you want to store for general processed receipt items

  private String id;
  private VendorInfo vendorInfo;
  private Instant date;
  private List<ReceiptEntry> entries;
}
