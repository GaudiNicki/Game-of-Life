package de.nordakademie.pdse.cellularAutomata.experiment;

import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.log.IExperimentLogger;

/**
 * The <b>IExperiment</b> interface serves as abstraction for all Experiments.
 * It can run Experiments with various configurations.
 *
 * @author 16513 (merlin.ritsch@nordakademie.de)
 * @author 17015 (til.zoeller@nordakademie.de)
 */
public interface IExperiment {

    /**
     * This method is used to run an Experiment.
     */
    void run();

    /**
     * This method is used to get the current generation of <b>IGrid</b>
     *
     * @return the current generation of <b>IGrid</b>
     */
    IGrid getCurrentGeneration();

    /**
     * This method is used to get the next generation of <b>IGrid</b> based on the current generation of Grid
     *
     * @return the current generation of <b>IGrid</b>
     */
    IGrid getNextGeneration();

    /**
     * This method is used to get the logger of the <b>Experiment</b>
     *
     * @return logger of <b>Experiment</b>
     */
    IExperimentLogger getExperimentLogger();

    /**
     * This method is used to get the current Iteration of an Experiment run
     *
     * @return current Iteration as integer number
     */
    int getIterations();

}