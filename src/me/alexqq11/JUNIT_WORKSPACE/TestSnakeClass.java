package me.alexqq11.JUNIT_WORKSPACE;

import static org.junit.Assert.*;
import me.alexqq11.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


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
        /*engine = new GameEngine(20,20);
        snake = new Snake(20,20 ,10,10,1);
        directions = new ArrayList<SnakeDirections>(Arrays.asList(SnakeDirections.DOWN, SnakeDirections.UP,
                SnakeDirections.LEFT, SnakeDirections.RIGHT));
        bonusTypes = new ArrayList<BonusType>(Arrays.asList(BonusType.APPLE, BonusType.CANDY,
                BonusType.PEACH, BonusType.TOADSTOOL));
        bonuses = new ArrayList<Bonus>();
        for (BonusType bonusType : bonusTypes) {
            bonuses.add(new Bonus(13,10,bonusType));}
            */

    }

    @Test
    public void testCorrectSnakeMovementsDownInOneFrame() {
        //default snake position 10 10
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.DOWN));
        for (int i = 0; i < 5; i++) {
            engine.handlClientOperations(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 10 && snake.y == 15);
    }
    @Test
    public void testCorrectSnakeMovementsDownInTwoFrames() {
        //default snake position 10 10
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.DOWN));
        for (int i = 0; i < 20; i++) {
            engine.handlClientOperations(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 10 && snake.y == 10);
    }

    @Test
    public void testCorrectSnakeMovementsUpInOneFrames() {
        //default snake position 10 10
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.UP));
        for (int i = 0; i < 5; i++) {
            engine.handlClientOperations(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 10 && snake.y == 5);
    }

    @Test
    public void testCorrectSnakeMovementsUpInTwoFrames() {
        //default snake position 10 10
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.UP));
        for (int i = 0; i < 20; i++) {
            engine.handlClientOperations(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 10 && snake.y == 10);
    }

    @Test
    public void testCorrectSnakeMovementsLeftInOneFrames() {
        //default snake position 10 10
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.LEFT));
        for (int i = 0; i < 5; i++) {
            engine.handlClientOperations(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 5 && snake.y == 10);
    }

    @Test
    public void testCorrectSnakeMovementsLeftInTwoFrames() {
        //default snake position 10 10
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.LEFT));
        for (int i = 0; i < 20; i++) {
            engine.handlClientOperations(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 10 && snake.y == 10);
    }
    @Test
    public void testCorrectSnakeMovementBackRight() {
        //default snake position 10 10
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.RIGHT));
        for (int i = 0; i < 11; i++) {
            engine.handlClientOperations(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 10 && snake.y == 10);
    }
    @Test
    public void testCorrectSnakeMovementHardtest() {
        //default snake position 10 10
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.UP));
        for (int i = 0; i < 19; i++) {
            engine.handlClientOperations(signal);
        }
        signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.RIGHT));
        for (int i = 0; i < 8; i++) {
            engine.handlClientOperations(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 18 && snake.y == 11);
    }
    /////////////////////////////////////////////////////
    @Test
    public void testBonusEatingAndAnigilation() {
        //default snake position 10 10
        // bonus 10 13
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.DOWN));
        Snake snake = engine.gameWorld.snakes.getFirst();
        int amountOfBonuses = engine.gameWorld.bonuses.size();
        int startLength = snake.getLength();
        for (int i = 0; i < 5; i++) {
            engine.handlClientOperations(signal);
        }
        assertTrue(snake.getLength() != startLength && engine.gameWorld.bonuses.size() == amountOfBonuses - 1 );
    }
    @Test
    public void testBonusEatingOnePointWeight() {
        //default snake position 10 10
        // bonus 10 13
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.DOWN));
        Snake snake = engine.gameWorld.snakes.getFirst();
        int amountOfBonuses = engine.gameWorld.bonuses.size();
        int startLength = snake.getLength();
        for (int i = 0; i < 5; i++) {
            engine.handlClientOperations(signal);
        }
        assertTrue(snake.getLength() == startLength + 1 && engine.gameWorld.bonuses.size() == amountOfBonuses - 1 );
    }
    @Test
    public void DIETESTWOOOOO(){
        //default snake position 10 10
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.DOWN));
        for (int i = 0; i < 3; i++) {
            engine.handlClientOperations(signal);
        }
        signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.RIGHT));
        for (int i = 0; i < 1; i++) {
            engine.handlClientOperations(signal);
        }
        signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.UP));
        for (int i = 0; i < 1; i++) {
            engine.handlClientOperations(signal);
        }
        signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.LEFT));
        for (int i = 0; i < 1; i++) {
            engine.handlClientOperations(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertFalse(engine.clients.getFirst().getStatus());
    }

    @Test
    public void testObstacleDie() {
        //default snake position 10 10
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.UP));
        for (int i = 0; i < 9; i++) {
            engine.handlClientOperations(signal);
        }
        signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.LEFT));
        for (int i = 0; i < 9; i++) {
            engine.handlClientOperations(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertFalse(snake.isAlive());
    }
    @Test
    public void testObstacleCollisionClientDisable() {
        //default snake position 10 10
        GameEngine engine = new GameEngine(20, 20);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.UP));
        for (int i = 0; i < 9; i++) {
            engine.handlClientOperations(signal);
        }
        signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.LEFT));
        for (int i = 0; i < 9; i++) {
            engine.handlClientOperations(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertFalse(engine.clients.getFirst().getStatus());
    }

}
