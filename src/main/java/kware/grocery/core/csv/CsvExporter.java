package kware.grocery.core.csv;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import java.util.List;
import kware.grocery.core.domain.GroceryItem;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CsvExporter {

  private final CsvMapper csvMapper;

  public void toCsv(List<GroceryItem> groceryItemList) {

  }

}
