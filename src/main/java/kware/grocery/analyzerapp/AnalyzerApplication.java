package kware.grocery.analyzerapp;

import kware.grocery.AnalyzerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AnalyzerConfig.class)
public class AnalyzerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AnalyzerApplication.class, args);
  }

}
