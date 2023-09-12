package cs3500.test;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Time;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class that contains all the methods from the event class
 */
public class EventTest {
  @Test
  public void testEventInitialization() {
    // Arrange
    String name = "Meeting";
    String description = "Team meeting";
    Time startTime = new Time(9, 0); // Assuming Time class is implemented
    int duration = 60;

    // Act
    Event event = new Event(name, description, "monday", startTime, duration);

    // Assert
    Assertions.assertEquals(name, event.getName());
    Assertions.assertEquals(description, event.getDescription());
    Assertions.assertEquals("monday", event.getDay());
  }

  @Test
  public void testEventStartTimeUpdate() {
    // Arrange
    Event event = new Event("Meeting", "Team meeting", "Monday",
        new Time(9, 0), 60);
    Time newStartTime = new Time(9, 0);

    // Assert the start time is the same
    Assertions.assertEquals(newStartTime.getHour(), event.getStartTime().getHour());
  }

  @Test
  public void testToString() {
    Event event = new Event("Meeting", "Team meeting", "Monday",
        new Time(9, 0), 60);
    Assertions.assertEquals("Meeting\nTeam meeting\n09:00\n60", event.toString());
  }

  @Test
  public void testGetDuration() {
    Event event = new Event("Meeting", "Team meeting", "Monday",
        new Time(9, 0), 60);
    Assertions.assertEquals(60, event.getDuration());
  }
}
