package me.alexqq11;


/**
 * Created by Alexqq11 on 20.09.2016.
 */
public class PlayerClient {
    private int score;
    public Snake snake;
    private boolean isRunning;
    private GameEngine engine;
    private int id;
    //private int snake_id;
    public void moveTO(SnakeDirections direction) {
        engine.sendSignal(id, EngineSignals.CLIENT_ACTION_MOVEMENT, direction);
    }

}
