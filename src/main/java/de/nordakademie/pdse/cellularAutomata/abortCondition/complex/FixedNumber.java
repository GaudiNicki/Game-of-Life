package de.nordakademie.pdse.cellularAutomata.abortCondition.complex;

import de.nordakademie.pdse.cellularAutomata.experiment.IExperiment;

/**
 * The class <b>FixedNumber</b> represents the implementation of an
 * {@link de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition} with the abort condition of reaching
 * the maximal number of allowed iterations.
 *
 * @author 16513 (merlin.ritsch@nordakademie.de)
 * @author 17015 (til.zoeller@nordakademie.de)
 */

public class FixedNumber extends ComplexAbortCondition{

    public FixedNumber(int maxIterations) {
        super(maxIterations);
    }

    @Override
    public boolean isMetFor(IExperiment experiment) {
        if(experiment.getIterations() < 0) {
            throw new IllegalArgumentException("Current Iteration in Experiment cannot be negative but is: " + experiment.getIterations());
        }

        return (experiment.getIterations() >= this.maxIterations);
    }
}
