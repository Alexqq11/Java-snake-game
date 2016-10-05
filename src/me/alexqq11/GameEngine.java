package me.alexqq11;

import java.util.LinkedList;

/**
 * Created by Alexqq11 on 20.09.2016.
 */
public class GameEngine {
    GameWorld game;
    public LinkedList<PlayerClient> clients;
    GameEngine(){
        clients = new LinkedList<PlayerClient>();
        this.clients.addFirst(new PlayerClient(1));
    }
    public void testMechanic(){
        initClient();
        game = new GameWorld(this.clients);
        for (int i = 0; i < 10;i++){
            moveSnake(game.snakes.getFirst(), SnakeDirections.DOWN);
            printSnakeInfo(game.snakes.getFirst());
        }
        for (int i = 0; i < 10;i++){
            moveSnake(game.snakes.getFirst(), SnakeDirections.LEFT);
            printSnakeInfo(game.snakes.getFirst());
        }
        for (int i = 0; i < 10;i++){
            moveSnake(game.snakes.getFirst(), SnakeDirections.UP);
            printSnakeInfo(game.snakes.getFirst());
        }
        for (int i = 0; i < 10;i++){
            moveSnake(game.snakes.getFirst(), SnakeDirections.RIGHT);
            printSnakeInfo(game.snakes.getFirst());
        }

    }
    private void moveSnake(Snake snake, SnakeDirections direction){
        snake.move(direction);
    }
    private void printSnakeInfo(Snake snake){
        System.out.print("Snake head position: x = " + snake.x + " y = " + snake.y + ";\n");
    }
    private void initClient(){
       // PlayerClient client = new PlayerClient(1);
        //this.clients.add(client);
    }

    public void sendSignal(int id, EngineSignals signal, SnakeDirections direction) {
        //doing something
    }

}
