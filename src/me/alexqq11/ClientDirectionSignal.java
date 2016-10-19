package me.alexqq11;

/**
 * Created by Alexqq11 on 19.10.2016.
 */
public class ClientDirectionSignal {
    private int snakeID;
    private SnakeDirections direction;
    public ClientDirectionSignal(int clientID, SnakeDirections direction){
        this.direction = direction;
        this.snakeID = clientID;

    }
    public int getId(){
        return this.snakeID;
    }
    public SnakeDirections getDirection(){
        return this.direction;
    }
}
