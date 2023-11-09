package adapter;

public class RadarSignalReceiver implements ISignalReceiver{
    @Override
    public void receiveSignal(String signalData) {
        System.out.println("Receiving signal from radar: " + signalData);
    }
}
