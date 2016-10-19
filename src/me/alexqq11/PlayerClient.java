package me.alexqq11;


/**
 * Created by Alexqq11 on 20.09.2016.
 */
public class PlayerClient {
    private int score;
    private boolean isActive;
    private int id;
    public int x;
    public int y;
    PlayerClient(int x, int y, int id){
        this.x= x;
        this.y = y;
        this.score = 0;
        this.isActive = true;
        this.id = id;//this.hashCode();
    }
    public void lose(){
        this.isActive = false;
    }
    public boolean getStatus(){
        return this.isActive;
    }
    public int getId(){
        return this.id;
    }

    public void updateScore(){
        this.score += 1;
    }

}
