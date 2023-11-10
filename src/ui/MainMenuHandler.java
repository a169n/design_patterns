package ui;

import singleton.AlienDetectionSystem;

import java.util.Scanner;

public class MainMenuHandler {
    private AlienDetectionSystem system;
    private SignalMenuHandler signalMenuHandler;
    private AlienMenuHandler alienMenuHandler;
    private ScientistMenuHandler scientistMenuHandler;
    public MainMenuHandler(AlienDetectionSystem system) {
        this.system = system;
        this.signalMenuHandler = new SignalMenuHandler(system);
        this.alienMenuHandler = new AlienMenuHandler(system);
        this.scientistMenuHandler = new ScientistMenuHandler(system);
    }

    public void start(Scanner scanner) {
        while (true) {
            System.out.println("Alien Detection System Menu:");
            System.out.println("1. Signal");
            System.out.println("2. Alien");
            System.out.println("3. Scientist");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    signalMenuHandler.handleSignalMenu(scanner);
                    break;
                case 2:
                    alienMenuHandler.handleAlienMenu(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Exiting Alien Detection System...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
