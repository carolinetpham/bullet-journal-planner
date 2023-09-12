package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Json view of a Task
 *
 * @param name        the name of the task
 * @param description the description of the task
 * @param day         the day of the task
 * @param complete    whether the task is complete
 */
public record TaskJson(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("day") String day,
    @JsonProperty("complete") boolean complete) {

  public Task toTask() {
    return new Task(name, description, day);
  }
}
