package cs3500.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Theme;
import cs3500.pa05.model.Week;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class that contains tests for all the methods from the week class
 */
public class WeekTest {
  Week newWeek;

  @BeforeEach
  public void setUp() {
    newWeek = new Week();
  }

  @Test
  public void testGetDays() {
    Assertions.assertEquals(7, newWeek.getDays().length);
  }

  @Test
  public void testGetMonth() {
    Assertions.assertEquals("January", newWeek.getMonth());
  }

  @Test
  public void testGetWeekOf() {
    Assertions.assertEquals("Jan 1", newWeek.getWeekOf());
  }

  @Test
  public void testGetTheme() {
    Assertions.assertEquals(Theme.DEFAULT, newWeek.getTheme());
  }

  @Test
  public void testSetMonth() {
    newWeek.setMonth("February");
    Assertions.assertEquals("February", newWeek.getMonth());
  }

  @Test
  public void testSetMaxTasks() {
    newWeek.setMaxTasks(5);
    Assertions.assertEquals(5, newWeek.getMaxTasks());
  }

  @Test
  public void testSetMaxEvents() {
    newWeek.setMaxEvents(5);
    Assertions.assertEquals(5, newWeek.getMaxEvents());
  }

  @Test
  public void testAddDay() {
    Week week = new Week("test");
    // Create a Day object for testing
    Day day = new Day("Monday");

    // Add the day to the week
    week.addDay(day);

    // Verify that the day was added successfully
    Assertions.assertEquals(day, week.getDays()[0]);
  }

  @Test
  public void testAddDay_WeekFull() {
    Week week = new Week();

    // Fill up the week with dummy days
    for (int i = 0; i < week.getDays().length; i++) {
      assertThrows(IllegalStateException.class, () -> week.addDay(new Day("Dummy")));
    }
  }

  @Test
  public void testSecondConstructor() {
    Week week = new Week("test");

    // Verify that the days array is initialized
    Assertions.assertNotNull(week.getDays());
    Assertions.assertEquals(7, week.getDays().length);

    // Verify that the maxEvents and maxTasks are set to -1
    Assertions.assertEquals(-1, week.getMaxEvents());
    Assertions.assertEquals(-1, week.getMaxTasks());

    // Verify that the theme is set to the default theme
    Assertions.assertEquals(Theme.DEFAULT, week.getTheme());

    // Verify that the month and weekOf are set to their default values
    Assertions.assertEquals("January", week.getMonth());
    Assertions.assertEquals("Jan 1", week.getWeekOf());
  }

  @Test
  public void testGetDays2() {
    Week week = new Week();
    Day[] days = week.getDays();

    // Verify that the returned array is not null
    Assertions.assertNotNull(days);

    // Verify that the length of the array is 7
    Assertions.assertEquals(7, days.length);

    // Verify that each element in the array is not null
    for (Day day : days) {
      Assertions.assertNotNull(day);
    }
  }

  @Test
  public void testSetMonth2() {
    Week week = new Week();
    week.setMonth("February");

    // Verify that the month is set correctly
    Assertions.assertEquals("February", week.getMonth());
  }

  @Test
  public void testSetMaxEvents2() {
    Week week = new Week();
    week.setMaxEvents(5);

    // Verify that the maxEvents is set correctly
    Assertions.assertEquals(5, week.getMaxEvents());
  }

  @Test
  public void testSetMaxTasks2() {
    Week week = new Week();
    week.setMaxTasks(10);

    // Verify that the maxTasks is set correctly
    Assertions.assertEquals(10, week.getMaxTasks());
  }

  @Test
  public void testConstructor2() {
    Week newWeek = new Week("February", "Feb 1", 10, 5,
        "DEFAULT");
    Assertions.assertEquals(newWeek.getWeekOf(), "Feb 1");
  }
}
