package Model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * This Class is a blueprint of the instance of a model for the game 2048. This blueprint serves as
 * the model, following the Model View Controller Architecture.
 */
public class Model2048 {

  /**
   * BOARD_DIM is a constant to represent the length of the 4x4 grid.
   */
  private final int BOARD_DIM = 4;
  private final int CURSOR_MAX = 2;
  private Tile[][] tileBoard;
  private Random random;
  /**
   * Used to keep track of the number of unassigned tiles.
   */
  private Map<Point, Tile> unOccupiedTiles;
  private List<Observer<Model2048>> observers;
  private boolean hasWon;
  private int currentScore;
  private int numberOfValidMoves;

  /**
   * This constructor is responsible for building and initializing the initial states of a game of
   * 2048.
   */
  public Model2048() {
    this.hasWon = false;
    this.currentScore = 0;
    this.numberOfValidMoves = 0;

    this.tileBoard = new Tile[4][4];
    this.unOccupiedTiles = new HashMap<Point, Tile>();
    this.observers = new LinkedList<>();
    random = new Random();

    for (int row = 0; row < BOARD_DIM; row++) {
      for (int col = 0; col < BOARD_DIM; col++) {
        tileBoard[row][col] = new Tile(Tile.EMPTY, row, col);
        // this allows to keep track of being able to grab values
        this.unOccupiedTiles.put(new Point(row, col), tileBoard[row][col]);

      }


    }
  }

  /**
   * Match() is a function that is used to compare to Tile objects, this function also acts as
   * checker to see if the current tile if the initial tile's value matches the other.
   *
   * @param initial int to represent the number stored
   * @param second  int to represent the number stored
   * @return Boolean to indicate if passed
   */
  public static boolean match(Tile initial, Tile second) {
    return initial.getValue() == second.getValue();
  }

  /**
   * addObserver() adds an instance of an observer to the list of Observers. This function
   * 611following the Observer pattern
   *
   * @param Observer instance of a class that implements the Observer interface
   */
  public void addObserver(Observer<Model2048> Observer) {
    this.observers.add(Observer);
  }

  /** notifyObservers() calls the update method to notify all Observers in the list.
   */
  public void notifyObservers() {
    for (Observer<Model2048> watcher : this.observers) {
      watcher.update(this);
    }

  }

  /**
   * SetTileAtPoint() sets the value of a tile on the board at the location passed.
   *
   * @param point An Object that hold an X and Y coordinate.
   * @param value integer that the value of the tile is to be set to.
   */
  public void setTileAtPoint(Point point, int value) {
    tileBoard[point.getX()][point.getY()].setValue(value);
    // removes the the occupied tile from the hashmap.
    unOccupiedTiles.remove(point);
  }

  /**
   * MoveTiles() is a function based on the direction controls the model and moves tiles to resemble
   * the correct behavior.
   *
   * @param directions Specified Direction of movement.
   */
  public void moveTiles(Directions directions) {
    switch (directions) {
      case RIGHT:
        moveTilesRight();
        break;
      case LEFT:
        moveTilesLeft();
        break;
      case DOWN:
        moveTilesDown();
        break;
      case UP:
        moveTilesUp();
        break;
      default:

    }
    // this updates the behavior of the View
    notifyObservers();
  }

  /**
   * MoveTilesRight() is a function to resemble the instruction of the board to the right combining
   * matching values This function is still a work in progress.
   */
  private void moveTilesRight() {
    for (int row = 0; row <= BOARD_DIM; row++) {
      for (int col = 0; col < CURSOR_MAX; col++) {
        // this checks the tile next to the curent tile
        if (tileBoard[row][col].getValue() != Tile.EMPTY) {
          if (match(tileBoard[row][col], tileBoard[row][col + 1])) {
            // this sets the next tile to the new value
            if (col == 1) {
              Tile before = tileBoard[row][col - 1];
              Tile current = tileBoard[row][col];
              Tile after = tileBoard[row][col + 1];
              // update after value
              after.incrementValue();
              // update the value from before to be the current
              current.setValue(before.getValue());
              //
              before.setValue(Tile.EMPTY);
            }
          }
        }

      }
    }
  }

  /**
   * This function is a work in progress.
   */
  private void moveTilesLeft() {

  }

  /**
   * This function is a work in progress.
   */
  private void moveTilesUp() {

  }

  /**
   * This function is a work in progress.
   */
  private void moveTilesDown() {

  }

  /**
   * toString() is a function that is responsible for returning a string representation of the data
   * that is being stored within the model of this program.
   *
   * @return String A printable representation of the game board.
   */
  @Override
  public String toString() {
    StringBuilder gameStr = new StringBuilder();
    // this is to print the game board and display the values stored in each tile location.
    for (int row = 0; row < BOARD_DIM; row++) {
      for (int col = 0; col < BOARD_DIM; col++) {
        gameStr.append("[");
        if (tileBoard[row][col].getValue() == Tile.EMPTY) {
          gameStr.append(" ");
        } else {
          gameStr.append(tileBoard[row][col]);
        }
        gameStr.append("]");

      }
      gameStr.append("\n");
    }
    return gameStr.toString();
  }

  /**
   * Directions is an enum storing the possible movement directions that can be made by the player.
   */
  public enum Directions {
    RIGHT, LEFT, UP, DOWN
  }

}
