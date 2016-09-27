package me.alexqq11;

import java.util.LinkedList;

/**
 * Created by Alexqq11 on 21.09.2016.
 */
public class Snake extends Essence {
    private GameEngine engine;
    private int lives;
    private int size; // length => size
    private boolean isAlive; // alive => isAlive
    private LinkedList<SnakePart> snakeParts;
    private EssenceConfig snakeConfig;

    private void updateSnakeSegment() {
        if (!this.positionEquals(this.snakeParts.getFirst())) {
            snakeParts.addFirst(new SnakePart(this));
            snakeParts.pollLast() /?
        }
    }

    public void moveTo(SnakeDirections direction){
        if (direction == SnakeDirections.UP)
            this.y += 1;
            this.updateSnakeSegment();
        // TODO MAKE SWITH HERE
    }
    public void checkSelf() {
     // TODO MAKE cheking alive snake;
    }
    public void EngineSignalReceiver(EngineSignals signal){
        //TODO engine signal handler for esenses !!!  like die signal
    }
    public int getLives(){
        return this.lives;
    }
    public int getLength(){
        return this.size;
    }
    public boolean isAlive(){
        return this.isAlive;
    }
    public LinkedList<SnakePart> getSnakePosition(){
        return this.snakeParts;
    }
}

