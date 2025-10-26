package kware.grocery.core.storage;

import java.util.List;
import java.util.Optional;
import kware.grocery.generated.model.Receipt;

public interface ReceiptStore {

  void saveReceipt(Receipt receipt);
  List<Receipt> getAllReceipts();
  Optional<Receipt> getReceiptById(String id);


}
