package integration.de.nordakademie.pdse.cellularAutomata.grid;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.grid.Grid2DList;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.neighborhood.INeighborhood;
import de.nordakademie.pdse.cellularAutomata.neighborhood.Moore;
import de.nordakademie.pdse.cellularAutomata.neighborhood.VonNeumann;
import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;
import de.nordakademie.pdse.cellularAutomata.pattern.complex.SquarePattern;
import de.nordakademie.pdse.cellularAutomata.pattern.complex.TumblerPattern;
import de.nordakademie.pdse.cellularAutomata.pattern.simple.AllDeadPattern;
import de.nordakademie.pdse.cellularAutomata.pattern.simple.ChessFieldPattern;
import de.nordakademie.pdse.cellularAutomata.ruleset.GameOfLife;
import de.nordakademie.pdse.cellularAutomata.ruleset.IRuleset;
import de.nordakademie.pdse.cellularAutomata.ruleset.Parity;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Integration-test class for {@link Grid2DList}
 * to test the interaction with the classes of {@link IRuleset}, {@link INeighborhood} and {@link IPattern}
 *
 * @author 17015 (til.zoeller@nordakademie.de)
 */
public class Grid2DListIntegrationTest {

    private IRuleset gameOfLife;
    private IRuleset parity;

    private INeighborhood moore;
    private INeighborhood vonNeumann;

    private IPattern chessField;
    private IPattern allDead;
    private IPattern tumblerPattern;
    private IPattern squarePattern;

    @Before
    public void beforeEach() {
        this.gameOfLife = new GameOfLife();
        this.parity = new Parity();

        this.moore = new Moore();
        this.vonNeumann = new VonNeumann();

        this.chessField = new ChessFieldPattern();
        this.allDead = new AllDeadPattern();
        this.tumblerPattern = new TumblerPattern(0, 0);
        this.squarePattern = new SquarePattern(0, 0);
    }

