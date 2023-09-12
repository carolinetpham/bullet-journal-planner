package cs3500.pa05.view;

import cs3500.pa05.controller.BujoController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a view for a Java Bullet Journal
 */
public class BujoView {

  private final FXMLLoader loader;

  private final FXMLLoader taskLoader;

  private final FXMLLoader eventLoader;

  private final FXMLLoader loadFileLoader;

  private final FXMLLoader saveFileLoader;

  private final FXMLLoader warningLoader;

  /**
   * Constructs a simple BuJo GUI view.
   *
   * @param controller the controller
   */
  public BujoView(BujoController controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("mainScene.fxml"));
    this.loader.setController(controller);

    this.taskLoader = new FXMLLoader();
    this.taskLoader.setLocation(getClass().getClassLoader().getResource("taskScene.fxml"));
    this.taskLoader.setController(controller);

    this.eventLoader = new FXMLLoader();
    this.eventLoader.setLocation(getClass().getClassLoader().getResource("eventScene.fxml"));
    this.eventLoader.setController(controller);

    this.loadFileLoader = new FXMLLoader();
    this.loadFileLoader.setLocation(getClass().getClassLoader().getResource("openFileScene.fxml"));
    this.loadFileLoader.setController(controller);

    this.saveFileLoader = new FXMLLoader();
    this.saveFileLoader.setLocation(getClass().getClassLoader().getResource("saveFileScene.fxml"));
    this.saveFileLoader.setController(controller);

    this.warningLoader = new FXMLLoader();
    this.warningLoader.setLocation(getClass().getClassLoader().getResource("warningScene.fxml"));
    this.warningLoader.setController(controller);
  }

  /**
   * Loads a scene from a BuJo GUI layout.
   *
   * @return the layout
   */
  public Scene load() throws IllegalStateException {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }

  /**
   * Loads a scene from a BuJo GUI layout.
   *
   * @return the layout
   */
  public Scene loadTask() throws IllegalStateException {
    // load the layout
    try {
      return this.taskLoader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }

  /**
   * Loads a scene from a BuJo GUI layout.
   *
   * @return the layout
   */
  public Scene loadEvent() throws IllegalStateException {
    // load the layout
    try {
      return this.eventLoader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }

  /**
   * Loads a scene from a BuJo GUI layout.
   *
   * @return the layout
   */
  public Scene loadSave() throws IllegalStateException {
    // load the layout
    try {
      return this.saveFileLoader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }

  /**
   * Loads a scene from a BuJo GUI layout.
   *
   * @return the layout
   */
  public Scene loadOpen() throws IllegalStateException {
    // load the layout
    try {
      return this.loadFileLoader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }

  /**
   * Loads a scene from a BuJo GUI layout.
   *
   * @return the layout
   */
  public Scene loadWarn() throws IllegalStateException {
    // load the layout
    try {
      return this.warningLoader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
