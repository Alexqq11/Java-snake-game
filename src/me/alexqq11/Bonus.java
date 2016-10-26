package me.alexqq11;


import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

public class Bonus extends Entity {
	public boolean isCatched;
	public HashMap<Effects, Double> config;
	
	public Bonus(int x, int y,BonusType type) {
		this.x = x ;
		this.y = y;
		respawnBonus();
		initBonusConfig(type);
		initConfig();
	}
	private void initBonusConfig(BonusType type) {
	}
	public HashMap<Effects, Double> getEffects(){
		return config;
	}

	private void initConfig(){
		config = new HashMap<>();
		config.put(Effects.DIE, 0.0);
		config.put(Effects.GROWTH, 1.0);
	}
	public void respawnBonus() {
		if (isCatched) {

		}
	}
}

