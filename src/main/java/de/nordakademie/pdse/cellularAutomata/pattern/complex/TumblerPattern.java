package de.nordakademie.pdse.cellularAutomata.pattern.complex;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;

/**
 * The class <b>TumblerPattern</b> is used to apply the tumbler pattern out of living cells to a grid at given starting position
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class TumblerPattern extends ComplexPattern {
    public TumblerPattern(int startingCol, int startingRow) {
        super(startingCol, startingRow, 7, 6);
    }

    @Override
    public void applyOn(IGrid grid) {
        checkPatternFit(grid);

        for(int col = 0; col < grid.getGridConfiguration().getCols(); col++) {
            for(int row = 0; row < grid.getGridConfiguration().getRows(); row++) {
                grid.setState(col, row, State.DEAD);
            }
        }

        grid.setState(getStartingCol(), getStartingRow() + 3, State.ALIVE);
        grid.setState(getStartingCol(), getStartingRow() + 4, State.ALIVE);
        grid.setState(getStartingCol(), getStartingRow() + 5, State.ALIVE);
        grid.setState(getStartingCol() + 1, getStartingRow(), State.ALIVE);
        grid.setState(getStartingCol() + 1, getStartingRow() + 1, State.ALIVE);
        grid.setState(getStartingCol() + 1, getStartingRow() + 5, State.ALIVE);
        grid.setState(getStartingCol() + 2, getStartingRow(), State.ALIVE);
        grid.setState(getStartingCol() + 2, getStartingRow() + 1, State.ALIVE);
        grid.setState(getStartingCol() + 2, getStartingRow() + 2, State.ALIVE);
        grid.setState(getStartingCol() + 2, getStartingRow() + 3, State.ALIVE);
        grid.setState(getStartingCol() + 2, getStartingRow() + 4, State.ALIVE);
        grid.setState(getStartingCol() + 4, getStartingRow(), State.ALIVE);
        grid.setState(getStartingCol() + 4, getStartingRow() + 1, State.ALIVE);
        grid.setState(getStartingCol() + 4, getStartingRow() + 2, State.ALIVE);
        grid.setState(getStartingCol() + 4, getStartingRow() + 3, State.ALIVE);
        grid.setState(getStartingCol() + 4, getStartingRow() + 4, State.ALIVE);
        grid.setState(getStartingCol() + 5, getStartingRow(), State.ALIVE);
        grid.setState(getStartingCol() + 5, getStartingRow() + 1, State.ALIVE);
        grid.setState(getStartingCol() + 5, getStartingRow() + 5, State.ALIVE);
        grid.setState(getStartingCol() + 6, getStartingRow() + 3, State.ALIVE);
        grid.setState(getStartingCol() + 6, getStartingRow() + 4, State.ALIVE);
        grid.setState(getStartingCol() + 6, getStartingRow() + 5, State.ALIVE);
    }
}
