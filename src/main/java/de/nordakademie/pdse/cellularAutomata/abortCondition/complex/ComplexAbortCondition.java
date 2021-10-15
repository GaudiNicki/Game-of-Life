package de.nordakademie.pdse.cellularAutomata.abortCondition.complex;

import de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition;

/**
 * The abstract class <b>ComplexAbortCondition</b> serves as abstraction for all abort conditions with a number of
 * maximal iterations to walk through.
 *
 * @author 16513 (merlin.ritsch@nordakademie.de)
 * @author 17015 (til.zoeller@nordakademie.de)
 */

public abstract class ComplexAbortCondition implements IAbortCondition {

    protected final int maxIterations;

    protected ComplexAbortCondition(int maxIterations) {
        this.maxIterations = maxIterations;
    }
}

