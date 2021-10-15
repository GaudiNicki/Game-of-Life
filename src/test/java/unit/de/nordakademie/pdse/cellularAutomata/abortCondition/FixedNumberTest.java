package unit.de.nordakademie.pdse.cellularAutomata.abortCondition;

import de.nordakademie.pdse.cellularAutomata.abortCondition.complex.FixedNumber;
import de.nordakademie.pdse.cellularAutomata.experiment.IExperiment;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.mockito.Mockito.*;

/**
 * Test class for {@link FixedNumber}
 *
 *  @author 16513 (merlin.ritsch@nordakademie.de)
 *  @author 17015 (til.zoeller@nordakademie.de)
 */
public class FixedNumberTest {

    private FixedNumber fixedNumber;
    private IExperiment experimentMock;

    @Before
    public void beforeEach() {
        fixedNumber = new FixedNumber(10);
        experimentMock = mock(IExperiment.class);
    }

    @Test
    public void testStopAfterMaxIterations() {
        when(experimentMock.getIterations()).thenReturn(10);
        assertThat(fixedNumber.isMetFor(experimentMock), is(true));
    }

    @Test
    public void testContinueWhenIterationGreaterThanMaxIteration() {
        when(experimentMock.getIterations()).thenReturn(11);
        assertThat(fixedNumber.isMetFor(experimentMock), is(true));
    }

    @Test
    public void testContinueWhenIterationSmallerThanMaxIteration() {
        when(experimentMock.getIterations()).thenReturn(9);
        assertThat(fixedNumber.isMetFor(experimentMock), is(false));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsDoneWithIllegalMaxIterations() {
        when(experimentMock.getIterations()).thenReturn(-5);
        fixedNumber.isMetFor(experimentMock);
    }



}
