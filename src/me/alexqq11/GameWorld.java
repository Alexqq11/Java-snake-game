package me.alexqq11;

import java.util.LinkedList;
/**
 * Created by Alexqq11 on 05.10.2016.
 */
public class GameWorld {
    public LinkedList<Snake> snakes = new LinkedList<Snake>();
    public LinkedList<Bonus> bonuses = new LinkedList<Bonus>();
    public LinkedList<Obstacle> obstacles = new  LinkedList<Obstacle>();
    public GameWorld(LinkedList<PlayerClient> clients) {
        initSnakesForPlayerClients(clients);
        initBonuses();
        initObstacles();
    }
    private void initSnakesForPlayerClients(LinkedList<PlayerClient> clients) {
        for (int i = 0; i < clients.size(); i++){
            Snake snake = new Snake(clients.get(i).getId());
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
