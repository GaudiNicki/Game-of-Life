package unit.de.nordakademie.pdse.cellularAutomata.abortCondition;

import de.nordakademie.pdse.cellularAutomata.abortCondition.complex.FixedNumberOrNoChange;
import de.nordakademie.pdse.cellularAutomata.experiment.IExperiment;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.log.IExperimentLogger;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.mockito.Mockito.*;

/**
 * Test class for {@link FixedNumberOrNoChange}
 *
 *  @author 16513 (merlin.ritsch@nordakademie.de)
 *  @author 17015 (til.zoeller@nordakademie.de)
 */
public class FixedNumberOrNoChangeTest {

    private FixedNumberOrNoChange fixedNumberOrNoChange;

    private IExperiment experimentMock;
    private IGrid currentGridMock;
    private IExperimentLogger experimentLoggerMock;

    @Before
    public void beforeEach() {
        fixedNumberOrNoChange = new FixedNumberOrNoChange(10);

        experimentMock = mock(IExperiment.class);
        currentGridMock = mock(IGrid.class);
        experimentLoggerMock = mock(IExperimentLogger.class);

        when(experimentMock.getCurrentGeneration()).thenReturn(currentGridMock);
        when(experimentMock.getExperimentLogger()).thenReturn(experimentLoggerMock);
    }

    @Test
    public void testStopEqualsMaxIterationsAndChange() {
        when(currentGridMock.equals(any (IGrid.class))).thenReturn(false);
        when(experimentMock.getIterations()).thenReturn(10);

        assertThat(fixedNumberOrNoChange.isMetFor(experimentMock), is(true));
    }

    @Test
    public void testContinueBeforeMaxIterationAndChange() {
        when(currentGridMock.equals(any (IGrid.class))).thenReturn(false);
        when(experimentMock.getIterations()).thenReturn(9);

        assertThat(fixedNumberOrNoChange.isMetFor(experimentMock), is(false));
    }

    @Test
    public void testIsDoneBeforeMaxIterationAndNoChange() {
        when(currentGridMock.equals(any (IGrid.class))).thenReturn(true);
        when(experimentMock.getIterations()).thenReturn(9);

        assertThat(fixedNumberOrNoChange.isMetFor(experimentMock), is(true));
    }

    @Test
    public void testIsDoneEqualsMaxIterationAndNoChange() {
        when(currentGridMock.equals(any (IGrid.class))).thenReturn(true);
        when(experimentMock.getIterations()).thenReturn(10);

        assertThat(fixedNumberOrNoChange.isMetFor(experimentMock), is(true));
    }

    @Test
    public void testIsDoneAfterMaxIterationAndChange() {
        when(currentGridMock.equals(any (IGrid.class))).thenReturn(false);
        when(experimentMock.getIterations()).thenReturn(11);

        assertThat(fixedNumberOrNoChange.isMetFor(experimentMock), is(true));
    }





}
