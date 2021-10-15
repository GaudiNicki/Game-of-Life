package unit.de.nordakademie.pdse.cellularAutomata.pattern.complex;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.exceptions.GridTooSmallException;
import de.nordakademie.pdse.cellularAutomata.exceptions.InvalidCellException;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.pattern.complex.IComplexPattern;
import de.nordakademie.pdse.cellularAutomata.pattern.complex.SquarePattern;
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
 * Test class for {@link SquarePattern}
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class SquarePatternTest {

    private IComplexPattern squarePattern;

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
        this.squarePattern = new SquarePattern(-1,-1);

        when(gridMock.invalidCell(-1,-1)).thenReturn(true);

        squarePattern.applyOn(gridMock);
    }

    @Test(expected = GridTooSmallException.class)
    public void testApplyOnWithNotEnoughColumns() {
        this.squarePattern = new SquarePattern(0,0);

        when(gridMock.invalidCell(anyInt(), anyInt())).thenReturn(false);
        when(gridConfigurationMock.getCols()).thenReturn(1);
        when(gridConfigurationMock.getRows()).thenReturn(10);

        squarePattern.applyOn(gridMock);
    }

    @Test(expected = GridTooSmallException.class)
    public void testApplyOnWithNotEnoughRows() {
        this.squarePattern = new TumblerPattern(0,0);

        when(gridMock.invalidCell(anyInt(), anyInt())).thenReturn(false);
        when(gridConfigurationMock.getCols()).thenReturn(10);
        when(gridConfigurationMock.getRows()).thenReturn(1);

        squarePattern.applyOn(gridMock);
    }

    @Test
    public void testApplyOnFor2x2Grid() {
        this.squarePattern = new SquarePattern(0,0);

        when(gridMock.invalidCell(anyInt(), anyInt())).thenReturn(false);
        when(gridConfigurationMock.getCols()).thenReturn(2);
        when(gridConfigurationMock.getRows()).thenReturn(2);

        squarePattern.applyOn(gridMock);

        verify(gridMock).setState(0, 0, State.ALIVE);
        verify(gridMock).setState(0, 1, State.ALIVE);
        verify(gridMock).setState(1, 0, State.ALIVE);
        verify(gridMock).setState(1, 1, State.ALIVE);
    }

    @Test
    public void testApplyOnFor10x10Grid() {
        this.squarePattern = new SquarePattern(4,4);

        when(gridMock.invalidCell(anyInt(), anyInt())).thenReturn(false);
        when(gridConfigurationMock.getCols()).thenReturn(10);
        when(gridConfigurationMock.getRows()).thenReturn(10);

        squarePattern.applyOn(gridMock);

        verify(gridMock).setState(4, 4, State.ALIVE);
        verify(gridMock).setState(4, 5, State.ALIVE);
        verify(gridMock).setState(5, 4, State.ALIVE);
        verify(gridMock).setState(5, 5, State.ALIVE);
    }

    @Test
    public void testGetPatternCols() {
        this.squarePattern = new SquarePattern(0,0);
        assertThat(squarePattern.getPatternCols(), is(2));
    }

    @Test
    public void testGetPatternRows() {
        this.squarePattern = new SquarePattern(0,0);
        assertThat(squarePattern.getPatternRows(), is(2));
    }

    @Test
    public void testGetStartingCol() {
        this.squarePattern = new SquarePattern(5,7);
        assertThat(squarePattern.getStartingCol(), is(5));
    }

    @Test
    public void testGetStartingRow() {
        this.squarePattern = new SquarePattern(5,7);
        assertThat(squarePattern.getStartingRow(), is(7));
    }
}
