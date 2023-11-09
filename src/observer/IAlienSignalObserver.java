package observer;

import entities.Signal;

public interface IAlienSignalObserver {
    void update(Signal signal);
}
