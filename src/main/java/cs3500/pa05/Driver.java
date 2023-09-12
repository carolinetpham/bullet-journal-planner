package cs3500.pa05;

import cs3500.pa05.controller.BujoController;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.BujoView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Represents a Java Bullet Journal game application
 */
public class Driver extends Application {

  /**
   * Starts the GUI for a game of Java Bullet Journal and initialized the module,
   * view and controller
   *
   * @param stage the JavaFX stage to add elements to
   */
  @Override
  public void start(Stage stage) {
    stage.setTitle("Bullet Journal!");

    // instantiate a simple welcome GUI view
    Week week = new Week();
    BujoController controller = new BujoController(week, stage);
    BujoView view = new BujoView(controller);

    try {
      // load and place the view's scene onto the stage
      Scene scene = view.load();
      stage.setScene(scene);

      controller.run();

      // render the stage
      stage.show();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Entry point for a game of Java Bullet Journal
   *
   * @param args the command line arguments (unused)
   */
  public static void main(String[] args) {
    launch();
  }
}
