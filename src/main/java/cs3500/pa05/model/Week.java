package cs3500.pa05.model;

/**
 * Represents a week in a Java Bullet Journal
 */
public class Week {
  private Day[] days;

  // If maxEvents or maxTasks is -1, then there is no limit
  private int maxEvents;

  // If maxEvents or maxTasks is -1, then there is no limit
  private int maxTasks;

  private Theme theme = Theme.DEFAULT;

  private String month = "January";

  private String weekOf = "Jan 1";

  /**
   * Creates a week with the default settings.
   */
  public Week() {
    this.days = new Day[7];
    this.maxEvents = -1;
    this.maxTasks = -1;

    initDays();
  }

  /**
   * Creates a week with the default settings for testing.
   */
  public Week(String test) {
    this.days = new Day[7];
    this.maxEvents = -1;
    this.maxTasks = -1;

  }

  /**
   * Creates a week with the given settings.
   *
   * @param month     the month of this week
   * @param weekOf    the week of this week
   * @param maxTasks  the max number of tasks per day
   * @param maxEvents the max number of events per day
   * @param theme     the theme of this week
   */
  public Week(String month, String weekOf, int maxTasks, int maxEvents, String theme) {
    this.days = new Day[7];
    this.maxEvents = maxEvents;
    this.maxTasks = maxTasks;
    this.theme = Theme.valueOf(theme);
    this.month = month;
    this.weekOf = weekOf;
  }

  /**
   * Populates this week's days with emote days
   */
  private void initDays() {
    this.days[0] = new Day("Monday");
    this.days[1] = new Day("Tuesday");
    this.days[2] = new Day("Wednesday");
    this.days[3] = new Day("Thursday");
    this.days[4] = new Day("Friday");
    this.days[5] = new Day("Saturday");
    this.days[6] = new Day("Sunday");
  }

  /**
   * Returns the days in this week
   *
   * @return the days in this week
   */
  public Day[] getDays() {
    return this.days;
  }

  /**
   * Sets the value of this week's month to the given value
   */
  public void setMonth(String month) {
    this.month = month;
  }

  /**
   * Returns the max number of events for this week
   *
   * @return the max number of events for this week
   */
  public int getMaxEvents() {
    return this.maxEvents;
  }

  /**
   * Returns the max number of tasks for this week
   *
   * @return the max number of tasks for this week
   */
  public int getMaxTasks() {
    return this.maxTasks;
  }

  /**
   * Returns the theme of this week
   *
   * @return the theme of this week
   */
  public Theme getTheme() {
    return this.theme;
  }

  /**
   * Returns the month of this week
   *
   * @return the month of this week
   */
  public String getMonth() {
    return this.month;
  }

  /**
   * Returns the week of this week
   *
   * @return the week of this week
   */
  public String getWeekOf() {
    return this.weekOf;
  }

  /**
   * Sets the max number of events for this week to the given value
   *
   * @param maxEvents the new max number of events for this week
   */
  public void setMaxEvents(int maxEvents) {
    this.maxEvents = maxEvents;
  }

  /**
   * Sets the max number of tasks for this week to the given value
   *
   * @param maxTasks the new max number of tasks for this week
   */
  public void setMaxTasks(int maxTasks) {
    this.maxTasks = maxTasks;
  }

  /**
   * Adds the given day to this week
   *
   * @param day the day to add to this week
   */
  public void addDay(Day day) {
    for (int i = 0; i < this.days.length; i++) {
      if (this.days[i] == null) {
        this.days[i] = day;
        return;
      }
    }
    throw new IllegalStateException("Week is full");
  }

}
