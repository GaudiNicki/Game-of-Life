package de.nordakademie.pdse.cellularAutomata.experiment;

import de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.log.IExperimentLogger;
import de.nordakademie.pdse.cellularAutomata.ruleset.IRuleset;

/**
 * The abstract class <b>Experiment</b> serves as abstraction for all Experiments. It can handle various Inputs.
 * The class holds the currentGeneration and the generation after currentGeneration, the used ruleset and the
 * maximal number of iterations.
 *
 * @author 17015 (til.zoeller@nordakademie.de)
 * @author 16513 (merlin.ritsch@nordakademie.de)
 */
public abstract class Experiment implements IExperiment {

	protected IGrid currentGeneration;
	protected final IRuleset ruleset;
	protected final IAbortCondition abortCondition;
	protected final IExperimentLogger logger;

	protected int iterations = 0;

	public Experiment(IGrid currentGeneration, IRuleset ruleset, IAbortCondition abortCondition, IExperimentLogger logger) {
		this.currentGeneration = currentGeneration;
		this.ruleset = ruleset;
		this.abortCondition = abortCondition;
		this.logger = logger;

		this.logger.initAppender(this.getClass().getSimpleName());
	}

	@Override
	public void run() {
		boolean firstIteration = true;

		do {
			if(!firstIteration)
				this.currentGeneration = getNextGeneration();
			else
				firstIteration = false;

			logger.log("### ({})", iterations);
			logger.log(this.currentGeneration.toString());

			iterations++;
		} while (!abortCondition.isMetFor(this));
	}

	@Override
	public IGrid getCurrentGeneration() {return currentGeneration;}

	@Override
	public IGrid getNextGeneration() {return currentGeneration.evolveNextGeneration(ruleset);}

	@Override
	public int getIterations() { return iterations; }

	@Override
	public IExperimentLogger getExperimentLogger() { return logger; }
}
