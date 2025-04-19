package kware.grocery.domain.publix;

import java.util.List;
import lombok.Data;

@Data
public class PublixReceiptEntry {

  String itemText;
  double price;
  List<String> extraInfo;
}
