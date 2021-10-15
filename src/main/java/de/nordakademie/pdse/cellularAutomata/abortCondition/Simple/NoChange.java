package de.nordakademie.pdse.cellularAutomata.abortCondition.Simple;

import de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition;
import de.nordakademie.pdse.cellularAutomata.experiment.IExperiment;
import de.nordakademie.pdse.cellularAutomata.log.IExperimentLogger;

/**
 * The class <b>NoChange</b> represents the implementation of an
 * {@link de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition} with the abort condition of no change
 * between the current generation of a grid and its next generation.
 *
 * @author 16513 (merlin.ritsch@nordakademie.de)
 * @author 17015 (til.zoeller@nordakademie.de)
 */

public class NoChange implements IAbortCondition {
    @Override
    public boolean isMetFor(IExperiment experiment) {
        int iterations;
        IExperimentLogger logger;
        if(experiment.getCurrentGeneration().equals(experiment.getNextGeneration())) {
            experiment.getExperimentLogger().log("### ({})", experiment.getIterations());
            experiment.getExperimentLogger().log(experiment.getCurrentGeneration().toString());
            return true;
        }
        return false;
    }
}
