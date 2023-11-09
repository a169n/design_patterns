package ui;

import singleton.AlienDetectionSystem;

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
}
