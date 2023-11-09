package decorator;

import entities.Signal;
import strategy.ISignalAnalysisStrategy;

public class VisualizationDecorator extends SignalAnalysisDecorator{
    public VisualizationDecorator(ISignalAnalysisStrategy strategy) {
        super(strategy);
    }

    @Override
    public void analyzeSignal(Signal signal) {
        System.out.println("Applying signal Visualization...");
        super.analyzeSignal(signal);
    }
}
