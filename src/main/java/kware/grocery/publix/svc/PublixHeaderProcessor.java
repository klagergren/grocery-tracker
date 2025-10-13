package kware.grocery.publix.svc;

import kware.grocery.publix.domain.partial.RawHeader;
import kware.grocery.publix.domain.processed.PublixReceiptHeader;
import org.springframework.stereotype.Component;

@Component
public class PublixHeaderProcessor {

  public PublixReceiptHeader process(RawHeader rawHeader) {
    //TODO: Fix spelling before returning header. Use a dictionary of common store names?
    String storeName = rawHeader.getHeaderLines().get(0).trim();
    String storeDescription = rawHeader.getHeaderLines().get(1).trim();

    String storeManagerLine = rawHeader.getHeaderLines().get(4);
    String managerName = storeManagerLine.split(":")[1].trim();
    String phoneNumber = rawHeader.getHeaderLines().get(5).trim();

    //@formatter:off
    return PublixReceiptHeader.builder()
        .storeName(storeName)
        .storeDescription(storeDescription)
        .storeManager(managerName)
        .phoneNumber(phoneNumber)
        .build();
    //@formatter:on
  }
}
