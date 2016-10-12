package me.alexqq11;

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
    private LinkedList<SnakePart> snakeParts = new LinkedList<SnakePart>();
    public  Snake(int clientId) {
        lives = 1;
        length = 4;
        isAlive = true;
        Random random = new Random();
        this.x = random.nextInt(100) + 5;
        this.y = random.nextInt(100) + 5;
        initSnakeParts();
        this.id = clientId;
    }
    public void applyEffects(Object effect){
        this.snakeParts.addLast(new SnakePart( snakeParts.getLast().x+1, snakeParts.getLast().y+1 ));
    }
    private void initSnakeParts() {
        for ( int x = 0; x < this.length; x++){
            snakeParts.add(new SnakePart(this.x + x, this.y));
        }
    }
    private void updateSnakeParts() {
        if (!this.positionEquals(this.snakeParts.getFirst())) {
            snakeParts.addFirst(new SnakePart(this));
            snakeParts.removeLast();
            this.length = snakeParts.size();
        }
    }
    public boolean checkEnityforCollision(Entity entity){
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
                this.y--;
                if (! canMove()){
                    this.y++;
                }
                break;
            case DOWN:
                this.y++;
                if (! canMove()){
                    this.y--;
                }
                break;
            case LEFT:
                this.x--;
                if (! canMove()){
                    this.x++;
                }
                break;
            case RIGHT:
                this.x++;
                if (! canMove()){
                    this.x--;
                }
                break;
        }
        updateSnakeParts();
    }
    private boolean canMove() {
        return !((this.x == snakeParts.get(1).x) && (this.y == snakeParts.get(1).y));
    }
    public void checkSelf() {
     // TODO MAKE cheking alive snake;
    }
    public void EngineSignalReceiver(EngineSignals signal){
        //TODO engine signal handler for esenses !!!  like die signal
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
    public LinkedList<SnakePart> getSnakePosition(){
        return this.snakeParts;
    }
}

