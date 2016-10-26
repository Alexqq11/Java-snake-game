package me.alexqq11;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Alexqq11 on 21.09.2016.
 */
public class Snake extends Entity {
    private int lives;
    private int length;    // size => length
    private int id;
    private boolean isAlive;
    private SnakeDirections previousDirection;
    public  LinkedList<SnakePart> snakeParts = new LinkedList<SnakePart>();
    public  Snake(int mapWidth,int mapHeight, int x, int y, int clientId) {
        lives = 1;
        length = 4;
        isAlive = true;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.x = x;//random.nextInt(100) + 5;
        this.y = y;//random.nextInt(100) + 5;
        initSnakeParts();
        this.id = clientId;
    }
    public void applyEffects(HashMap<Effects,Double> entityEffects){
        if (entityEffects.get(Effects.GROWTH) != 0) {
            this.snakeParts.addLast(new SnakePart(snakeParts.getLast().x + 1, snakeParts.getLast().y + 1));
        }
        if (entityEffects.get(Effects.DIE) != 0){
            this.isAlive = false;
        }
    }

    private void initSnakeParts() {
        for ( int x = 0; x < this.length; x++){
            snakeParts.add(new SnakePart(this.x + x, this.y));
        }
        previousDirection = SnakeDirections.RIGHT;
    }
    private void updateSnakeParts() {
        if (!this.positionEquals(this.snakeParts.getFirst())) {
            snakeParts.addFirst(new SnakePart(this));
            snakeParts.removeLast();
            this.length = snakeParts.size();
        }
    }
    public boolean checkEntityforCollision(Entity entity){
        for (SnakePart part : this.snakeParts) {
            if (part.positionEquals(entity)) {
                return true;
            }
        }
        return false;
    }

    public void move(SnakeDirections direction){
        switch (direction) { // in that realisation snake can be compress itself
            case UP:
                if( previousDirection != SnakeDirections.UP) {
                    this.y--;
                    this.previousDirection = SnakeDirections.DOWN;
                }
                break;
            case DOWN:
                if( previousDirection != SnakeDirections.DOWN) {
                    this.y++;
                    this.previousDirection = SnakeDirections.UP;
                }
                break;
            case LEFT:
                if( previousDirection != SnakeDirections.LEFT) {
                    this.x--;
                    this.previousDirection = SnakeDirections.RIGHT;
                }
                break;
            case RIGHT:
                if( previousDirection != SnakeDirections.RIGHT) {
                    this.x++;
                    this.previousDirection = SnakeDirections.LEFT;
                }
                break;
        }
        rining();
        updateSnakeParts();
    }
    private boolean ring() {
        return !((this.x == snakeParts.get(1).x) && (this.y == snakeParts.get(1).y));
    }

    public int getId(){
        return this.id;
    }
    public int getLives(){
        return this.lives;
    }
    public int getLength(){
        return this.length;
    }
    public boolean isAlive(){
        return this.isAlive;
    }

}

