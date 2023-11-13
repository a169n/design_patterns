package adapter;

public class AlienSignalAdapter implements ISignalReceiver{

    public AlienSignalAdapter(RadarSignalReceiver ignoredRadarSignalReceiver) {
    }

    @Override
    public void receiveSignal(String signalData) {
        System.out.println("Adapting radar signal for alien detection: " + signalData);
    }
}
