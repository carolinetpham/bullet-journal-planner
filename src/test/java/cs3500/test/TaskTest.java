package cs3500.test;

import cs3500.pa05.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class that contains tests for all the methods from the task class
 */
public class TaskTest {
  private Task newTask;

  /**
   * Sets up the task for testing
   */
  @BeforeEach
  public void setup() {
    this.newTask = new Task(
        "Test on Monday",
        "Study for the test on Monday",
        "Monday");
  }

  @Test
  public void testToString() {
    Assertions.assertEquals("Test on Monday\nStudy for the test on Monday",
        this.newTask.toString());
  }

  @Test
  public void testToString2() {
    Assertions.assertEquals("Test on Monday\nStudy for the test on Monday",
        this.newTask.toString());
  }

  @Test
  public void testToStringWrong() {
    Assertions.assertNotEquals("Test on Tuesday\nStudy for the test on Monday",
        this.newTask.toString());
  }

  @Test
  public void testToStringIncomplete() {
    // Create a Task instance with incomplete status
    Task task = new Task("Task 1", "This is a task", "Monday");
    task.setComplete(false);

    // Call the toString() method
    String result = task.toString();

    // Check if the output matches the expected format
    Assertions.assertEquals("Task 1\nThis is a task", result);
  }

  @Test
  public void testToStringComplete() {
    // Create a Task instance with complete status
    Task task = new Task("Task 2", "This is another task", "Tuesday");
    task.setComplete(true);

    // Call the toString() method
    String result = task.toString();

    // Check if the output matches the expected format
    Assertions.assertEquals("Task 2\nThis is another task[COMPLETE]}", result);
  }

  @Test
  public void testIsCompleteFalse() {
    Assertions.assertFalse(this.newTask.isComplete());
  }

  @Test
  public void testIsCompleteTrue() {
    this.newTask.setComplete(true);
    Assertions.assertTrue(this.newTask.isComplete());
  }
}
