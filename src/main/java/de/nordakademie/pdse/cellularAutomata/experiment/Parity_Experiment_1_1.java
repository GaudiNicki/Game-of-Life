package de.nordakademie.pdse.cellularAutomata.experiment;

import de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition;
import de.nordakademie.pdse.cellularAutomata.grid.Grid2DArray;
import de.nordakademie.pdse.cellularAutomata.log.IExperimentLogger;
import de.nordakademie.pdse.cellularAutomata.neighborhood.VonNeumann;
import de.nordakademie.pdse.cellularAutomata.pattern.complex.SquarePattern;
import de.nordakademie.pdse.cellularAutomata.ruleset.Parity;

/**
 * The class <b>Parity_Experiment_1_1</b> represents the implementation of an {@link Experiment} with ruleset
 * Parity, pattern MIDDLE_SQUARE, data structure 2DArray and Neighborhood VON_NEUMANN.
 *
 * @author 17015 (til.zoeller@nordakademie.de)
 * @author 16513 (merlin.ritsch@nordakademie.de)
 */
public class Parity_Experiment_1_1 extends Experiment {

	public Parity_Experiment_1_1(IAbortCondition abortCondition, IExperimentLogger logger) {
		super(
				new Grid2DArray(400, 400, new VonNeumann(), new SquarePattern(199, 199)),
				new Parity(),
				abortCondition,
				logger);
	}
}
