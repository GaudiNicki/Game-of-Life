package de.nordakademie.pdse.cellularAutomata.experiment;

import de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition;
import de.nordakademie.pdse.cellularAutomata.grid.Grid2DList;
import de.nordakademie.pdse.cellularAutomata.log.IExperimentLogger;
import de.nordakademie.pdse.cellularAutomata.neighborhood.Moore;
import de.nordakademie.pdse.cellularAutomata.pattern.complex.TumblerPattern;
import de.nordakademie.pdse.cellularAutomata.ruleset.GameOfLife;

/**
 * The class <b>GameOfLife_Experiment_1_2</b> represents the implementation of an {@link Experiment} with ruleset
 * GameOfLife, pattern Tumbler, data structure 2DList and Neighborhood Moore.
 *
 * @author 17015 (til.zoeller@nordakademie.de)
 * @author 16513 (merlin.ritsch@nordakademie.de)
 */
public class GameOfLife_Experiment_1_2 extends Experiment {

	public GameOfLife_Experiment_1_2(IAbortCondition abortCondition, IExperimentLogger logger) {
		super(
				new Grid2DList(41, 40, new Moore(), new TumblerPattern(17, 17)),
				new GameOfLife(),
				abortCondition,
				logger);
	}
}
