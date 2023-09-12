package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents in an event in a day.
 */
public class Event extends Commitment {

  private final Time startTime;

  // Duration in minutes
  private final int duration;

  /**
   * Constructs an event with the given name, description, day, start time, and duration.
   *
   * @param name        the event's name
   * @param description the event's description
   * @param day         the day of the event
   * @param startTime   the start time of the event
   * @param duration    the duration of the event
   */
  public Event(@JsonProperty("name") String name, @JsonProperty("description") String description,
               @JsonProperty("day") String day, @JsonProperty("start-time") Time startTime,
               @JsonProperty("duration") int duration) {
    super(name, description, day);
    this.startTime = startTime;
    this.duration = duration;
  }

  /**
   * Returns a string representation of the data stored by this Event object.
   *
   * @return a string representation of the data stored by this Event object
   */
  @Override
  public String toString() {
    return this.getName() + "\n" + this.getDescription() + "\n" + this.startTime.toString() + "\n"
        + this.duration;
  }

  /**
   * getter method for this startTime
   *
   * @return a Time object representing the start time of this event
   */
  public Time getStartTime() {
    return startTime;
  }

  /**
   * Returns the duration of this Event
   *
   * @return the duration of this Event
   */
  public int getDuration() {
    return duration;
  }
}
