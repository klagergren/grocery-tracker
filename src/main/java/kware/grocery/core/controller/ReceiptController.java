package kware.grocery.core.controller;

import java.util.List;
import java.util.Optional;
import kware.grocery.core.storage.ReceiptStore;
import kware.grocery.core.svc.ReceiptProcessor;
import kware.grocery.generated.api.ReceiptApi;
import kware.grocery.generated.model.Receipt;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ReceiptController implements ReceiptApi {

  private final ReceiptProcessor receiptProcessor;
  private final ReceiptStore receiptStore;

  @Override
  public ResponseEntity<String> saveReceipt(Receipt receipt) {
    String id = receiptProcessor.storeReceipt(receipt);
    return ResponseEntity.ok(id);
  }

  @Override
  public ResponseEntity<List<Receipt>> getReceipts() {
    List<Receipt> allReceipts = receiptStore.getAllReceipts();
    return ResponseEntity.ok(allReceipts);
  }

  public ResponseEntity<Receipt> getReceiptById(String id) {
    Optional<Receipt> receipt = receiptStore.getReceiptById(id);
    return receipt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

}
