package kware.grocery.publix.domain.partial;

import java.util.List;
import lombok.Data;

@Data
public class FirstDraftReceipt {

  private RawHeader header;
  private List<RawPublixReceiptEntry> rawPublixReceiptEntries;
}
