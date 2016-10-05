package me.alexqq11;
import java.awt.Rectangle;
import java.util.Random;


public class Bonus extends Entity {
	//into config public int pointsSize;
	//public Point position;
	public boolean isCatched;
	public Rectangle collider;
	private BonusConfig bonusConfig;// rewrite
	
	public Bonus(BonusType type) {
		//Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.x = -sSize.width;
		//this.y = sSize.height;
		respawnBonus();
		initBonusConfig(type);
	}
	private void initBonusConfig(BonusType type){
		//..//
	}

	public void pointsUp(PlayerClient player) {    // точно не здесь нужно
		if (isCatched) {
			player.updateScore();// += pointsSize;           // todo if we make config file rewrite this
		}
	}

	public void respawnBonus() {
		if (isCatched) {
			Random random = new Random();
			//int x = Toolkit.getDefaultToolkit().getScreenSize().width; // it is skeleton methods here
			//int y = Toolkit.getDefaultToolkit().getScreenSize().height;
			this.x = random.nextInt(x);
			this.y = random.nextInt(y);
		}
	}
}

