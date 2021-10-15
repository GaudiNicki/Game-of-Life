package de.nordakademie.pdse.cellularAutomata.abortCondition.complex;

import de.nordakademie.pdse.cellularAutomata.experiment.IExperiment;

/**
 * The class <b>FixedNumberOrNoChange</b> represents the implementation of an
 * {@link de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition} with the abort condition of reaching
 * the maximal number of allowed iterations or no change between the current generation of a grid and its next
 * generation, whatever happens first.
 *
 * @author 16513 (merlin.ritsch@nordakademie.de)
 * @author 17015 (til.zoeller@nordakademie.de)
 */

public class FixedNumberOrNoChange extends ComplexAbortCondition {

    public FixedNumberOrNoChange(int maxIterations) {
        super(maxIterations);
    }

    @Override
    public boolean isMetFor(IExperiment experiment) {
        if(experiment.getIterations() >= this.maxIterations) return true;
        if(experiment.getCurrentGeneration().equals(experiment.getNextGeneration())) {
            experiment.getExperimentLogger().log("### ({})", experiment.getIterations());
            experiment.getExperimentLogger().log(experiment.getCurrentGeneration().toString());
            return true;
        }
        return false;
    }
}
