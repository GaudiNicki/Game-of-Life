package de.nordakademie.pdse.cellularAutomata.experiment;

import de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition;
import de.nordakademie.pdse.cellularAutomata.grid.Grid2DArray;
import de.nordakademie.pdse.cellularAutomata.log.IExperimentLogger;
import de.nordakademie.pdse.cellularAutomata.neighborhood.Moore;
import de.nordakademie.pdse.cellularAutomata.pattern.simple.AllDeadPattern;
import de.nordakademie.pdse.cellularAutomata.ruleset.GameOfLife;

/**
 * The class <b>GameOfLife_Experiment_3_1</b> represents the implementation of an {@link Experiment} with ruleset
 * GameOfLife, pattern ALL_DEAD, data structure 2DArray and Neighborhood Moore.
 *
 * @author 17015 (til.zoeller@nordakademie.de)
 * @author 16513 (merlin.ritsch@nordakademie.de)
 */
public class GameOfLife_Experiment_3_1 extends Experiment {

	public GameOfLife_Experiment_3_1(IAbortCondition abortCondition, IExperimentLogger logger) {
		super(
				new Grid2DArray(300, 300, new Moore(), new AllDeadPattern()),
				new GameOfLife(),
				abortCondition,
				logger);
	}
}
