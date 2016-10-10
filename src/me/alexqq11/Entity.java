package me.alexqq11;

/**
 * Created by Alexqq11 on 20.09.2016.
 */
public class Entity {
    public int x;
    public int y;
    public int width;
    public int height;
    private int id;
    public boolean positionEquals(Entity entity){
        return  this.x == entity.x && this.y == entity.y;
    }
    public int getId() {
        return this.id;
    }
    // THINK  ABOUT IT  public EssenceConfig  configuration;
}
