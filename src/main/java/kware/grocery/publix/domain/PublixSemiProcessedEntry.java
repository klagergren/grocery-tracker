package kware.grocery.publix.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublixSemiProcessedEntry {

  private String itemInfo;
  private String promotionInfo;
  private String savingInfo;
}
