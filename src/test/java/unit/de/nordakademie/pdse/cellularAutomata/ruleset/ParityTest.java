package unit.de.nordakademie.pdse.cellularAutomata.ruleset;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.ruleset.Parity;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test class for the {@link Parity}.
 *
 * @author 17015 (til.zoeller@nordakademie.de)
 * @author 16513 (merlin.ritsch@nordakademie.de)
 */

public class ParityTest {

    private Parity parity;

    @Before
    public void beforeEach() {
        this.parity = new Parity();
    }

    @Test
    public void getStateFromAliveCellWithoutAliveNeighbors() {
        assertThat(parity.getNextGenerationState(State.ALIVE, 0, 4), is(State.DEAD));
    }

    @Test
    public void getStateFromAliveCellWithOneAliveNeighbor() {
        assertThat(parity.getNextGenerationState(State.ALIVE, 1, 4), is(State.ALIVE));
    }

    @Test
    public void getStateFromAliveCellWithTwoAliveNeighbors() {
        assertThat(parity.getNextGenerationState(State.ALIVE, 2, 4), is(State.DEAD));
    }

    @Test
    public void getStateFromAliveCellWithThreeAliveNeighbors() {
        assertThat(parity.getNextGenerationState(State.ALIVE, 3, 4), is(State.ALIVE));
    }

    @Test
    public void getStateFromAliveCellWithFourAliveNeighbors() {
        assertThat(parity.getNextGenerationState(State.ALIVE, 4, 4), is(State.DEAD));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStateFromAliveCellWithToManyAliveNeighbors() {
        parity.getNextGenerationState(State.ALIVE, 5, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStateFromAliveCellWithNegativeAliveNeighbors() {
        parity.getNextGenerationState(State.ALIVE, -1, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStateFromAliveCellWithNegativeMaxNeighbors() {
        parity.getNextGenerationState(State.ALIVE, 0, -1);
    }

    @Test
    public void getStateFromDeadCellWithoutAliveNeighbors() {
        assertThat(parity.getNextGenerationState(State.DEAD, 0, 4), is(State.DEAD));
    }

    @Test
    public void getStateFromDeadCellWithOneAliveNeighbor() {
        assertThat(parity.getNextGenerationState(State.DEAD, 1, 4), is(State.ALIVE));
    }

    @Test
    public void getStateFromDeadCellWithTwoAliveNeighbors() {
        assertThat(parity.getNextGenerationState(State.DEAD, 2, 4), is(State.DEAD));
    }

    @Test
    public void getStateFromDeadCellWithThreeAliveNeighbors() {
        assertThat(parity.getNextGenerationState(State.DEAD, 3, 4), is(State.ALIVE));
    }

    @Test
    public void getStateFromDeadCellWithFourAliveNeighbors() {
        assertThat(parity.getNextGenerationState(State.DEAD, 4, 4), is(State.DEAD));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStateFromDeadCellWithToManyAliveNeighbors() {
        parity.getNextGenerationState(State.DEAD, 5, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStateFromDeadCellWithNegativeAliveNeighbors() {
        parity.getNextGenerationState(State.DEAD, -1, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStateFromDeadCellWithNegativeMaxNeighbors() {
        parity.getNextGenerationState(State.DEAD, 0, -1);
    }

}
