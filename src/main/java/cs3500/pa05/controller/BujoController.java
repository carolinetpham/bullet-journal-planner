package cs3500.pa05.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.BujoFileWriter;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Time;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.WeekJson;
import cs3500.pa05.view.BujoView;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Represents a controller for a Java Bullet Journal
 */
public class BujoController {
  private Week week;

  private final Stage stage;

  @FXML
  private Button taskButton;

  @FXML
  private Button eventButton;

  @FXML
  private Button openButton;

  @FXML
  private Button saveButton;

  @FXML
  private TextField monthField;

  @FXML
  private TextField weekOfField;

  @FXML
  private MenuButton dayTaskBar;

  @FXML
  private TextField nameTextField;

  @FXML
  private TextField descriptionTextField;

  @FXML
  private VBox monday;

  @FXML
  private VBox tuesday;

  @FXML
  private VBox wednesday;

  @FXML
  private VBox thursday;

  @FXML
  private VBox friday;

  @FXML
  private VBox saturday;

  @FXML
  private VBox sunday;

  @FXML
  private TextField eventNameTextField;

  @FXML
  private TextField eventDescriptionTextField;

  @FXML
  private TextField eventStartTimeField;

  @FXML
  private TextField eventDurationField;

  @FXML
  private TextField eventDayField;

  @FXML
  private TextField taskDayField;

  @FXML
  private TextField commitEventField;

  @FXML
  private TextField commitTaskField;

  private Popup warningPopup;

  private String taskName;

  private String taskDescription;

  private String eventName;

  private String eventDescription;

  private String eventStartTime;

  private String eventDuration;

  private String taskDay;

  private String eventDay;

  private String openFilePath;

  private String saveFilePath;

  @FXML
  private TextField savePath;

  @FXML
  private TextField loadPath;


  /**
   * Initializes a controller for a Java Bullet Journal.
   *
   * @param week  the week to be displayed
   * @param stage the stage to be displayed on
   */
  public BujoController(Week week, Stage stage) {
    this.week = week;
    this.stage = stage;
  }

  /**
   * Initializes a game of Java Bullet Journal.
   */
  public void run() {

    this.warningPopup = new Popup();
    Scene warningScene = new BujoView(this).loadWarn();

    warningPopup.getContent().add(warningScene.getRoot());
    Button b = new Button("Done!");
    b.setOnAction(e -> warningPopup.hide());

    warningPopup.getContent().add(b);

    this.commitEventField.setOnKeyTyped(event -> this.week.setMaxEvents(Integer.parseInt(
        this.commitEventField.getText())));
    this.commitTaskField.setOnKeyTyped(event -> this.week.setMaxTasks(Integer.parseInt(
        this.commitTaskField.getText())));

    Popup taskPopup = new Popup();
    Scene taskScene = new BujoView(this).loadTask();
    initPopupButton(this.taskButton, taskPopup, taskScene);

    this.nameTextField.setOnKeyTyped(
        event -> this.taskName = this.nameTextField.getText());
    this.descriptionTextField.setOnKeyTyped(
        event -> this.taskDescription = this.descriptionTextField.getText());
    this.taskDayField.setOnKeyTyped(event -> this.taskDay = this.taskDayField.getText());

    Popup eventPopup = new Popup();
    Scene eventScene = new BujoView(this).loadEvent();
    initPopupButton(this.eventButton, eventPopup, eventScene);
    this.eventNameTextField.setOnKeyTyped(
        event -> this.eventName = this.eventNameTextField.getText());
    this.eventDescriptionTextField.setOnKeyTyped(
        event -> this.eventDescription = this.eventDescriptionTextField.getText());
    this.eventStartTimeField.setOnKeyTyped(
        event -> this.eventStartTime = this.eventStartTimeField.getText());
    this.eventDurationField.setOnKeyTyped(event -> this.eventDuration = this.eventDurationField
        .getText());
    this.eventDayField.setOnKeyTyped(event -> this.eventDay = this.eventDayField.getText());


    Popup loadFilePopup = new Popup();
    Scene openFileScene = new BujoView(this).loadOpen();
    this.loadPath.setOnKeyTyped(event -> this.openFilePath = this.loadPath.getText());

    initPopupButton(this.openButton, loadFilePopup, openFileScene);

    Popup saveFilePopup = new Popup();
    Scene saveFileScene = new BujoView(this).loadSave();
    this.savePath.setOnKeyTyped(event -> this.saveFilePath = this.savePath.getText());

    initPopupButton(this.saveButton, saveFilePopup, saveFileScene);

    this.monthField.setText(this.week.getMonth());
    this.monthField.setOnAction(event -> this.week.setMonth(this.monthField.getText()));

    this.weekOfField.setText(this.week.getWeekOf());
    this.weekOfField.setOnAction(event -> this.week.setMonth(this.monthField.getText()));


  }

