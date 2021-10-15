package unit.de.nordakademie.pdse.cellularAutomata.pattern.complex;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.exceptions.GridTooSmallException;
import de.nordakademie.pdse.cellularAutomata.exceptions.InvalidCellException;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.pattern.complex.IComplexPattern;
import de.nordakademie.pdse.cellularAutomata.pattern.complex.TumblerPattern;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link TumblerPattern}
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class TumblerPatternTest {

    private IComplexPattern tumblerPattern;

    private IGrid gridMock;
    private IGrid.IGridConfiguration gridConfigurationMock;

    @Before
    public void beforeEach() {
        this.gridMock = mock(IGrid.class);
        this.gridConfigurationMock = mock(IGrid.IGridConfiguration.class);

        when(gridMock.getGridConfiguration()).thenReturn(gridConfigurationMock);
    }

    @Test(expected = InvalidCellException.class)
    public void testApplyOnWithInvalidStartingPosition() {
        this.tumblerPattern = new TumblerPattern(-1,-1);

        when(gridMock.invalidCell(-1,-1)).thenReturn(true);

        tumblerPattern.applyOn(gridMock);
    }

    @Test(expected = GridTooSmallException.class)
    public void testApplyOnWithNotEnoughColumns() {
        this.tumblerPattern = new TumblerPattern(0,0);

        when(gridMock.invalidCell(anyInt(), anyInt())).thenReturn(false);
        when(gridConfigurationMock.getCols()).thenReturn(3);
        when(gridConfigurationMock.getRows()).thenReturn(10);

        tumblerPattern.applyOn(gridMock);
    }

    @Test(expected = GridTooSmallException.class)
    public void testApplyOnWithNotEnoughRows() {
        this.tumblerPattern = new TumblerPattern(0,0);

        when(gridMock.invalidCell(anyInt(), anyInt())).thenReturn(false);
        when(gridConfigurationMock.getCols()).thenReturn(10);
        when(gridConfigurationMock.getRows()).thenReturn(3);

        tumblerPattern.applyOn(gridMock);
    }

    @Test
    public void testApplyOnFor7x6Grid() {
        this.tumblerPattern = new TumblerPattern(0,0);

        when(gridMock.invalidCell(anyInt(), anyInt())).thenReturn(false);
        when(gridConfigurationMock.getCols()).thenReturn(7);
        when(gridConfigurationMock.getRows()).thenReturn(6);

        tumblerPattern.applyOn(gridMock);

        verify(gridMock).setState(0, 3, State.ALIVE);
        verify(gridMock).setState(0, 4, State.ALIVE);
        verify(gridMock).setState(0, 5, State.ALIVE);
        verify(gridMock).setState(1, 0, State.ALIVE);
        verify(gridMock).setState(1, 1, State.ALIVE);
        verify(gridMock).setState(1, 5, State.ALIVE);
        verify(gridMock).setState(2, 0, State.ALIVE);
        verify(gridMock).setState(2, 1, State.ALIVE);
        verify(gridMock).setState(2, 2, State.ALIVE);
        verify(gridMock).setState(2, 3, State.ALIVE);
        verify(gridMock).setState(2, 4, State.ALIVE);
        verify(gridMock).setState(4, 0, State.ALIVE);
        verify(gridMock).setState(4, 1, State.ALIVE);
        verify(gridMock).setState(4, 2, State.ALIVE);
        verify(gridMock).setState(4, 3, State.ALIVE);
        verify(gridMock).setState(4, 4, State.ALIVE);
        verify(gridMock).setState(5, 0, State.ALIVE);
        verify(gridMock).setState(5, 1, State.ALIVE);
        verify(gridMock).setState(5, 5, State.ALIVE);
        verify(gridMock).setState(6, 3, State.ALIVE);
        verify(gridMock).setState(6, 4, State.ALIVE);
        verify(gridMock).setState(6, 5, State.ALIVE);
    }

    @Test
    public void testApplyOnFor10x10Grid() {
        this.tumblerPattern = new TumblerPattern(2,2);

        when(gridMock.invalidCell(anyInt(), anyInt())).thenReturn(false);
        when(gridConfigurationMock.getCols()).thenReturn(10);
        when(gridConfigurationMock.getRows()).thenReturn(10);

        tumblerPattern.applyOn(gridMock);

        verify(gridMock).setState(2, 5, State.ALIVE);
        verify(gridMock).setState(2, 6, State.ALIVE);
        verify(gridMock).setState(2, 7, State.ALIVE);
        verify(gridMock).setState(3, 2, State.ALIVE);
        verify(gridMock).setState(3, 3, State.ALIVE);
        verify(gridMock).setState(3, 7, State.ALIVE);
        verify(gridMock).setState(4, 2, State.ALIVE);
        verify(gridMock).setState(4, 3, State.ALIVE);
        verify(gridMock).setState(4, 4, State.ALIVE);
        verify(gridMock).setState(4, 5, State.ALIVE);
        verify(gridMock).setState(4, 6, State.ALIVE);
        verify(gridMock).setState(6, 2, State.ALIVE);
        verify(gridMock).setState(6, 3, State.ALIVE);
        verify(gridMock).setState(6, 4, State.ALIVE);
        verify(gridMock).setState(6, 5, State.ALIVE);
        verify(gridMock).setState(6, 6, State.ALIVE);
        verify(gridMock).setState(7, 2, State.ALIVE);
        verify(gridMock).setState(7, 3, State.ALIVE);
        verify(gridMock).setState(7, 7, State.ALIVE);
        verify(gridMock).setState(8, 5, State.ALIVE);
        verify(gridMock).setState(8, 6, State.ALIVE);
        verify(gridMock).setState(8, 7, State.ALIVE);
    }

    @Test
    public void testGetPatternCols() {
        this.tumblerPattern = new TumblerPattern(0,0);
        assertThat(tumblerPattern.getPatternCols(), is(7));
    }

    @Test
    public void testGetPatternRows() {
        this.tumblerPattern = new TumblerPattern(0,0);
        assertThat(tumblerPattern.getPatternRows(), is(6));
    }

    @Test
    public void testGetStartingCol() {
        this.tumblerPattern = new TumblerPattern(5,7);
        assertThat(tumblerPattern.getStartingCol(), is(5));
    }

    @Test
    public void testGetStartingRow() {
        this.tumblerPattern = new TumblerPattern(5,7);
        assertThat(tumblerPattern.getStartingRow(), is(7));
    }
}
