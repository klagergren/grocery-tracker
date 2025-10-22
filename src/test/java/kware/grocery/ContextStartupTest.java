package kware.grocery;

import kware.grocery.core.controller.ReceiptController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = AnalyzerConfig.class)
public class ContextStartupTest {

  @Autowired
  private ReceiptController receiptController;

  @Test
  void testStartup() {
    Assertions.assertNotNull(receiptController);
  }
}
