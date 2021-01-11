package Model;

/**
 * This Class serves as the blueprint for the tile Object,
 * intended for the use of the Java Version of the game 2048
 *
 * @author Andreas Leonard Calcano
 */
public class Tile {
    public static final int EMPTY = 0;
    private int value;
    private Point location;

    /**
     * Constructs an instance of a tile and sets its
     * integer value
     *
     * @param value int representing the value
     *              stored at that tile
     */
    public Tile(int value, int x, int y) {
        this.location = new Point(x, y);
        this.value = value;
    }

    /**
     * Returns the value stored at current tile
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * sets the value of the tile
     *
     * @param value int of the number stored
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     *
     */
    public void incrementValue() {
        this.value *= 2;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
