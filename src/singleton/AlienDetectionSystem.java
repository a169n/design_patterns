package singleton;

import adapter.AlienSignalAdapter;
import adapter.ISignalReceiver;
import entities.Alien;
import entities.Signal;
import observer.AlienSignalNotifier;
import observer.IAlienSignalObserver;

import java.util.ArrayList;
import java.util.List;

public class AlienDetectionSystem {
    private List<Signal> signals;
    private List<Alien> aliens;
    private AlienSignalNotifier notifier;
    private ISignalReceiver signalReceiver;

    public AlienDetectionSystem(AlienSignalAdapter signalReceiver) {
        signals = new ArrayList<>();
        aliens = new ArrayList<>();
        notifier = new AlienSignalNotifier();
        this.signalReceiver = signalReceiver;
    }

    public List<Signal> getSignals() {
        return signals;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public AlienSignalNotifier getNotifier() {
        return notifier;
    }

    public void receiveSignal(Signal signal) {
        signals.add(signal);

        if (signal.getData().contains("Alien signal")) {
            notifier.notifyObservers(signal);
        }

        for (IAlienSignalObserver observer : notifier.getObservers()) {
            observer.update(signal);
        }
    }

    public void clearAllSignals() {
        signals.clear();
    }

    public void clearAllAliens() {
        aliens.clear();
    }

    public ISignalReceiver getSignalReceiver() {
        return signalReceiver;
    }
}
