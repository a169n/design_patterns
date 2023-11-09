package adapter;

public class AlienSignalAdapter implements ISignalReceiver{
    private RadarSignalReceiver radarSignalReceiver;

    public AlienSignalAdapter(RadarSignalReceiver radarSignalReceiver) {
        this.radarSignalReceiver = radarSignalReceiver;
    }

    @Override
    public void receiveSignal(String signalData) {
        System.out.println("Adapting radar signal for alien detection: " + signalData);
    }
}
