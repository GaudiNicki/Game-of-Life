package de.nordakademie.pdse.cellularAutomata.experiment;

import de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition;
import de.nordakademie.pdse.cellularAutomata.grid.Grid2DArray;
import de.nordakademie.pdse.cellularAutomata.log.IExperimentLogger;
import de.nordakademie.pdse.cellularAutomata.neighborhood.Moore;
import de.nordakademie.pdse.cellularAutomata.pattern.simple.ChessFieldPattern;
import de.nordakademie.pdse.cellularAutomata.ruleset.GameOfLife;

/**
 * The class <b>GameOfLife_Experiment_2_1</b> represents the implementation of an {@link Experiment} with ruleset
 * GameOfLife, pattern CHESS_FIELD, data structure 2DArray and Neighborhood Moore.
 *
 * @author 17015 (til.zoeller@nordakademie.de)
 * @author 16513 (merlin.ritsch@nordakademie.de)
 */
public class GameOfLife_Experiment_2_1 extends Experiment {

	public GameOfLife_Experiment_2_1(IAbortCondition abortCondition, IExperimentLogger logger) {
		super(
				new Grid2DArray(100, 100, new Moore(), new ChessFieldPattern()),
				new GameOfLife(),
				abortCondition,
				logger);
	}
}
