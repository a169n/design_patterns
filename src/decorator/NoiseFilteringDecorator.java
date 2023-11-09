package decorator;

import entities.Signal;
import strategy.ISignalAnalysisStrategy;

public class NoiseFilteringDecorator extends SignalAnalysisDecorator{
    public NoiseFilteringDecorator(ISignalAnalysisStrategy strategy) {
        super(strategy);
    }

    @Override
    public void analyzeSignal(Signal signal) {
        System.out.println("Applying Noise Filtering...");
        super.analyzeSignal(signal);
    }
}
