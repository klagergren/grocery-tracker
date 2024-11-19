package kware.grocery.core;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import kware.grocery.domain.PublixRawReceipt;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

class PublixReceiptTextReaderTest {

  @Test
  void testReadReceipt() throws IOException {
    PublixReceiptTextReader reader = new PublixReceiptTextReader();
    //TODO Figure out why 'classpath:/..' doesn't work when loading the resource. Make sure I can load this in a spring test too
    Resource fileResource = new ClassPathResource(
        "sampledata/samplePublix.txt");
    PublixRawReceipt receipt = reader.readFile(fileResource);
    assertNotNull(receipt);
  }

}