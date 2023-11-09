package strategy;

import entities.Signal;

public class SpectralAnalysis implements ISignalAnalysisStrategy{
    @Override
    public void analyzeSignal(Signal signal) {
        System.out.println("Applying Spectral analysis to the signal...");
    }
}
