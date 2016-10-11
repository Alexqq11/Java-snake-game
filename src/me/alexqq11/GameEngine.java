package me.alexqq11;

import java.util.LinkedList;

/**
 * Created by Alexqq11 on 20.09.2016.
 */
public class GameEngine {
    GameWorld gameWorld;
    public LinkedList<PlayerClient> clients;
    GameEngine(){
        clients = new LinkedList<PlayerClient>();
    }


    private void moveSnake(Snake snake, SnakeDirections direction)
    {
        snake.move(direction);
    }
    private void checkColisions(){
        checkBonusColision();
        checkObstaclesColision();
        checkSnakesColision();
    }



    private void checkBonusColision(){

    }
    private void checkObstaclesColision(){}
    private void checkSnakesColision(){}

    private void printSnakeInfo(Snake snake){
        System.out.print("Snake head position: x = " + snake.x + " y = " + snake.y + ";\n");
    }
    private void initClient(){
        PlayerClient client = new PlayerClient(1);
        this.clients.add(client);
    }

    public void sendSignal(int id, EngineSignals signal, SnakeDirections direction) {
    }

}
