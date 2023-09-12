package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Json view of a BuJo week
 *
 * @param days      the days in a week
 * @param maxTasks  the max number of tasks per day
 * @param maxEvents the max number of events per day
 * @param theme     the current theme of the BuJo
 */
public record WeekJson(@JsonProperty("days") DayJson[] days,
                       @JsonProperty("max-tasks") int maxTasks,
                       @JsonProperty("max-events") int maxEvents,
                       @JsonProperty("theme") String theme,
                       @JsonProperty("month") String month,
                       @JsonProperty("week-of") String weekOf) {

  /**
   * Returns the week represented by this Json
   *
   * @return the week represented by this Json
   */
  public Week toWeek() {
    Week week = new Week(this.month, this.weekOf, this.maxTasks, this.maxEvents, this.theme);
    for (DayJson day : this.days) {
      week.addDay(day.toDay());
    }
    return week;
  }
}
