package ui;

import observer.IAlienSignalObserver;
import observer.Scientist;
import singleton.AlienDetectionSystem;

import java.util.Scanner;

public class ScientistMenuHandler {
    private AlienDetectionSystem system;

    public ScientistMenuHandler(AlienDetectionSystem system) {
        this.system = system;
    }

    public void handleScientist(Scanner scanner) {
        while(true) {
            System.out.println("Scientist Menu:");
            System.out.println("1. Add Scientist");
            System.out.println("2. Remove Scientist");
            System.out.println("3. Show all Scientists");
            System.out.println("4. Clear all Scientists");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice:" );

            int scientistChoice = scanner.nextInt();
            scanner.nextLine();

            switch (scientistChoice) {
                case 1:
                    System.out.println("Enter scientist name: ");
                    String scientistName = scanner.nextLine();
                    Scientist scientist = new Scientist(scientistName);
                    system.getNotifier().addObserver(scientist);
                    System.out.println(scientistName + " is now observing the signals.");
                    break;
                case 2:
                    removeScientist(system, scanner);
                    break;
                case 3:
                    showAllScientists();
                    break;
                case 4:
                    system.getNotifier().getObservers().clear();
                    System.out.println("All scientists have been cleared");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void removeScientist(AlienDetectionSystem system, Scanner scanner) {
        System.out.println("Select a Scientist to remove:");
        for (int i = 0; i < system.getNotifier().getObservers().size(); i++) {
            System.out.println((i + 1) + ". " + system.getNotifier().getObservers().get(i));
        }

        System.out.print("Enter the number of Scientist to remove: ");
        int scientistNumber = scanner.nextInt();
        scanner.nextLine();

        if(scientistNumber >= 1 && scientistNumber <= system.getNotifier().getObservers().size()) {
            IAlienSignalObserver removedScientist = system.getNotifier().getObservers().remove(scientistNumber - 1);
            System.out.println(removedScientist + " has been removed.");
        } else {
            System.out.println("Invalid Scientist selection. Please try again.");
        }
    }

    private void showAllScientists() {
        System.out.println("All Scientists:");
        for (int i = 0; i < system.getNotifier().getObservers().size(); i++) {
            System.out.println((i + 1) + ". " + system.getNotifier().getObservers().get(i));
        }
    }
}
