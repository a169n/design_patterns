package ui;

import entities.Alien;
import entities.Signal;
import factory.AlienFactory;
import singleton.AlienDetectionSystem;

import java.util.Scanner;

public class AlienMenuHandler {
    private final AlienDetectionSystem system;

    public AlienMenuHandler(AlienDetectionSystem system) {
        this.system = system;
    }

    public void handleAlienMenu(Scanner scanner) {
        while (true) {
            System.out.println("Alien menu:");
            System.out.println("1. Create Aliens");
            System.out.println("2. Remove Alien");
            System.out.println("3. Show all Aliens");
            System.out.println("4. Clear all Aliens");
            System.out.println("5. Receive Alien Signal");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int alienChoice = scanner.nextInt();
            scanner.nextLine();

            switch (alienChoice) {
                case 1:
                    createAliens(system, scanner);
                    break;
                case 2:
                    removeAlien(system, scanner);
                    break;
                case 3:
                    showAllAliens();
                    break;
                case 4:
                    system.clearAllAliens();
                    System.out.println("All Aliens have been cleared.");
                    break;
                case 5:
                    receiveAlienSignal(system, scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void createAliens(AlienDetectionSystem system, Scanner scanner) {
        System.out.print("Enter Alien name: ");
        String alienName = scanner.nextLine();
        System.out.println("Choose Alien type:");
        System.out.println("1. Green Alien");
        System.out.println("2. Red Alien");
        System.out.print("Enter your choice: ");

        int alienTypeChoice = scanner.nextInt();
        scanner.nextLine();

        Alien alien = null;

        switch (alienTypeChoice) {
            case 1:
                alien = AlienFactory.createAlien(alienName, "Green");
                break;
            case 2 :
                alien = AlienFactory.createAlien(alienName, "Red");
                break;
            default:
                System.out.println("Invalid ALien type choice. Alien not created.");
        }

        if (alien != null) {
            system.getAliens().add(alien);
            System.out.println(alien.getName() + " has been created.");
        }
    }

    public void showAllAliens() {
        System.out.println("All Aliens:");
        for (int i = 0; i < system.getAliens().size(); i++) {
            System.out.println((i + 1) + ". " + system.getAliens().get(i).getType() + " alien " + system.getAliens().get(i).getName());
        }
    }

    public void removeAlien(AlienDetectionSystem system, Scanner scanner) {
        System.out.println("Select an Alien to remove:");
        for(int i = 0; i < system.getAliens().size(); i++) {
            System.out.println((i + 1) + ". " + system.getAliens().get(i).getName());
        }
        System.out.print("Enter the number of alien to remove: ");
        int alienNumber = scanner.nextInt();
        scanner.nextLine();

        if (alienNumber >= 1 && alienNumber <= system.getAliens().size()) {
            Alien removedAlien = system.getAliens().remove(alienNumber - 1);
            System.out.println(removedAlien.getName() + " has been removed.");
        } else {
            System.out.println("Invalid Alien selection. Please try again.");
        }
    }

    public void receiveAlienSignal(AlienDetectionSystem system, Scanner scanner) {
        if(system.getAliens().isEmpty()) {
            System.out.println("No Aliens available to send signals. Create Aliens first.");
            return;
        }

        System.out.println("Select an Alien to send a signal:");
        for (int i = 0; i < system.getAliens().size(); i++) {
            System.out.println((i + 1) + ". " + system.getAliens().get(i).getName());
        }

        System.out.print("Enter the number of ALien: ");
        int alienNumber = scanner.nextInt();
        scanner.nextLine();

        if (alienNumber >= 1 && alienNumber <= system.getAliens().size()) {
            Alien selectedAlien = system.getAliens().get(alienNumber - 1);
            System.out.print("Enter signal data: ");
            String signalData = "Alien signal from " + selectedAlien.getName() + ": " + scanner.nextLine();
            system.receiveSignal(new Signal(signalData));
            System.out.println("Signal received from " + selectedAlien.getName());
        } else {
            System.out.println("Invalid Alien Selection. Please try again.");
        }
    }
}
