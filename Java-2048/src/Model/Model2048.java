package Model;

import java.util.LinkedList;
import java.util.List;

public class Model2048 {
    private List<Observer<Model2048>> observers = new LinkedList<>();
    private boolean hasWon;
    private int current_score;
    private int numberOfValidMoves;
    private Tile[][] tile_board;
    private final int BOARD_DIM = 4;

    public enum Directions{
        RIGHT, LEFT, UP, DOWN
    }

    public Model2048(){
        
        this.hasWon = false;
        this.current_score = 0;
        this.numberOfValidMoves = 0;
        this.tile_board = new Tile[4][4];

        for (int i = 0; i < BOARD_DIM; i++) {
            for (int j = 0; j < BOARD_DIM; j++) {
                tile_board[i][j].setValue(0);
            }
        }



    }
    public void  addObserver(Observer<Model2048> Observer){
        this.observers.add(Observer);
    }

    public void notifyObeservers(){
        for (Observer<Model2048> watcher: this.observers) {
            watcher.update(this);
        }

    }
    public boolean match(Tile intial, Tile second) {
        if (intial.getValue() == second.getValue()) return true;
        return false;
    }




}
