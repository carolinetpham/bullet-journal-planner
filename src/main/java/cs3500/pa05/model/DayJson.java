package cs3500.pa05.model;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;

/**
 * Represents a Json view of a day.
 */
public record DayJson(String name, TaskJson[] tasks, EventJson[] events) {

  /**
   * Returns the day represented by this Json
   *
   * @return the day represented by this Json
   */
  public Day toDay() {
    Day day = new Day(this.name);
    for (TaskJson task : this.tasks) {
      day.addTask(task.toTask());
    }
    for (EventJson event : this.events) {
      day.addEvent(event.toEvent());
    }
    return day;
  }
}
