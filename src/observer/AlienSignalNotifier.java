package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class AlienSignalNotifier extends Observable{
    private final List<Scientist> observers = new ArrayList<>();

    private int observerCount = 0;

    public void addObserver(Scientist observer) {
        observers.add(observer);
        observerCount++;
        setChanged();
        notifyObservers();
    }

    public List<Scientist> getObservers() {
        return observers;
    }

    public int countObservers() {
        return observerCount;
    }
}
