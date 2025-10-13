package kware.grocery.publix.svc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import kware.grocery.publix.domain.PublixRawReceipt;
import kware.grocery.publix.svc.readers.PublixReceiptTextReader;
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

//  @Test
//  void regexTest() {
//    Pattern pricePattern = Pattern.compile("\\d+[\\.,]\\d+");
//    String string = "PERDUE CHKN STRPS	10,99 t F";
//    Matcher matcher = pricePattern.matcher(string);
//    if (matcher.find()) {
//      int start = matcher.start();
//      int end = matcher.end();
//    }
//    assertTrue(matcher.find());
//
//  }

}