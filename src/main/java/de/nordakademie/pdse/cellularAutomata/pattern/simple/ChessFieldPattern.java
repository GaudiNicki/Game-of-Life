package de.nordakademie.pdse.cellularAutomata.pattern.simple;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;

/**
 * The class <b>ChessFieldPattern</b> is used to apply an chess field pattern of living and dead cells to the grid.
 * Even rows are alternately initialized with STATE.DEAD and STATE.ALIVE.
 * Odd rows are alternately initialized with STATE.ALIVE and STATE.DEAD.
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class ChessFieldPattern implements IPattern {
    @Override
    public void applyOn(IGrid grid) {
        for(int col = 0; col < grid.getGridConfiguration().getCols(); col++) {
            for(int row = 0; row < grid.getGridConfiguration().getRows(); row++) {
                if (row % 2 == 0) {
                    if (col % 2 == 0)
                        grid.setState(col, row, State.ALIVE);
                    else
                        grid.setState(col, row, State.DEAD);
                }
                else {
                    if (col % 2 == 0)
                        grid.setState(col, row, State.DEAD);
                    else
                        grid.setState(col, row, State.ALIVE);
                }
            }
        }
    }
}
