package unit.de.nordakademie.pdse.cellularAutomata.experiment;

import de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition;
import de.nordakademie.pdse.cellularAutomata.experiment.IExperiment;
import de.nordakademie.pdse.cellularAutomata.experiment.Parity_Experiment_1_1;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.log.IExperimentLogger;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Test class for {@link Parity_Experiment_1_1}
 *
 * @author 16513 (merlin.ritsch@nordakademie.de)
 * @author 17015 (til.zoeller@nordakademie.de)
 */
public class Parity_Experiment_1_1Test {

	private IExperiment experiment;
	private IAbortCondition abortConditionMock;

	@Before
	public void beforeEach() {
		this.abortConditionMock = mock(IAbortCondition.class);
		IExperimentLogger experimentLoggerMock = mock(IExperimentLogger.class);
		this.experiment = new Parity_Experiment_1_1(abortConditionMock,
				experimentLoggerMock);
	}

	@Test
	public void testRunWithoutNewGeneration() {
		when(abortConditionMock.isMetFor(any(IExperiment.class))).thenReturn(true);

		experiment.run();

		verify(abortConditionMock, times(1)).isMetFor(any(IExperiment.class));
		assertThat(experiment.getIterations(), is(1));
	}

	@Test
	public void testRunWithOneNewGeneration() {
		when(abortConditionMock.isMetFor(any(IExperiment.class))).thenReturn(false, true);

		experiment.run();

		verify(abortConditionMock, times(2)).isMetFor(any(IExperiment.class));
		assertThat(experiment.getIterations(), is(2));
	}

	@Test
	public void testRunWithFiveNewGenerations() {
		when(abortConditionMock.isMetFor(any(IExperiment.class))).thenReturn(false, false, false, false, false, true);

		experiment.run();

		verify(abortConditionMock, times(6)).isMetFor(any(IExperiment.class));
		assertThat(experiment.getIterations(), is(6));
	}

	@Test
	public void testGetCurrentGeneration() {
		assertThat(experiment.getCurrentGeneration(), isA(IGrid.class));
	}

	@Test
	public void testGetIteration() {
		assertThat(experiment.getIterations(), isA(Integer.class));
	}

	@Test
	public void testGetExperimentLogger() {
		assertThat(experiment.getExperimentLogger(), isA(IExperimentLogger.class));
	}
}