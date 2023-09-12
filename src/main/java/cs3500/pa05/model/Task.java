package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a task in a day.
 */
public class Task extends Commitment {

  private boolean complete = false;

  /**
   * Constructs a task with the given name, description, and day.
   *
   * @param name        the task's name
   * @param description the task's description
   * @param day         the day of the task
   */
  public Task(@JsonProperty("name") String name, @JsonProperty("description") String description,
              @JsonProperty("day") String day) {
    super(name, description, day);
  }

  /**
   * Returns a string representation of the data stored by this Task object.
   *
   * @return a string representation of the data stored by this Task object
   */
  @Override
  public String toString() {
    return this.getName() + "\n" + this.getDescription() + (this.complete ? "[COMPLETE]}" : "");
  }

  /**
   * Returns the value of this task's completed status.
   *
   * @return the value of this task's completed status
   */
  public boolean isComplete() {
    return this.complete;
  }

  /**
   * Sets the value of this Task object's complete field to the given value.
   *
   * @param complete weather this task is complete
   */
  public void setComplete(boolean complete) {
    this.complete = complete;
  }
}
