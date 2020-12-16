package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
                tile_board[i][j].setValue(0);
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
    public boolean match(Tile intial, Tile second) {
        if (intial.getValue() == second.getValue()) return true;
        return false;
    }




}
