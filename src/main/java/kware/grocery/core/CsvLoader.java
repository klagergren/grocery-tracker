package kware.grocery.core;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CsvLoader {

  private CsvMapper csvMapper;
  private CsvSchema csvSchema;

  public void loadCsv() {

  }
}