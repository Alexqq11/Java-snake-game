package me.alexqq11;

/**
 * Created by Alexqq11 on 21.09.2016.
 */
public class Snake extends  Essence {
    private GameEngine engine;
    private int lives;
    private int length;
    private boolean alive;
    private Essence[]  snakeSegments;  // TODO make a  two linked list to store snake segments  or iterable deque
    private EssenceConfig snakeConfig;

    private void updateSnakeSegment() {
        //TODO UPDATE SNAKE STATE
    }

    public void moveTo(SnakeDirections direction){
        if (direction == SnakeDirections.UP)
            this.y+=1;
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
        return this.length;
    }
    public boolean isAlive(){
        return this.alive;
    }
    public Essence[] getSnakePosition(){
        return this.snakeSegments;
    }
}

