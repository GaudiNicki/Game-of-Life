package de.nordakademie.pdse.cellularAutomata.exceptions;

import de.nordakademie.pdse.cellularAutomata.pattern.complex.IComplexPattern;

/**
 * The exception <b>GridTooSmallException</b> is thrown, if a grid is too small for applying a {@link IComplexPattern}
 * to it at a desired starting column and row
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class GridTooSmallException extends RuntimeException{
    public GridTooSmallException(IComplexPattern pattern) {
        super("Grid is too small. " +
                "Tried to insert pattern " + pattern + " into grid at " +
                "col " + pattern.getStartingCol() + " and " +
                "row " + pattern.getStartingRow() + ". " +
                "Grid must be at least " +
                (pattern.getStartingCol() + pattern.getPatternCols()) + " cols wide and " +
                (pattern.getStartingRow() + pattern.getPatternRows()) + " rows high.");
    }
}
