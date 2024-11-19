package kware.grocery.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import kware.grocery.domain.PublixRawReceipt;
import org.springframework.core.io.Resource;

public class PublixReceiptTextReader {

  public PublixRawReceipt readFile(Resource textFileResource) throws IOException {
    File file = textFileResource.getFile();
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    Stream<String> stream = bufferedReader.lines();
    List<String> receiptLines = bufferedReader.lines().toList();
    return PublixRawReceipt.builder().lineEntries(receiptLines).build();
  }
}
