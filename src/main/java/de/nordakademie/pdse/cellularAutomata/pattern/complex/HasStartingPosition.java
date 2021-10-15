package de.nordakademie.pdse.cellularAutomata.pattern.complex;

import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;

/**
 * The <b>HasStartingPosition</b> interface serves as abstraction for all {@link IPattern}s,
 * which have a starting position
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public interface HasStartingPosition {
    /**
     * This method is used to get the pattern's starting column
     *
     * @return the pattern's starting column
     */
    int getStartingCol();

    /**
     * This method is used to get the pattern's starting row
     *
     * @return the pattern's starting row
     */
    int getStartingRow();
}
