package kware.grocery.publix.domain.processed;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PublixReceipt {

  private PublixReceiptHeader header;
  private List<PublixReceiptEntry> entries;
}
