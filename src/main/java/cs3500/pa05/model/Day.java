package cs3500.pa05.model;

import java.util.ArrayList;

/**
 * Represents a day in a week.
 */
public class Day {
  private final String name;

  private final ArrayList<Task> tasks;

  private final ArrayList<Event> events;

  /**
   * Constructs a day with the given name.
   *
   * @param name the day's name
   */
  public Day(String name) {
    this.name = name;
    this.tasks = new ArrayList<>();
    this.events = new ArrayList<>();
  }

  /**
   * Returns the name of this day
   *
   * @return the name of this day
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns this day's tasks.
   *
   * @return this day's tasks
   */
  public ArrayList<Task> getTasks() {
    return this.tasks;
  }

  /**
   * Returns this day's events.
   *
   * @return this day's events
   */
  public ArrayList<Event> getEvents() {
    return this.events;
  }

  /**
   * Returns the index of this day given its name
   *
   * @param name of the day
   * @return the index of this day given its name
   */
  public static int getDayIndex(String name) {
    return switch (name.toLowerCase()) {
      case "monday" -> 0;
      case "tuesday" -> 1;
      case "wednesday" -> 2;
      case "thursday" -> 3;
      case "friday" -> 4;
      case "saturday" -> 5;
      case "sunday" -> 6;
      default -> throw new IllegalArgumentException("No such day");
    };
  }

  /**
   * Adds a task to this day
   *
   * @param task the task
   */
  public void addTask(Task task) {
    this.tasks.add(task);
  }

  /**
   * Adds an event to this day
   *
   * @param event the event
   */
  public void addEvent(Event event) {
    this.events.add(event);
  }
}
