package unit.de.nordakademie.pdse.cellularAutomata.pattern.simple;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;
import de.nordakademie.pdse.cellularAutomata.pattern.simple.ChessFieldPattern;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link ChessFieldPattern}
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class ChessFieldPatternTest {

    private IPattern chessFieldPattern;

    private IGrid gridMock;
    private IGrid.IGridConfiguration gridConfigurationMock;

    @Before
    public void beforeEach() {
        this.chessFieldPattern = new ChessFieldPattern();

        gridConfigurationMock = mock(IGrid.IGridConfiguration.class);
        gridMock = mock(IGrid.class);

        when(gridMock.getGridConfiguration()).thenReturn(gridConfigurationMock);
    }

    @Test
    public void testApplyOnFor3x3Grid() {
        when(gridConfigurationMock.getCols()).thenReturn(3);
        when(gridConfigurationMock.getRows()).thenReturn(3);

        chessFieldPattern.applyOn(gridMock);

        verify(gridMock, times(3 * 3 / 2)).setState(anyInt(), anyInt(), eq(State.DEAD));
        verify(gridMock, times(3 * 3 / 2 + 1)).setState(anyInt(), anyInt(), eq(State.ALIVE));
    }

    @Test
    public void testApplyOnFor6x6Grid() {
        when(gridConfigurationMock.getCols()).thenReturn(6);
        when(gridConfigurationMock.getRows()).thenReturn(6);

        chessFieldPattern.applyOn(gridMock);

        verify(gridMock, times(6 * 6 / 2)).setState(anyInt(), anyInt(), eq(State.DEAD));
        verify(gridMock, times(6 * 6 / 2)).setState(anyInt(), anyInt(), eq(State.ALIVE));
    }
}
