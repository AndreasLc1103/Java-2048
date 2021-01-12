package Model;

/**
 * This Class serves as the blueprint for the tile Object, intended for the use of the Java Version
 * of the game 2048
 *
 * @author Andreas Leonard Calcano
 */
public class Tile {

  public static final int EMPTY = 0;
  private int value;
  private Point location;

  /**
   * Constructs an instance of a tile and sets its integer value
   *
   * @param value int representing the value stored at that tile
   */
  public Tile(int value, int x, int y) {
    this.location = new Point(x, y);
    this.value = value;
  }

  /**
   * getValue() is a getter function that is responsible for returning the state value of the Tile
   * Object.
   *
   * @return an integer representation of the value.
   */
  public int getValue() {
    return value;
  }

  /**
   * setValue() is a getter function that is responsible for assigning and changing the value field
   * in the Tile object.
   *
   * @param value int of the number or value the tile stores.
   */
  public void setValue(int value) {
    this.value = value;
  }

  /**
   * incrementValue() is a function that is responsible for incrementing the value of a tile.
   *
   * @PRECONDITION an equivalent matching tile must be combined.
   * @POSTCONDITION NONE
   */
  public void incrementValue() {
    this.value *= 2;
  }

  /**
   * Returns an instance the location that is being stored by the tile instance.
   *
   * @return Location instance containing an set of cartesian coordinates.
   */
  public Point getLocation() {
    return location;
  }

  public void setLocation(Point location) {
    this.location = location;
  }

  /**
   * toString() is an overridden method from the Object class intended to print the states held
   * within the Object
   *
   * @return a string to indicate the value stored when printed.
   */
  @Override
  public String toString() {
    return Integer.toString(value);
  }

}
