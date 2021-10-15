package de.nordakademie.pdse.cellularAutomata.pattern.complex;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;

/**
 * The class <b>SquarePattern</b> is used to apply a 2x2 square of living cells to the grid at given starting position
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class SquarePattern extends ComplexPattern {
    public SquarePattern(int startingCol, int startingRow) {
        super(startingCol, startingRow, 2, 2);
    }

    @Override
    public void applyOn(IGrid grid) {
        checkPatternFit(grid);

        for(int col = 0; col < grid.getGridConfiguration().getCols(); col++) {
            for(int row = 0; row < grid.getGridConfiguration().getRows(); row++) {
                grid.setState(col, row, State.DEAD);
            }
        }

        grid.setState(startingCol, startingRow, State.ALIVE);
        grid.setState(startingCol + 1, startingRow, State.ALIVE);
        grid.setState(startingCol, startingRow + 1, State.ALIVE);
        grid.setState(startingCol + 1, startingRow + 1, State.ALIVE);
    }
}
