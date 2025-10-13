package kware.grocery.util;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PublixLineParser {

  public static final Pattern PRICE_PATTERN = Pattern.compile("(\\d+[.,]\\d{2})");


  public boolean containsPrice(String text) {
    Matcher matcher = PRICE_PATTERN.matcher(text);
    return matcher.find();
  }

  public Optional<ParseResult> parse(String line) {
    Matcher matcher = PRICE_PATTERN.matcher(line);

    // We use find() rather than matches() because the pattern is only a substring.
    // We look for the LAST match, as the price is typically near the end of the line.
    String rawPriceString = null;
    int priceStartIndex = -1;
    while (matcher.find()) {
      // Get the raw price string (e.g., "4.99" or "10,99") from the captured group
      rawPriceString = matcher.group(1);
      priceStartIndex = matcher.start(1);
    }

    Optional<ParseResult> parseResultOpt = Optional.empty();
    if (Objects.nonNull(rawPriceString)) {
      Optional<Double> price = extractPrice(rawPriceString);
      String description = line.substring(0, priceStartIndex).trim();
      ParseResult parseResult = ParseResult.builder().description(description).build();
      price.ifPresent(parseResult::setPrice);
      parseResultOpt = Optional.of(parseResult);
    }
    return parseResultOpt;
  }

  private Optional<Double> extractPrice(String rawPriceString) {
    try {
      // 1. Standardize the decimal separator.
      // Double expects a period (.) for its String constructor.
      String standardizedPrice = rawPriceString.replace(',', '.');

      Double d = Double.parseDouble(standardizedPrice);
      return Optional.of(d);

    } catch (NumberFormatException e) {
      // This generally shouldn't happen if the regex worked, but included for robustness.
      System.err.println("Error parsing price string '" + rawPriceString + "': " + e.getMessage());
      return Optional.empty();
    }
  }


}
