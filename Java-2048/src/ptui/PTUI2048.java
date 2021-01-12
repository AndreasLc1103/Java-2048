package ptui;

import Model.Model2048;
import Model.Observer;
import java.util.Scanner;

/**
 * This class serves as a Plain Text UI of the game 2048. This class utilizes the controller and
 * view portions of the Model View Controller Architecture.
 *
 * @author Andreas Leonard-Calcano
 */
public class PTUI2048 implements Observer<Model2048> {

  private static final String UP = "w";
  private static final String DOWN = "s";
  private static final String LEFT = "a";
  private static final String RIGHT = "d";
  public Model2048 gameBoard;

  public PTUI2048() {
    this.gameBoard = new Model2048();
    initializeView();

  }

  public static void main(String[] args) {
    PTUI2048 ptui2048 = new PTUI2048();
    System.out.println("Welcome to the game of 2048");
    ptui2048.run();
  }
  /*=====================    View    =========================*/

  /**
   * initializeView() is a function that allows for the plain text ui to be attached and added to
   * the list of observers to the model.
   */
  private void initializeView() {
    this.gameBoard.addObserver(this);
  }


  /**
   * update() updates the Plain Text User Interface of the game 2048.
   *
   * @param model2048 An instance of the model of the program.
   */
  @Override
  public void update(Model2048 model2048) {
    System.out.println(this.gameBoard);
  }

  /*===================== Controller=========================*/


  public void run() {
    update(this.gameBoard);
    try (Scanner in = new Scanner(System.in)) {
      System.out.println("use the W:UP S:DOWN A:LEFT D:RIGHT ");
      String input = in.next();
      switch (input.toLowerCase()) {
        case "d":
          this.gameBoard.moveTiles(Model2048.Directions.RIGHT);
          break;
        case "a":
          this.gameBoard.moveTiles(Model2048.Directions.LEFT);
          break;
        case "w":
          this.gameBoard.moveTiles(Model2048.Directions.UP);
          break;
        case "s":
          this.gameBoard.moveTiles(Model2048.Directions.DOWN);
          break;
        default:
          System.out.println("Incorrect input Try again");
          run();
      }
    }

  }
}

