package me.alexqq11;


public class Bonus extends Entity {
	public boolean isCatched;
	private BonusConfig bonusConfig;// rewrite
	
	public Bonus(int x, int y,BonusType type) {
		this.x = x ;
		this.y = y;
		respawnBonus();
		initBonusConfig(type);
	}
	private void initBonusConfig(BonusType type) {
		//..//
	}
	public Object getEffects(){
		return (new Object());
	}
	public void pointsUp(PlayerClient player) {
		if (isCatched) {
			player.updateScore();// += pointsSize;           // todo if we make config file rewrite this
		}
	}

	public void respawnBonus() {
		if (isCatched) {

		}
	}
}

