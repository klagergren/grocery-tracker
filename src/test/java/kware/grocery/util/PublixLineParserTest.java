package kware.grocery.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class PublixLineParserTest {

  private PublixLineParser sut = new PublixLineParser();

  @Test
  void testPricePattern() {
    assertTrue(sut.containsPrice("asdf 5.37"));
    assertTrue(sut.containsPrice("123.45"));
    assertFalse(sut.containsPrice("100"));
    assertFalse(sut.containsPrice("12.3"));
    assertTrue(sut.containsPrice("12.345"));
    assertTrue(sut.containsPrice("abc12.34def"));
    assertTrue(sut.containsPrice("12,34"));
    assertTrue(sut.containsPrice("0.00"));
    assertTrue(sut.containsPrice("1000.00"));
  }

  @Test
  void testParse() {
    assertEquals(Optional.of(ParseResult.builder().description("asdf").price(5.37).build()),
        sut.parse("asdf 5.37"));
    assertEquals(Optional.of(ParseResult.builder().description("").price(123.45).build()),
        sut.parse("123.45"));
    assertEquals(Optional.empty(), sut.parse("100"));
    assertEquals(Optional.empty(), sut.parse("12.3"));
    assertEquals(Optional.of(ParseResult.builder().description("").price(12.34).build()),
        sut.parse("12.345"));
    assertEquals(Optional.of(ParseResult.builder().description("abc").price(12.34).build()),
        sut.parse("abc12.34def"));
    assertEquals(Optional.of(ParseResult.builder().description("").price(12.34).build()),
        sut.parse("12,34"));
    assertEquals(Optional.of(ParseResult.builder().description("").price(0.00).build()),
        sut.parse("0.00"));
    assertEquals(Optional.of(ParseResult.builder().description("").price(1000.0).build()),
        sut.parse("1000.00"));
  }
}