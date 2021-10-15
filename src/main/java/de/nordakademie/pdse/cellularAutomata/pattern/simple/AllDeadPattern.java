package de.nordakademie.pdse.cellularAutomata.pattern.simple;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;

/**
 * The class <b>AllDeadPattern</b> is used to set all cells of a grid to {@link State}.DEAD
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class AllDeadPattern implements IPattern {
    @Override
    public void applyOn(IGrid grid) {
        for(int col = 0; col < grid.getGridConfiguration().getCols(); col++) {
            for(int row = 0; row < grid.getGridConfiguration().getRows(); row++) {
                grid.setState(col, row, State.DEAD);
            }
        }
    }
}
