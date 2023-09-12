package cs3500.pa05.model;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Json view of an Event
 *
 * @param name        the name of the event
 * @param description the description of the event
 * @param day         the day of the event
 * @param time        the time of the event
 * @param duration    the duration of the event
 */
public record EventJson(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("day") String day,
    @JsonProperty("start-time") TimeJson time,
    @JsonProperty("duration") int duration) {

  public Event toEvent() {
    return new Event(name, description, day, time.toTime(), duration);
  }
}
