package ui;

import adapter.AlienSignalAdapter;
import adapter.RadarSignalReceiver;
import singleton.AlienDetectionSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AlienSignalAdapter alienSignalAdapter = new AlienSignalAdapter(new RadarSignalReceiver());
        AlienDetectionSystem system = new AlienDetectionSystem(alienSignalAdapter);
        MainMenuHandler menuHandler = new MainMenuHandler(system);

        menuHandler.start(scanner);
    }
}
