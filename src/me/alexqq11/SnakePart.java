package me.alexqq11;

/**
 * Created by Alexqq11 on 21.09.2016.
 */
public class SnakePart extends Entity {

    public SnakePart(Snake snake){
        this.x = snake.x;
        this.y = snake.y;
        //this.id = snake.getId();//?
    }
    public SnakePart(int x, int y){
        this.x = x;
        this.y = y;
    }
}
