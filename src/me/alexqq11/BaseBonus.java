package me.alexqq11;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;


public class BaseBonus {
	public int pointsSize;
	public Point position;
	public boolean isCatched;
	public Rectangle collider;
	
	public BaseBonus() {
		pointsSize = 10;
		Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
		position.x = -sSize.width;
		position.y = sSize.height;
	}

	public void positionEquals(Essence essence) {
		if (this.position.x == essence.x && this.position.y == essence.y) {
			isCatched = true;
		}
	}

	public void pointsUp(PlayerClient player) {    // точно не здесь нужно
		if (isCatched) {
			player.score += pointsSize;
		}
	}

	public void moveBonus() {
		if (isCatched) {
			Random random = new Random();
			int x = Toolkit.getDefaultToolkit().getScreenSize().width;
			int y = Toolkit.getDefaultToolkit().getScreenSize().height;
			position.x = random.nextInt(x);
			position.y = random.nextInt(y);
		}
	}
}
