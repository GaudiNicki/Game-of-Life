package unit.de.nordakademie.pdse.cellularAutomata.abortCondition;

import de.nordakademie.pdse.cellularAutomata.abortCondition.Simple.NoChange;
import de.nordakademie.pdse.cellularAutomata.experiment.IExperiment;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.log.IExperimentLogger;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link NoChange}
 *
 *  @author 16513 (merlin.ritsch@nordakademie.de)
 *  @author 17015 (til.zoeller@nordakademie.de)
 */
public class NoChangeTest {

    private NoChange noChange;

    private IExperiment experimentMock;
    private IGrid currentGridMock;
    private IExperimentLogger experimentLoggerMock;

    @Before
    public void beforeEach() {
        noChange = new NoChange();

        experimentMock = mock(IExperiment.class);
        currentGridMock = mock(IGrid.class);
        experimentLoggerMock = mock(IExperimentLogger.class);

        when(experimentMock.getCurrentGeneration()).thenReturn(currentGridMock);
        when(experimentMock.getExperimentLogger()).thenReturn(experimentLoggerMock);
    }

    @Test
    public void testIsMetForEqualGrids() {
        when(currentGridMock.equals(any(IGrid.class))).thenReturn(true);
        assertThat(noChange.isMetFor(experimentMock), is(true));
    }

    @Test
    public void testIsDoneWithUnequal() {
        when(currentGridMock.equals(any (IGrid.class))).thenReturn(false);
        assertThat(noChange.isMetFor(experimentMock), is(false));
    }
}
