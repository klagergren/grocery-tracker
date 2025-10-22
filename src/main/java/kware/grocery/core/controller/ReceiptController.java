package kware.grocery.core.controller;

import java.util.List;
import kware.grocery.generated.api.ReceiptApi;
import kware.grocery.generated.model.Receipt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiptController implements ReceiptApi {

  @Override
  public ResponseEntity<String> saveReceipt(Receipt receipt) {
    return ResponseEntity.ok("saved"); //TODO: Implement
  }

  @Override
  public ResponseEntity<List<Receipt>> getReceipts() {
    return ResponseEntity.ok(List.of(Receipt.builder().receiptLines(List.of("hi")).build()));
  }

}