    @Test
    public void testEvolveNextGenerationWithMooreNeighborhoodAndChessFieldPatternAndGameOfLifeRuleset() {
        IGrid grid = new Grid2DList(3, 3, this.moore, this.chessField);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(gameOfLife);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.DEAD));
    }

    @Test
    public void testEvolveNextGenerationWithMooreNeighborhoodAndChessFieldPatternAndParityRuleset() {
        IGrid grid = new Grid2DList(3, 3, this.moore, this.chessField);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(parity);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.ALIVE));
    }

    @Test
    public void testEvolveNextGenerationWithMooreNeighborhoodAndAllDeadPatternAndGameOfLifeRuleset() {
        IGrid grid = new Grid2DList(3, 3, this.moore, this.allDead);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(gameOfLife);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.DEAD));
    }

    @Test
    public void testEvolveNextGenerationWithMooreNeighborhoodAndAllDeadPatternAndParityRuleset() {
        IGrid grid = new Grid2DList(3, 3, this.moore, this.allDead);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(parity);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.DEAD));
    }

    @Test
    public void testEvolveNextGenerationWithMooreNeighborhoodAndTumblerPatternAndGameOfLifeRuleset() {
        IGrid grid = new Grid2DList(7, 6, this.moore, this.tumblerPattern);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(gameOfLife);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 5), is(State.ALIVE));

        assertThat(nextGenerationGrid.getState(1, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 5), is(State.ALIVE));

        assertThat(nextGenerationGrid.getState(2, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 3), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(3, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(4, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(4, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(4, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(4, 3), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(4, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(4, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(5, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(5, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(5, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(5, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(5, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(5, 5), is(State.ALIVE));

        assertThat(nextGenerationGrid.getState(6, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(6, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(6, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(6, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(6, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(6, 5), is(State.ALIVE));
    }

    @Test
    public void testEvolveNextGenerationWithMooreNeighborhoodAndTumblerPatternAndParityRuleset() {
        IGrid grid = new Grid2DList(7, 6, this.moore, this.tumblerPattern);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(parity);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 3), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(1, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 3), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 5), is(State.ALIVE));

        assertThat(nextGenerationGrid.getState(2, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(3, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(4, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(4, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(4, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(4, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(4, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(4, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(5, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(5, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(5, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(5, 3), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(5, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(5, 5), is(State.ALIVE));

        assertThat(nextGenerationGrid.getState(6, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(6, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(6, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(6, 3), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(6, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(6, 5), is(State.DEAD));
    }

    @Test
    public void testEvolveNextGenerationWithMooreNeighborhoodAnSquarePatternAndGameOfLifeRuleset() {
        IGrid grid = new Grid2DList(3, 3, this.moore, this.squarePattern);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(gameOfLife);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.DEAD));
    }

    @Test
    public void testEvolveNextGenerationWithMooreNeighborhoodAnSquarePatternAndParityRuleset() {
        IGrid grid = new Grid2DList(3, 3, this.moore, this.squarePattern);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(parity);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.ALIVE));
    }

    @Test
    public void testEvolveNextGenerationWithVonNeumannNeighborhoodAndChessFieldPatternAndGameOfLifeRuleset() {
        IGrid grid = new Grid2DList(3, 3, this.vonNeumann, this.chessField);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(gameOfLife);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.DEAD));
    }

    @Test
    public void testEvolveNextGenerationWithVonNeumannNeighborhoodAndChessFieldPatternAndParityRuleset() {
        IGrid grid = new Grid2DList(3, 3, this.vonNeumann, this.chessField);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(parity);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.DEAD));
    }

    @Test
    public void testEvolveNextGenerationWithVonNeumannNeighborhoodAndAllDeadPatternAndGameOfLifeRuleset() {
        IGrid grid = new Grid2DList(3, 3, this.vonNeumann, this.allDead);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(gameOfLife);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.DEAD));
    }

    @Test
    public void testEvolveNextGenerationWithVonNeumannNeighborhoodAndAllDeadPatternAndParityRuleset() {
        IGrid grid = new Grid2DList(3, 3, this.vonNeumann, this.allDead);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(parity);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.DEAD));
    }

    @Test
    public void testEvolveNextGenerationWithVonNeumannNeighborhoodAndTumblerPatternAndGameOfLifeRuleset() {
        IGrid grid = new Grid2DList(7, 6, this.vonNeumann, this.tumblerPattern);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(gameOfLife);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 5), is(State.ALIVE));

        assertThat(nextGenerationGrid.getState(1, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(2, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 3), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(3, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(4, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(4, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(4, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(4, 3), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(4, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(4, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(5, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(5, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(5, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(5, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(5, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(5, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(6, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(6, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(6, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(6, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(6, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(6, 5), is(State.ALIVE));
    }

    @Test
    public void testEvolveNextGenerationWithVonNeumannNeighborhoodAndTumblerPatternAndParityRuleset() {
        IGrid grid = new Grid2DList(7, 6, this.vonNeumann, this.tumblerPattern);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(parity);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 3), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(1, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 5), is(State.ALIVE));

        assertThat(nextGenerationGrid.getState(2, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(3, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(3, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(4, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(4, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(4, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(4, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(4, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(4, 5), is(State.DEAD));

        assertThat(nextGenerationGrid.getState(5, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(5, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(5, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(5, 3), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(5, 4), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(5, 5), is(State.ALIVE));

        assertThat(nextGenerationGrid.getState(6, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(6, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(6, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(6, 3), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(6, 4), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(6, 5), is(State.DEAD));
    }

    @Test
    public void testEvolveNextGenerationWithVonNeumannNeighborhoodAnSquarePatternAndGameOfLifeRuleset() {
        IGrid grid = new Grid2DList(3, 3, this.vonNeumann, this.squarePattern);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(gameOfLife);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.DEAD));
    }

    @Test
    public void testEvolveNextGenerationWithVonNeumannNeighborhoodAnSquarePatternAndParityRuleset() {
        IGrid grid = new Grid2DList(3, 3, this.vonNeumann, this.squarePattern);

        IGrid nextGenerationGrid = grid.evolveNextGeneration(parity);

        assertThat(nextGenerationGrid.getState(0, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(0, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(1, 0), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 1), is(State.DEAD));
        assertThat(nextGenerationGrid.getState(1, 2), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 0), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 1), is(State.ALIVE));
        assertThat(nextGenerationGrid.getState(2, 2), is(State.DEAD));
    }
}
