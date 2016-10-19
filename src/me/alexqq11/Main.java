package me.alexqq11;


import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // write your code here

        GameEngine engine = new GameEngine(20, 20);
        ConsoleOutputMode com = new ConsoleOutputMode(engine.gameWorld);
        LinkedList<ClientDirectionSignal> signal = new LinkedList<>();
        signal.addLast(new ClientDirectionSignal(1, SnakeDirections.DOWN));
        for (int i = 0; i < 20; i++) {
            engine.handlClientOperations(signal);
            engine.gameWorld.updateMapObjects();
            com.updateMap(engine.gameWorld);
            com.drawWorldState();
        }
    }
}
