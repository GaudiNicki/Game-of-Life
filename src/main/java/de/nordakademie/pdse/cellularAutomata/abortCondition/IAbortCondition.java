package de.nordakademie.pdse.cellularAutomata.abortCondition;

import de.nordakademie.pdse.cellularAutomata.experiment.IExperiment;

/**
 * The <b>IAbortCondition</b> interface serves as abstraction for all abort conditions.
 * It can check different abort conditions for Experiments.
 *
 * @author 16513 (merlin.ritsch@nordakademie.de)
 * @author 17015 (til.zoeller@nordakademie.de)
 */

public interface IAbortCondition {
    /**
     * This method is used to determine whether an Experiment fulfills its abort condition or not
     *
     * @param experiment the Experiment that should be checked on completion
     * @return boolean that determines if an experiment is done or not.
     */
     boolean isMetFor(IExperiment experiment);
}
