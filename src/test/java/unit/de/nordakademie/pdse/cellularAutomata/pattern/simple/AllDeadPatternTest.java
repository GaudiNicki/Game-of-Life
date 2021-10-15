package unit.de.nordakademie.pdse.cellularAutomata.pattern.simple;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;
import de.nordakademie.pdse.cellularAutomata.pattern.simple.AllDeadPattern;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link AllDeadPattern}
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class AllDeadPatternTest {

    private IPattern allDeadPattern;

    private IGrid gridMock;
    private IGrid.IGridConfiguration gridConfigurationMock;

    @Before
    public void beforeEach() {
        this.allDeadPattern = new AllDeadPattern();

        gridConfigurationMock = mock(IGrid.IGridConfiguration.class);
        gridMock = mock(IGrid.class);

        when(gridMock.getGridConfiguration()).thenReturn(gridConfigurationMock);
    }

    @Test
    public void testApplyOnFor3x3Grid() {
        when(gridConfigurationMock.getCols()).thenReturn(3);
        when(gridConfigurationMock.getRows()).thenReturn(3);

        allDeadPattern.applyOn(gridMock);

        verify(gridMock, times(3 * 3)).setState(anyInt(), anyInt(), eq(State.DEAD));
    }

    @Test
    public void testApplyOnFor6x6Grid() {
        when(gridConfigurationMock.getCols()).thenReturn(6);
        when(gridConfigurationMock.getRows()).thenReturn(6);

        allDeadPattern.applyOn(gridMock);

        verify(gridMock, times(6 * 6)).setState(anyInt(), anyInt(), eq(State.DEAD));
    }
}
