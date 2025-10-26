package kware.grocery.storage.mem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import kware.grocery.core.storage.ReceiptStore;
import kware.grocery.generated.model.Receipt;
import org.springframework.stereotype.Component;

@Component
public class InMemoryReceiptStore implements ReceiptStore {

  private final Map<String, Receipt> receiptMap = new HashMap<>();

  @Override
  public void saveReceipt(Receipt receipt) {
    receiptMap.put(receipt.getId(), receipt);
  }

  @Override
  public List<Receipt> getAllReceipts() {
    //TODO: Return in predictable order? First by date and then by store
    return receiptMap.values().stream().toList();
  }

  @Override
  public Optional<Receipt> getReceiptById(String id) {
    return Optional.ofNullable(receiptMap.get(id));
  }
}
