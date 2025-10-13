package kware.grocery.publix.domain;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublixRawReceipt {

  private List<String> lineEntries;
}
