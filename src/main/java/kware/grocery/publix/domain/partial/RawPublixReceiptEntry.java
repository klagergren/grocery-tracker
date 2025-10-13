package kware.grocery.publix.domain.partial;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RawPublixReceiptEntry {

  private List<String> entryLines;
}
