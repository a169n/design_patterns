package ui;

import decorator.NoiseFilteringDecorator;
import decorator.VisualizationDecorator;
import entities.Signal;
import singleton.AlienDetectionSystem;
import strategy.FourierMethod;
import strategy.ISignalAnalysisStrategy;
import strategy.SpectralAnalysis;

import java.util.Scanner;

public class SignalMenuHandler {
    private AlienDetectionSystem system;

    public SignalMenuHandler(AlienDetectionSystem system) {
        this.system = system;
    }

    public void handleSignalMenu(Scanner scanner) {
        while (true) {
            System.out.println("Signal Menu:");
            System.out.println("1. Receive Signal:");
            System.out.println("2. Analyze Signal:");
            System.out.println("3. Show all Signals");
            System.out.println("4. Clear all Signals");
            System.out.println("5. Back to Main menu");
            System.out.print("Enter your choice: ");

            int signalChoice = scanner.nextInt();
            scanner.nextLine();

            switch (signalChoice) {
                case 1:
                    System.out.print("Enter Signal data: ");
                    String signalData = scanner.nextLine();
                    system.receiveSignal(new Signal(signalData));
                    break;
                case 2:
                    if (system.getSignals().isEmpty()) {
                        System.out.println("No signals to analyze. Please receive a signal first.");
                    } else {
                        analyzeSignal(system, scanner);
                    }
                    break;
                case 3:
                    System.out.println("All Signals:");
                    for (int i = 0; i < system.getSignals().size(); i++) {
                        System.out.println((i + 1) + ". " + system.getSignals().get(i).getData());
                    }
                    break;
                case 4:
                    system.clearAllSignals();
                    System.out.println("All signals have been cleared.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void analyzeSignal(AlienDetectionSystem system, Scanner scanner) {
        System.out.println("Choose a signal to analyze:");
        for (int i = 0; i < system.getSignals().size(); i++) {
            System.out.println((i + 1) + ". " + system.getSignals().get(i).getData());
        }
        System.out.print("Enter the number of the signal to analyze: ");
        int signalNumber = scanner.nextInt();
        scanner.nextLine();

        if(signalNumber >= 1 && signalNumber <= system.getSignals().size()) {
            Signal selectedSignal = system.getSignals().get(signalNumber - 1);
            System.out.println("Choose signal analysis strategy:");
            System.out.println("1. Fourier Method");
            System.out.println("2. Spectral Analysis");
            System.out.print("Enter your choice: ");
            int strategyChoice = scanner.nextInt();
            scanner.nextLine();

            ISignalAnalysisStrategy analysisStrategy = null;
            switch (strategyChoice) {
                case 1:
                    analysisStrategy = new FourierMethod();
                    break;
                case 2:
                    analysisStrategy = new SpectralAnalysis();
                    break;
                default:
                    System.out.println("Invalid strategy choice. Using default strategy (Fourier Method).");
                    analysisStrategy = new FourierMethod();
            }

            analysisStrategy = addDecorators(system, scanner, analysisStrategy);
            analysisStrategy.analyzeSignal(selectedSignal);
        } else {
            System.out.println("Invalid signal selection. Please try again.");
        }
    }

    private static ISignalAnalysisStrategy addDecorators(AlienDetectionSystem system, Scanner scanner, ISignalAnalysisStrategy strategy) {
        int decoratorCount = 0;
        while (decoratorCount < 2) {
            System.out.println("Choose a decorator pattern:");
            System.out.println("1. Noise Filter");
            System.out.println("2. Visualization");
            System.out.println("3. Apply both Decorators");
            System.out.println("4. Finish Decorating");
            System.out.print("Enter your choice: ");

            int decoratorChoice = scanner.nextInt();
            scanner.nextLine();

            switch (decoratorChoice) {
                case 1:
                    strategy = new NoiseFilteringDecorator(strategy);
                    decoratorCount++;
                    break;
                case 2:
                    strategy = new VisualizationDecorator(strategy);
                    decoratorCount++;
                    break;
                case 3:
                    strategy = new NoiseFilteringDecorator(new VisualizationDecorator(strategy));
                    return strategy;
                case 4:
                    return strategy;
                default:
                    System.out.println("Invalid decorator choice. Please try again.");
            }
        }
        return strategy;
    }
}
