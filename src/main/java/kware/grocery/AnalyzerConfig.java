package kware.grocery;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import kware.grocery.core.csv.CsvExporter;
import kware.grocery.core.domain.GroceryItem;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class AnalyzerConfig {

  //TODO: Uncomment and fix
//  @Bean
//  public CsvLoader csvLoader(CsvMapper csvMapper) {
//    return new CsvLoader(csvMapper);
//  }

  @Bean
  public CsvExporter csvExporter(CsvMapper csvMapper) {
    return new CsvExporter(csvMapper);
  }

  @Bean
  public CsvMapper csvMapper() {
    return new CsvMapper();
  }

  @Bean
  public CsvSchema csvSchema(CsvMapper mapper) {
    return mapper.schemaFor(GroceryItem.class);
  }

}
