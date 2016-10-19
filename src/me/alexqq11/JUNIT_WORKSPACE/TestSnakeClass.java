package me.alexqq11.JUNIT_WORKSPACE;

import static org.junit.Assert.*;
import me.alexqq11.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Arina Melnichuk on 10/11/2016.
 */

public class TestSnakeClass {

    protected GameEngine engine;
    protected Snake snake;
    protected ArrayList<SnakeDirections> directions;
    protected ArrayList<BonusType> bonusTypes;
    protected ArrayList<Bonus> bonuses;

    protected void init() {
        engine = new GameEngine(20,20);
        snake = new Snake(20,20 ,10,10,1);
        directions = new ArrayList<SnakeDirections>(Arrays.asList(SnakeDirections.DOWN, SnakeDirections.UP,
                SnakeDirections.LEFT, SnakeDirections.RIGHT));
        bonusTypes = new ArrayList<BonusType>(Arrays.asList(BonusType.APPLE, BonusType.CANDY,
                BonusType.PEACH, BonusType.TOADSTOOL));
        bonuses = new ArrayList<Bonus>();
        for (BonusType bonusType : bonusTypes) {
            bonuses.add(new Bonus(13,10,bonusType));
        }
    }

    @Test
    public void testCorrectSnakeMovements() {
        for (int i = 0; i < 10; i++) {
            for (SnakeDirections direction : directions) {
                engine.moveSnake(snake, direction);
                assertEquals(snake.x , engine.gameWorld.snakes.getFirst().x);
            }
        }
    }

    @Test
    public void testBonusSnakeCrossing() {
        for (Bonus bonus : bonuses) {
            snake.y = bonus.y;
            snake.x = bonus.x;
            assertTrue(bonus.isCatched);
        }
    }

    @Test
    public void testCorrectSnakeGrowth() {
        int previousLength = snake.getLength();
            assertFalse(snake.getLength() == previousLength);

    }
}
