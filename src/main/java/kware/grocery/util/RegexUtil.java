package kware.grocery.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

  public static final Pattern pricePattern = Pattern.compile("\\d+[\\.,]\\d{2}");


  public static boolean containsPrice(String text) {
    Matcher matcher = pricePattern.matcher(text);
    return matcher.find();
  }
}
