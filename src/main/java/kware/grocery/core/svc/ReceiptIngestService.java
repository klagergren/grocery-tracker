package kware.grocery.core.svc;

import io.micrometer.common.util.StringUtils;
import java.util.UUID;
import kware.grocery.core.storage.ReceiptStore;
import kware.grocery.generated.model.Receipt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ReceiptIngestService {

  private final ReceiptStore receiptStore;

  public String storeReceipt(Receipt receipt) {
    if (StringUtils.isEmpty(receipt.getId())) {
      receipt.setId(UUID.randomUUID().toString());
    }
    receiptStore.saveReceipt(receipt);
    return receipt.getId();
  }

}