  /**
   * Loads a selected .bujo file into a Java Bullet Journal.
   */
  private void loadFile(String filename) {
    StringBuilder file = new StringBuilder();
    Scanner scanner = null;
    try {
      scanner = new Scanner(Path.of(filename));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      file.append(line);
    }

    scanner.close();

    try {
      JsonNode json = new ObjectMapper().readTree(file.toString());

      WeekJson weekJson = new ObjectMapper().convertValue(json, WeekJson.class);

      this.week = weekJson.toWeek();

      this.commitEventField.setText(Integer.toString(this.week.getMaxEvents()));
      this.commitTaskField.setText(Integer.toString(this.week.getMaxTasks()));

      this.monthField.setText(this.week.getMonth());
      this.weekOfField.setText(this.week.getWeekOf());

      for (Day day : this.week.getDays()) {
        populateDay(day);
      }

    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  private void populateDay(Day day) {
    for (Event event : day.getEvents()) {
      Label eventLabel = new Label(event.toString());
      getVbox(day.getName()).getChildren().add(eventLabel);
    }

    for (Task task : day.getTasks()) {
      Label taskLabel = new Label(task.toString());
      taskLabel.setOnMouseClicked(event -> handleLabelClick(taskLabel, task));
      getVbox(day.getName()).getChildren().add(taskLabel);
    }
  }

  /**
   * Saves a Java Bullet Journal to a .bujo file.
   */
  private void saveFile(String filename) {
    BujoFileWriter.writeBujo(this.week, filename);
  }

  /**
   * Adds a task to a Java Bullet Journal.
   */
  private void addTaskFromPopup() {
    Day day = this.week.getDays()[Day.getDayIndex(this.taskDay)];

    if (day.getTasks().size() >= this.week.getMaxTasks()) {
      this.warningPopup.show(this.stage);
    }

    Task task = new Task(this.taskName, this.taskDescription, day.getName());
    day.addTask(task);

    Label taskLabel = new Label(task.toString());
    taskLabel.setOnMouseClicked(event -> handleLabelClick(taskLabel, task));
    getVbox(this.taskDay).getChildren().add(taskLabel);
  }

  /**
   * Adds a task to a Java Bullet Journal.
   */
  private void addEventFromPopup() {

    Day day = this.week.getDays()[Day.getDayIndex(this.eventDay)];

    if (day.getEvents().size() >= this.week.getMaxEvents()) {
      this.warningPopup.show(this.stage);
    }

    int hour = Integer.parseInt(this.eventStartTime.split(":")[0]);
    int minute = Integer.parseInt(this.eventStartTime.split(":")[1]);

    Event event =
        new Event(this.eventName, this.eventDescription, day.getName(), new Time(hour, minute),
            Integer.parseInt(this.eventDuration));
    day.addEvent(event);

    Label eventLabel = new Label(event.toString());
    getVbox(this.eventDay).getChildren().add(eventLabel);
  }

  /**
   * Handles clicking a task label in a Java Bullet Journal.
   */
  private void handleLabelClick(Label taskLabel, Task task) {
    task.setComplete(!task.isComplete());
    taskLabel.setText(task.toString());
  }

  /**
   * Returns the correct VBox for a given string
   *
   * @param day the string representing the day
   * @return the correct VBox
   */
  private VBox getVbox(String day) {
    switch (day.toLowerCase()) {
      case "monday":
        return this.monday;
      case "tuesday":
        return this.tuesday;
      case "wednesday":
        return this.wednesday;
      case "thursday":
        return this.thursday;
      case "friday":
        return this.friday;
      case "saturday":
        return this.saturday;
      case "sunday":
        return this.sunday;
      default:
        throw new IllegalArgumentException("No such day");
    }
  }

  /**
   * Initializes the task button in a Java Bullet Journal.
   */
  private void initPopupButton(Button button, Popup popup, Scene s) {
    button.setOnAction(event -> showPopup(popup));

    popup.getContent().add(s.getRoot());

    Button b = new Button("Done!");
    b.setOnAction(e -> popup.hide());

    popup.getContent().add(b);
    popup.setOnHidden(e -> handleHiddenPopup(button));
  }

  /**
   * Handles a hidden popup in a Java Bullet Journal.
   */
  private void handleHiddenPopup(Button button) {
    if (button == this.taskButton) {
      addTaskFromPopup();
    }
    if (button == this.eventButton) {
      addEventFromPopup();
    }
    if (button == this.openButton) {
      loadFile(this.openFilePath);
    }
    if (button == this.saveButton) {
      saveFile(this.saveFilePath);
    }
  }

  /**
   * Shows a dialog for a task in a Java Bullet Journal.
   */
  private void showPopup(Popup popup) {
    popup.show(this.stage);
  }
}
