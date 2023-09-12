package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Json view of a Time
 *
 * @param hour   the hour of the time
 * @param minute the minute of the time
 */
public record TimeJson(
    @JsonProperty("hour") int hour,
    @JsonProperty("minute") int minute) {

  public Time toTime() {
    return new Time(hour, minute);
  }
}
