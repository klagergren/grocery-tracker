package kware.grocery.domain;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublixRawReceipt {

  List<String> lineEntries;
}
