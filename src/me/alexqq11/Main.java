package me.alexqq11;


public class Main {

    public static void main(String[] args) {
        // write your code here

        GameEngine engine = new GameEngine(20, 20);
        ConsoleOutputMode com = new ConsoleOutputMode(engine.gameWorld);
        for (int i = 0; i < 20; i++) {
            for (Snake snake : engine.gameWorld.snakes) {
                engine.moveSnake(snake, SnakeDirections.DOWN);
            }
            engine.gameWorld.updateMapObjects();
            com.updateMap(engine.gameWorld);
            com.drawWorldState();
        }
    }
}
