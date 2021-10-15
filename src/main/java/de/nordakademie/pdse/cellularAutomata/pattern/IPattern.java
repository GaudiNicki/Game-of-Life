package de.nordakademie.pdse.cellularAutomata.pattern;

import de.nordakademie.pdse.cellularAutomata.grid.IGrid;

/**
 * The interface <b>IPattern</b> serves as abstraction for all patterns, which could be applied to a grid.
 * The class can work with all different implementations of an {@link IGrid} interface.
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public interface IPattern {
    /**
     * This method is used to apply this pattern on this grid
     *
     * @param grid the grid the pattern should be applied on
     */
    void applyOn(IGrid grid);
}
