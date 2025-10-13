package kware.grocery.publix.domain.partial;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RawHeader {

  private List<String> headerLines;
}
