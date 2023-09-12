package cs3500.test;

import cs3500.pa05.model.Time;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class that contains all the tests for the methods of the Time class.
 */
public class TimeTest {
  private Time newTime;

  @BeforeEach
  public void setUp() {
    newTime = new Time(10, 20);
  }

  @Test
  public void testGetHour() {
    Assertions.assertEquals(10, newTime.getHour());
    Assertions.assertNotEquals(20, newTime.getHour());
  }

  @Test
  public void testGetMinute() {
    Assertions.assertNotEquals(10, newTime.getMinute());
    Assertions.assertEquals(20, newTime.getMinute());
  }

  @Test
  public void testCompareTo() {
    Assertions.assertEquals(0, newTime.compareTo(new Time(10, 20)));
    Assertions.assertNotEquals(0, newTime.compareTo(new Time(10, 30)));
  }

  @Test
  public void testToString() {
    Assertions.assertEquals("10:20", newTime.toString());
  }
}
