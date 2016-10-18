package me.alexqq11;

import java.util.LinkedList;
/**
 * Created by Alexqq11 on 05.10.2016.
 */
public class GameWorld {
    public LinkedList<Snake> snakes = new LinkedList<Snake>();
    public LinkedList<Bonus> bonuses = new LinkedList<Bonus>();
    public LinkedList<Obstacle> obstacles = new  LinkedList<Obstacle>();
    public char[][] map;
    public int mapWidth;
    public int mapHeight;
    public GameWorld(int mapWidth ,int mapHeight,LinkedList<PlayerClient> clients) {//todo ahctung achtung clients link;
        this.map = new char[mapHeight][mapWidth];
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        initSnakesForPlayerClients(clients);
        initBonuses();
        initObstacles();
        updateMapObjects();
    }
    public void updateMapObjects(){
        this.map = new char[mapHeight][mapWidth];
        for(Snake snake: this.snakes){
            setEntity(snake.snakeParts,'*');
            map[snake.y][snake.x] = '@'; // todo make not static textures//
        }
        setEntity(this.bonuses,'$');
        setEntity(this.obstacles,'#');
    }
    private void setEntity(LinkedList<? extends Entity> entities, char marking){
        for (Entity entity: entities){
            this.map[entity.y][entity.x] = marking;
        }
    }
    private void initSnakesForPlayerClients(LinkedList<PlayerClient> clients) {
        for (int i = 0; i < clients.size(); i++){
            PlayerClient processingClient = clients.get(i);
            Snake snake = new Snake(this.mapWidth, this.mapHeight, processingClient.x, processingClient.y, processingClient.getId());
            snakes.add(snake);
        }

    }
    private void initBonuses(){
        bonuses.add(new Bonus(BonusType.APPLE));
    }
    private void initObstacles(){
        obstacles.add(new Obstacle());
    }
}
