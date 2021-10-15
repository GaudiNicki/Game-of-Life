package de.nordakademie.pdse.cellularAutomata.pattern.complex;

import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;

/**
 * The <b>HasSize</b> interface serves as abstraction for all {@link IPattern}s, which have a size
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public interface HasSize {
    /**
     * This method is used to get the pattern's columns
     *
     * @return the pattern's columns
     */
    int getPatternCols();

    /**
     * This method is used to get the pattern's rows
     *
     * @return the pattern's rows
     */
    int getPatternRows();
}
