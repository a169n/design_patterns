package strategy;

import entities.Signal;

public class FourierMethod implements ISignalAnalysisStrategy{
    @Override
    public void analyzeSignal(Signal signal) {
        System.out.println("Applying Fourier analysis to the signal...");
    }
}
