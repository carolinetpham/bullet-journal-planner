package cs3500.test;

import cs3500.pa05.model.Theme;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class that contains tests for the Theme enum
 */
public class ThemeTest {
  @Test
  void testToString() {
    Assertions.assertEquals("DEFAULT", Theme.DEFAULT.toString());
    Assertions.assertEquals("DARK", Theme.DARK.toString());
    Assertions.assertEquals("COLORFUL", Theme.COLORFUL.toString());
  }

  @Test
  void testFromString() {
    Assertions.assertEquals(Theme.DEFAULT, Theme.fromString("DEFAULT"));
    Assertions.assertEquals(Theme.DARK, Theme.fromString("DARK"));
    Assertions.assertEquals(Theme.COLORFUL, Theme.fromString("COLORFUL"));
  }

  @Test
  void testFromStringThrowsException() {
    Assertions.assertThrows(IllegalArgumentException.class, () ->
        Theme.fromString("INVALID"));
  }

  @Test
  public void testValues() {
    Theme[] themes = Theme.values();

    // Verify that the array has the correct length
    Assertions.assertEquals(3, themes.length);

    // Verify that each theme in the array is not null
    for (Theme theme : themes) {
      Assertions.assertNotNull(theme);
    }
  }

  @Test
  public void testValueOf() {
    Theme theme1 = Theme.valueOf("DEFAULT");
    Theme theme2 = Theme.valueOf("DARK");
    Theme theme3 = Theme.valueOf("COLORFUL");

    // Verify that the correct theme is returned for each value
    Assertions.assertEquals(Theme.DEFAULT, theme1);
    Assertions.assertEquals(Theme.DARK, theme2);
    Assertions.assertEquals(Theme.COLORFUL, theme3);
  }
}
