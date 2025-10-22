package kware.grocery.core.controller;

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

}
