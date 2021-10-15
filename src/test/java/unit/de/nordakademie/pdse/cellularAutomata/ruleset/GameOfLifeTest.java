package unit.de.nordakademie.pdse.cellularAutomata.ruleset;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.ruleset.GameOfLife;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test class for the {@link GameOfLife}.
 *
 * @author 17015 (til.zoeller@nordakademie.de)
 * @author 16513 (merlin.ritsch@nordakademie.de)
 */

public class GameOfLifeTest {

    private GameOfLife gameOfLife;

    @Before
    public void beforeEach() {
        this.gameOfLife = new GameOfLife();
    }

    @Test
    public void getStateFromAliveCellWithoutAliveNeighbors() {
        assertThat(gameOfLife.getNextGenerationState(State.ALIVE, 0, 4), is(State.DEAD));
    }

    @Test
    public void getStateFromAliveCellWithOneAliveNeighbor() {
        assertThat(gameOfLife.getNextGenerationState(State.ALIVE, 1, 4), is(State.DEAD));
    }

    @Test
    public void getStateFromAliveCellWithTwoAliveNeighbors() {
        assertThat(gameOfLife.getNextGenerationState(State.ALIVE, 2, 4), is(State.ALIVE));
    }

    @Test
    public void getStateFromAliveCellWithThreeAliveNeighbors() {
        assertThat(gameOfLife.getNextGenerationState(State.ALIVE, 3, 4), is(State.ALIVE));
    }

    @Test
    public void getStateFromAliveCellWithFourAliveNeighbors() {
        assertThat(gameOfLife.getNextGenerationState(State.ALIVE, 4, 4), is(State.DEAD));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStateFromAliveCellWithToManyAliveNeighbors() {
        gameOfLife.getNextGenerationState(State.ALIVE, 5, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStateFromAliveCellWithNegativeAliveNeighbors() {
        gameOfLife.getNextGenerationState(State.ALIVE, -1, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStateFromAliveCellWithNegativeMaxNeighbors() {
        gameOfLife.getNextGenerationState(State.ALIVE, 0, -1);
    }

    @Test
    public void getStateFromDeadCellWithoutAliveNeighbors() {
        assertThat(gameOfLife.getNextGenerationState(State.DEAD, 0, 4), is(State.DEAD));
    }

    @Test
    public void getStateFromDeadCellWithOneAliveNeighbor() {
        assertThat(gameOfLife.getNextGenerationState(State.DEAD, 1, 4), is(State.DEAD));
    }

    @Test
    public void getStateFromDeadCellWithTwoAliveNeighbors() {
        assertThat(gameOfLife.getNextGenerationState(State.DEAD, 2, 4), is(State.DEAD));
    }

    @Test
    public void getStateFromDeadCellWithThreeAliveNeighbors() {
        assertThat(gameOfLife.getNextGenerationState(State.DEAD, 3, 4), is(State.ALIVE));
    }

    @Test
    public void getStateFromDeadCellWithFourAliveNeighbors() {
        assertThat(gameOfLife.getNextGenerationState(State.DEAD, 4, 4), is(State.DEAD));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStateFromDeadCellWithToManyAliveNeighbors() {
        gameOfLife.getNextGenerationState(State.DEAD, 5, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStateFromDeadCellWithNegativeAliveNeighbors() {
        gameOfLife.getNextGenerationState(State.DEAD, -1, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStateFromDeadCellWithNegativeMaxNeighbors() {
        gameOfLife.getNextGenerationState(State.DEAD, 0, -1);
    }



}
