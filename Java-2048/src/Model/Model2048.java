package Model;

import java.util.*;

/**
 * This Class is a blueprint of the instance
 * of a model for the game 2048.
 *
 * This blueprint serves as the model, following the
 * Model View Controller Architecture.
 */
public class Model2048 {
    private List<Observer<Model2048>> observers = new LinkedList<>();
    private boolean hasWon;
    private int current_score;
    private int numberOfValidMoves;
    private Tile[][] tile_board;
    private final int BOARD_DIM = 4;
    private final int CURSOR_MAX = 2;
    private Random random;

    /**
     * Enum states to indicate the direction that the player
     * wants to move tiles on the tile borad
     */
    public enum Directions{
        RIGHT, LEFT, UP, DOWN
    }

    /**
     * Constructs an instance of the Model object and
     * sets the initial states of the game 2048.
     * then places two tiles randomly located on the
     * board
     *
     */
    public Model2048(){
        this.hasWon = false;
        this.current_score = 0;
        this.numberOfValidMoves = 0;
        this.tile_board = new Tile[4][4];

        random = new Random();

        for (int i = 0; i < BOARD_DIM; i++) {
            for (int j = 0; j < BOARD_DIM; j++) {
                tile_board[i][j]= new Tile(Tile.EMPTY , i, j);
            }
        }








    }

    /**
     * addObserver adds an instance of an observer to the observer list
     * this follows the observer design pattern
     *
     * @param Observer instance of a class that implements the
     *                 Observer interface
     */
    public void  addObserver(Observer<Model2048> Observer){
        this.observers.add(Observer);
    }

    /**
     * calls the update method to notify all Observers in the list
     *
     */
    public void notifyObeservers(){
        for (Observer<Model2048> watcher: this.observers) {
            watcher.update(this);
        }

    }

    /**
     * This function takes 2 instances of a Tile instance and compares the
     * integer value stored in each. servering as a helper function to indicate if
     * two tiles move and can combine
     * @param intial
     * @param second
     * @return
     */
    public static boolean match(Tile intial, Tile second) {
        if (intial.getValue() == second.getValue()) return true;
        return false;
    }

    public void moveTiles(Directions directions) {
        switch (directions) {
            case RIGHT:
                moveTilesRight();
            case LEFT:
                moveTilesLeft();
            case DOWN:
                moveTilesDown();
            case UP:
                moveTilesUp();
            default:

        }

    }

    /**
     *
     */
    private void moveTilesRight() {
        for (int row = 0; row <= BOARD_DIM; row++) {
            for (int col = 0; col < CURSOR_MAX; col++) {
                // this checks the tile next to the curent tile
                if (tile_board[row][col].getValue() != Tile.EMPTY) {
                    if (match(tile_board[row][col], tile_board[row][col + 1])) {
                        // this sets the next tile to the new value
                        tile_board[row][col + 1].incrementValue();
                        // this sets the previous tile location to empty
                        if (col == 1) {
                            // sets the current tile equal to the previous
                            tile_board[row][col] = tile_board[row][col - 1];
                            //
                            tile_board[row][col - 1].setLocation(tile_board[row][col].getLocation());
                        }
                        if (col == 2) {
                        }
                    }
                }

            }
        }
    }
    private void moveTilesLeft(){

    }
    private void moveTilesUp(){

    }
    private void moveTilesDown(){

    }



}
