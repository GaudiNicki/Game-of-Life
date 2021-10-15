package unit.de.nordakademie.pdse.cellularAutomata.grid;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.exceptions.InvalidCellException;
import de.nordakademie.pdse.cellularAutomata.grid.Grid2DArray;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.neighborhood.INeighborhood;
import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;
import de.nordakademie.pdse.cellularAutomata.ruleset.IRuleset;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link Grid2DArray}.
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 * @author 16455 (niklas.witzel@nordakademie.de)
 *
 */
public class Grid2DArrayTest {

	private Grid2DArray grid;

	private IRuleset gameOfLifeMock;
	private IRuleset parityMock;

	private INeighborhood neighborhoodMock;

	private IPattern startingPatternMock;

	@Before
	public void beforeEach() {
		initRulesetMocks();

		this.neighborhoodMock = mock(INeighborhood.class);
		this.startingPatternMock = mock(IPattern.class);
	}

	private void initRulesetMocks() {
		gameOfLifeMock = mock(IRuleset.class);
		when(gameOfLifeMock.getNextGenerationState(any(State.class), anyInt(), anyInt())).thenAnswer(invocationOnMock -> {
			State currentState = (State) invocationOnMock.getArguments()[0];
			int neighborsAlive = (int) invocationOnMock.getArguments()[1];
			int maxNeighbors = (int) invocationOnMock.getArguments()[2];

			if(maxNeighbors < 0) {
				throw new IllegalArgumentException("MaxNeighbors should be greater than or equal to 0 but is " + maxNeighbors + ".");
			}

			if(neighborsAlive < 0 || neighborsAlive > maxNeighbors) {
				throw new IllegalArgumentException("NeighborsAlive should be between 0 and " + maxNeighbors + " but was " + neighborsAlive + ".");
			}

			if(currentState == State.ALIVE) {
				if(neighborsAlive < 2 || neighborsAlive > 3) {
					return State.DEAD;
				}

				return State.ALIVE;
			}
			else {
				if(neighborsAlive == 3) {
					return State.ALIVE;
				}

				return State.DEAD;
			}
		});

		parityMock = mock(IRuleset.class);
		when(parityMock.getNextGenerationState(any(State.class), anyInt(), anyInt())).thenAnswer(invocationOnMock -> {
			int neighborsAlive = (int) invocationOnMock.getArguments()[1];
			int maxNeighbors = (int) invocationOnMock.getArguments()[2];

			if(maxNeighbors < 0) {
				throw new IllegalArgumentException("MaxNeighbors should be greater than or equal to 0 but is " + maxNeighbors + ".");
			}

			if(neighborsAlive < 0 || neighborsAlive > maxNeighbors) {
				throw new IllegalArgumentException("NeighborsAlive should be between 0 and " + maxNeighbors + " but was " + neighborsAlive + " .");
			}

			if (neighborsAlive % 2 == 0) {
				return State.DEAD;
			}

			return State.ALIVE;
		});
	}

	// region test constructor
	@Test
	public void testCreate1by1Grid() {
		this.grid = new Grid2DArray(1, 1, neighborhoodMock, startingPatternMock);

		assertThat(grid.getGrid().length, is(1));
		assertThat(grid.getGrid()[0].length, is(1));
	}

	@Test
	public void testCreate10by100Grid() {
		grid = new Grid2DArray(10, 100, neighborhoodMock, startingPatternMock);

		assertThat(grid.getGrid().length, is(10));
		assertThat(grid.getGrid()[0].length, is(100));
	}

	@Test
	public void testCreate9999by9999Grid() {
		grid = new Grid2DArray(9999, 9999, neighborhoodMock, startingPatternMock);

		assertThat(grid.getGrid().length, is(9999));
		assertThat(grid.getGrid()[0].length, is(9999));
	}
	// endregion

	// region test setState
	@Test
	public void testSetState() {
		grid = new Grid2DArray(10, 10, neighborhoodMock, startingPatternMock);
		grid.setState(4, 5, State.ALIVE);

		assertThat(grid.getState(4, 5), is(State.ALIVE));
	}

	@Test(expected = InvalidCellException.class)
	public void testSetStateAtNegativeCol() {
		Grid2DArray grid = new Grid2DArray(10, 10, neighborhoodMock, startingPatternMock);
		grid.setState(-1, 0, State.ALIVE);
	}

	@Test(expected = InvalidCellException.class)
	public void testSetStateAtNegativeRow() {
		Grid2DArray grid = new Grid2DArray(10, 10, neighborhoodMock, startingPatternMock);
		grid.setState(0, -1, State.ALIVE);
	}

	@Test(expected = InvalidCellException.class)
	public void testSetStateAtNegativeColAndRow() {
		Grid2DArray grid = new Grid2DArray(10, 10, neighborhoodMock, startingPatternMock);
		grid.setState(-1, -1, State.ALIVE);
	}
	// endregion

	// region test getState
	@Test
	public void testGetStateAt0And0() {
		grid = new Grid2DArray(10, 10, neighborhoodMock, startingPatternMock);
		grid.setState(0, 0, State.ALIVE);

		assertThat(grid.getState(0, 0), is(State.ALIVE));
	}

