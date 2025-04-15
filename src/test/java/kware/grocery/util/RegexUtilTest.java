package kware.grocery.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RegexUtilTest {

  @Test
  void testPricePattern() {
    assertTrue(RegexUtil.containsPrice("asdf 5.37"));
    assertTrue(RegexUtil.containsPrice("123.45"));
    assertFalse(RegexUtil.containsPrice("100"));
    assertFalse(RegexUtil.containsPrice("12.3"));
    assertTrue(RegexUtil.containsPrice("12.345"));
    assertTrue(RegexUtil.containsPrice("abc12.34def"));
    assertTrue(RegexUtil.containsPrice("12,34"));
    assertTrue(RegexUtil.containsPrice("0.00"));
    assertTrue(RegexUtil.containsPrice("1000.00"));
  }
}