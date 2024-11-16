package kware.grocery.core;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import java.util.List;
import kware.grocery.domain.GroceryItem;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CsvExporter {

  private final CsvMapper csvMapper;

  public void toCsv(List<GroceryItem> groceryItemList) {

  }

}
