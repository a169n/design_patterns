package ui;

import singleton.AlienDetectionSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        AlienDetectionSystem system = new AlienDetectionSystem();
        MainMenuHandler menuHandler = new MainMenuHandler(system);

        menuHandler.start(scanner);
    }
}
