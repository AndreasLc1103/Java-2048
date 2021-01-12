package Gui;

import Model.Model2048;
import Model.Observer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 */
public class Game2048GUI extends Application implements Observer<Model2048> {


  /**
   * @param stage
   * @throws Exception
   */
  @Override
  public void start(Stage stage) throws Exception {
    Scene scene = new Scene(new FlowPane());
    stage.setScene(scene);
    stage.show();
  }


  /**
   * @param model2048
   */
  @Override
  public void update(Model2048 model2048) {

  }
}
