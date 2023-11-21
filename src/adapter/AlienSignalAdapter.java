package adapter;

import observer.AlienSignalNotifier;

public class AlienSignalAdapter implements ISignalReceiver{
    private final RadarSignalReceiver radarSignalReceiver;
    private final AlienSignalNotifier  alienSignalNotifier;

    public AlienSignalAdapter(RadarSignalReceiver radarSignalReceiver, AlienSignalNotifier alienSignalNotifier) {
        this.radarSignalReceiver = radarSignalReceiver;
        this.alienSignalNotifier = alienSignalNotifier;
    }

    @Override
    public void receiveSignal(String signalData) {
        radarSignalReceiver.receiveSignal("Adapted: " + signalData);
        alienSignalNotifier.notifyObservers(signalData);


    }
}
