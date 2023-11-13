package decorator;

import entities.Signal;
import strategy.ISignalAnalysisStrategy;

public class SignalAnalysisDecorator implements ISignalAnalysisStrategy {
    private final ISignalAnalysisStrategy strategy;
    public SignalAnalysisDecorator(ISignalAnalysisStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void analyzeSignal(Signal signal) {
        strategy.analyzeSignal(signal);
    }
}
