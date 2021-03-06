package me.alexqq11;

import java.util.LinkedList;

/**
 * Created by Alexqq11 on 20.09.2016.
 */
public class GameEngine {
    public GameWorld gameWorld;

    public LinkedList<PlayerClient> clients;

    public GameEngine(int mapWidth, int mapHeight){

        clients = new LinkedList<PlayerClient>();
        initClient();
        gameWorld = new GameWorld(mapWidth,mapHeight, clients);
    }
    public void handlClientOperations(LinkedList<ClientDirectionSignal> clientDirectionSignals){
        for (Snake snake: gameWorld.snakes){
            for ( ClientDirectionSignal clientDirectionSignal : clientDirectionSignals){
                if (snake.getId() == clientDirectionSignal.getId()){
                    moveSnake(snake,clientDirectionSignal.getDirection());
                }
            }
        }
        checkColisions();
    }
    public void moveSnake(Snake snake, SnakeDirections direction)
    {
        snake.move(direction);
    }

    private void checkColisions(){
        checkColisionsSnakesWithBonus();
        checkObstaclesCollision();
        processingSnakesColision();
    }


    private void checkColisionsSnakesWithBonus(){
        LinkedList<Snake> colisionSnakes = new LinkedList<Snake>();
        for (Snake snake: gameWorld.snakes){
            for (Bonus bonus: gameWorld.bonuses){
                if (snake.positionEquals(bonus)){
                    snake.applyEffects(bonus.getEffects());
                    clientUpdateScore(snake.getId());
                    gameWorld.bonuses.remove(bonus);
                }
            }
        }
    }
    private void clientGamelose(int id){
        for (PlayerClient client: this.clients ){
            if (client.getId() == id){
                client.lose();
            }
        }
    }
    private  void clientUpdateScore(int id){
        for (PlayerClient client: this.clients ){
            if (client.getId() == id){
                client.updateScore();
            }
        }
    }
    private void checkObstaclesCollision(){
        LinkedList<Snake> colisionSnakes = new LinkedList<Snake>();
        for (Snake snake: gameWorld.snakes) {
            for (Obstacle obstacle : gameWorld.obstacles) {
                if (snake.positionEquals(obstacle)) {
                    snake.applyEffects(obstacle.getEffects());
                }
            }
        }
    }

    private void processingSnakesColision(){
        LinkedList<Snake> deadSnakes = getColisionSnakesWithSnakes();
        for (Snake deadSnake : deadSnakes){
            clientGamelose(deadSnake.getId());
        }

    }
    private LinkedList<Snake> getColisionSnakesWithSnakes(){
        LinkedList<Snake> colisionSnakes = new LinkedList<Snake>();
        for (Snake snake: gameWorld.snakes){
            for (Snake undercheck_snake :gameWorld.snakes) {
                if (snake != undercheck_snake) {
                    if (snake.positionEquals(undercheck_snake) || undercheck_snake.checkEntityforCollision(snake) ||(! snake.isAlive())){
                        colisionSnakes.add(snake);
                    }
                } else {
                    if(undercheck_snake.checkEntityforCollision(snake)){
                        colisionSnakes.add(snake);
                    }

                }

            }
        }
        return colisionSnakes;

    }

    public void printSnakeInfo(Snake snake){
        System.out.print("Snake head position: x = " + snake.x + " y = " + snake.y + ";\n");
    }
    private void initClient(){
        PlayerClient client = new PlayerClient(10,10 ,1);
        this.clients.add(client);
    }

    public void sendSignal(int id, EngineSignals signal, SnakeDirections direction) {
    }

}
