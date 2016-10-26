package me.alexqq11;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Alexqq11 on 05.10.2016.
 */
public class Obstacle extends Entity{
    public HashMap<Effects,Double> config;
    public Obstacle(int x,int y){
        this.x = x;
        this.y = y;
        initConfig();
    }
    private void initConfig(){
        config = new HashMap<>();
        config.put(Effects.DIE, 1.0);
        config.put(Effects.GROWTH, 0.0);
    }
    public  HashMap<Effects, Double> getEffects(){return config;}
}
