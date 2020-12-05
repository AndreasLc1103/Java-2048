package Model;

/**
 * This Class serves as the blueprint for the tile Object,
 * intended for the use of the Java Version of the game 2048
 * @author Andreas Leonard Calcano
 */
public class Tile {
    int value;

    /**
     * Constructs an instance of a tile and sets its
     * integer value
     * @param value int representing the value
     *              stored at that tile
     */
    public Tile (int value){
        this.value = value;
    }

    /**
     * Returns the value stored at current tile
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * sets the value of the tile
     * @param value     int of the number stored
     */
    public void setValue(int value) {
        this.value = value;
    }
}
