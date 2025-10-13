package kware.grocery.util;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ParseResult {

  String description;
  Double price;
}
