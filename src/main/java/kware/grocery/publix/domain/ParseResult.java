package kware.grocery.publix.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ParseResult {

  String description;
  Double price;
}
