package observer;

import entities.Signal;

public class Scientist implements IAlienSignalObserver{
    private String name;
    public Scientist(String name) {
        this.name = name;
    }

    @Override
    public void update(Signal signal) {
        System.out.println(name + " received a signal: " + signal.getData());
    }

    @Override
    public String toString() {
        return "Scientist " + name;
    }
}
