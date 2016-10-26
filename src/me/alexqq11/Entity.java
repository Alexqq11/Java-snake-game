package me.alexqq11;

import java.util.Dictionary;

/**
 * Created by Alexqq11 on 20.09.2016.
 */
public class  Entity {
    public int x;
    public int y;
    public int mapWidth;
    public int mapHeight;
    private int id;
   // public Dictionary<Effects,Double> config;
    public void rining(){
        this.x = (this.x + mapWidth) %  mapWidth;
        this.y = (this.y + mapHeight) % mapHeight;
    }
    public boolean positionEquals(Entity entity){
        return  this.x == entity.x && this.y == entity.y;
    }
    public int getId() {
        return this.id;
    }
}
