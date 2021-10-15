package unit.de.nordakademie.pdse.cellularAutomata.neighborhood;

import de.nordakademie.pdse.cellularAutomata.enums.Neighbor;
import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.exceptions.InvalidCellException;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.neighborhood.INeighborhood;
import de.nordakademie.pdse.cellularAutomata.neighborhood.VonNeumann;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link VonNeumann}
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class VonNeumannTest {

    private INeighborhood vonNeumannNeighborhood;
    private IGrid gridMock;

    @Before
    public void beforeEach() {
        this.vonNeumannNeighborhood = new VonNeumann();
        this.gridMock = mock(IGrid.class);
    }

    @Test(expected = InvalidCellException.class)
    public void testCountNeighborsAliveWithInvalidCell() {
        when(gridMock.invalidCell(-1, -1)).thenReturn(true);

        vonNeumannNeighborhood.countNeighborsAlive(-1,-1, gridMock);
    }

    @Test
    public void testCountNeighborsAliveWithZeroNeighborsAlive() {
        when(gridMock.invalidCell(anyInt(), anyInt())).thenReturn(false);
        when(gridMock.getState(anyInt(), anyInt())).thenReturn(State.DEAD);

        assertThat(vonNeumannNeighborhood.countNeighborsAlive(1,1, gridMock), is(0));
    }

    @Test
    public void testCountNeighborsAliveWithFiveNeighborsAlive() {
        when(gridMock.invalidCell(anyInt(), anyInt())).thenReturn(false);

        when(gridMock.getState(anyInt(), anyInt())).thenReturn(State.DEAD);
        when(gridMock.getState(0,0)).thenReturn(State.ALIVE);
        when(gridMock.getState(0,1)).thenReturn(State.ALIVE);
        when(gridMock.getState(1,1)).thenReturn(State.ALIVE);
        when(gridMock.getState(1,2)).thenReturn(State.ALIVE);
        when(gridMock.getState(2,0)).thenReturn(State.ALIVE);
        when(gridMock.getState(2,1)).thenReturn(State.ALIVE);

        assertThat(vonNeumannNeighborhood.countNeighborsAlive(1,1, gridMock), is(3));
    }

    @Test
    public void testCountNeighborsAliveWithSideCell() {
        when(gridMock.invalidCell(anyInt(), anyInt())).thenReturn(false);
        when(gridMock.invalidCell(1,-1)).thenReturn(true);

        when(gridMock.getState(anyInt(), anyInt())).thenReturn(State.DEAD);
        when(gridMock.getState(0,0)).thenReturn(State.ALIVE);
        when(gridMock.getState(0,1)).thenReturn(State.ALIVE);
        when(gridMock.getState(0,2)).thenReturn(State.ALIVE);
        when(gridMock.getState(1,0)).thenReturn(State.ALIVE);
        when(gridMock.getState(1,1)).thenReturn(State.ALIVE);
        when(gridMock.getState(1,2)).thenReturn(State.ALIVE);
        when(gridMock.getState(2,0)).thenReturn(State.ALIVE);
        when(gridMock.getState(2,1)).thenReturn(State.ALIVE);
        when(gridMock.getState(2,2)).thenReturn(State.ALIVE);

        assertThat(vonNeumannNeighborhood.countNeighborsAlive(1,0, gridMock), is(3));
    }

    @Test
    public void testCountNeighborsAliveWithCornerCell() {
        when(gridMock.invalidCell(anyInt(), anyInt())).thenReturn(false);
        when(gridMock.invalidCell(0,-1)).thenReturn(true);
        when(gridMock.invalidCell(-1,0)).thenReturn(true);

        when(gridMock.getState(anyInt(), anyInt())).thenReturn(State.DEAD);
        when(gridMock.getState(0,0)).thenReturn(State.ALIVE);
        when(gridMock.getState(0,1)).thenReturn(State.ALIVE);
        when(gridMock.getState(0,2)).thenReturn(State.ALIVE);
        when(gridMock.getState(1,0)).thenReturn(State.ALIVE);
        when(gridMock.getState(1,1)).thenReturn(State.ALIVE);
        when(gridMock.getState(1,2)).thenReturn(State.ALIVE);
        when(gridMock.getState(2,0)).thenReturn(State.ALIVE);
        when(gridMock.getState(2,1)).thenReturn(State.ALIVE);
        when(gridMock.getState(2,2)).thenReturn(State.ALIVE);

        assertThat(vonNeumannNeighborhood.countNeighborsAlive(0,0, gridMock), is(2));
    }

    @Test
    public void testGetNeighbors() {
        List<Neighbor> neighbors = Arrays.asList(Neighbor.TOP, Neighbor.LEFT, Neighbor.RIGHT, Neighbor.BOTTOM);

        assertThat(vonNeumannNeighborhood.getNeighbors().size(), is(4));
        assertThat(vonNeumannNeighborhood.getNeighbors(), is(neighbors));
    }
}