	@Test(expected = InvalidCellException.class)
	public void testGetStateAtNegativeCol() {
		grid = new Grid2DArray(10, 10, neighborhoodMock, startingPatternMock);
		grid.getState(-1, 0);
	}

	@Test(expected = InvalidCellException.class)
	public void testGetStateAtNegativeRow() {
		grid = new Grid2DArray(10, 10, neighborhoodMock, startingPatternMock);
		grid.getState(0, -1);
	}

	@Test(expected = InvalidCellException.class)
	public void testGetStateAtNegativeColAndRow() {
		grid = new Grid2DArray(10, 10, neighborhoodMock, startingPatternMock);
		grid.getState(-1, -1);
	}
	// endregion

	// region test equals
	@Test
	public void testEqualsForEqualGrids() {
		grid = new Grid2DArray(1, 1, neighborhoodMock, startingPatternMock);
		IGrid other = new Grid2DArray(1, 1, neighborhoodMock, startingPatternMock);

		assertThat(grid.equals(other), is(true));
	}

	@Test
	public void testEqualsForUnequalGrids() {
		grid = new Grid2DArray(1, 1, neighborhoodMock, startingPatternMock);
		IGrid other = new Grid2DArray(1, 1, neighborhoodMock, startingPatternMock);
		other.setState(0, 0, State.ALIVE);

		assertThat(grid.equals(other), is(false));
	}

	@Test
	public void testEqualsForUnequalGridCols() {
		grid = new Grid2DArray(1, 1, neighborhoodMock, startingPatternMock);
		IGrid other = new Grid2DArray(2, 1, neighborhoodMock, startingPatternMock);

		assertThat(grid.equals(other), is(false));
	}

	@Test
	public void testEqualsForUnequalGridRows() {
		grid = new Grid2DArray(1, 1, neighborhoodMock, startingPatternMock);
		IGrid other = new Grid2DArray(1, 2, neighborhoodMock, startingPatternMock);

		assertThat(grid.equals(other), is(false));
	}
	// endregion

	// region test evolveNextGeneration
	@Test
	public void testEvolveNextGenerationForPatternChessFieldRulesetGameOfLife() {
		grid = new Grid2DArray(2, 2, neighborhoodMock, startingPatternMock);
		grid.setState(0,0, State.DEAD);
		grid.setState(0,1, State.ALIVE);
		grid.setState(1,0, State.ALIVE);
		grid.setState(1,1, State.DEAD);

		IGrid other = new Grid2DArray(2, 2, neighborhoodMock, startingPatternMock);
		other.setState(0,0, State.DEAD);
		other.setState(0,1, State.DEAD);
		other.setState(1,0, State.DEAD);
		other.setState(1,1, State.DEAD);

		assertThat(grid.evolveNextGeneration(gameOfLifeMock).equals(other), is(true));
	}

	@Test
	public void testEvolveNextGenerationForPatternChessFieldRulesetParity() {
		grid = new Grid2DArray(2, 2, neighborhoodMock, startingPatternMock);
		grid.setState(0,0, State.DEAD);
		grid.setState(0,1, State.ALIVE);
		grid.setState(1,0, State.ALIVE);
		grid.setState(1,1, State.DEAD);

		IGrid other = new Grid2DArray(2, 2, neighborhoodMock, startingPatternMock);
		other.setState(0,0,State.DEAD);
		other.setState(0,1,State.DEAD);
		other.setState(1,0,State.DEAD);
		other.setState(1,1,State.DEAD);

		assertThat(grid.evolveNextGeneration(parityMock).equals(other), is(true));
	}
	// endregion

	// region test grid configuration
	@Test
	public void testGetGridConfiguration() {
		grid = new Grid2DArray(3,3, neighborhoodMock, startingPatternMock);
		assertThat(grid.getGridConfiguration(), isA(IGrid.IGridConfiguration.class));
	}

	@Test
	public void testGridConfigurationGetCols() {
		grid = new Grid2DArray(3,3, neighborhoodMock, startingPatternMock);
		assertThat(grid.getGridConfiguration().getCols(), is(3));
	}

	@Test
	public void testGridConfigurationGetRows() {
		grid = new Grid2DArray(3,3, neighborhoodMock, startingPatternMock);
		assertThat(grid.getGridConfiguration().getRows(), is(3));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGridConfigurationIndexOutOfBoundsExceptionCols() {
		grid = new Grid2DArray(0,3, neighborhoodMock, startingPatternMock);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGridConfigurationIndexOutOfBoundsExceptionRows() {
		grid = new Grid2DArray(3,0, neighborhoodMock, startingPatternMock);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGridConfigurationIndexOutOfBoundsExceptionRowsAndCols() {
		grid = new Grid2DArray(0,0, neighborhoodMock, startingPatternMock);
	}

	@Test
	public void testGridConfigurationGetNeighborhood() {
		grid = new Grid2DArray(2,2, neighborhoodMock, startingPatternMock);
		assertThat(grid.getGridConfiguration().getNeighborhood(), isA(INeighborhood.class));
	}

	@Test
	public  void testGridConfigurationGetStartingPattern() {
		grid = new Grid2DArray(2,2, neighborhoodMock, startingPatternMock);
		assertThat(grid.getGridConfiguration().getStartingPattern(), isA(IPattern.class));
	}
	// endregion
}