package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a time in a day.
 */
public class Time implements Comparable<Time> {

  private int hour;

  private int minute;

  @Override
  public int compareTo(Time o) {
    return (this.hour * 60 + this.minute) - (o.hour * 60 + o.minute);
  }

  public Time(@JsonProperty("hour") int hour, @JsonProperty("minute") int minute) {
    this.hour = hour;
    this.minute = minute;
  }

  /**
   * Returns the hour of this Time.
   *
   * @return the hour of this Time
   */
  public int getHour() {
    return this.hour;
  }

  /**
   * Returns the minute of this Time.
   *
   * @return the minute of this Time
   */
  public int getMinute() {
    return this.minute;
  }

  /**
   * Returns a string representation of the data stored by this Time object.
   *
   * @return a string representation of the data stored by this Time object
   */
  @Override
  public String toString() {
    String m =
        this.minute < 10 ? 0 + String.valueOf(this.minute) : String.valueOf(this.minute);
    String h =
        this.hour < 10 ? 0 + String.valueOf(this.hour) : String.valueOf(this.hour);
    return h + ":" + m;
  }
}
