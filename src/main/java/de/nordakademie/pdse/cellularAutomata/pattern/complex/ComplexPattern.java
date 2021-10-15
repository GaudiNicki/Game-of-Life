package de.nordakademie.pdse.cellularAutomata.pattern.complex;

import de.nordakademie.pdse.cellularAutomata.exceptions.GridTooSmallException;
import de.nordakademie.pdse.cellularAutomata.exceptions.InvalidCellException;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;

/**
 * The abstract class <b>IComplexPattern</b> serves as abstraction for all complex patterns, which could be applied to a grid.
 *  A complex pattern has a defined size and starting position.
 *  This class can work with all different implementations of an {@link IGrid} interface.
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public abstract class ComplexPattern implements IComplexPattern {
    protected final int startingCol;
    protected final int startingRow;

    protected final int patternCols;
    protected final int patternRows;

    public ComplexPattern(int startingCol, int startingRow, int patternCols, int patternRows) {
        this.startingCol = startingCol;
        this.startingRow = startingRow;

        this.patternCols = patternCols;
        this.patternRows = patternRows;
    }

    protected void checkPatternFit(IGrid grid) {
        if (grid.invalidCell(startingCol, startingRow))
            throw new InvalidCellException(startingCol, startingRow);

        if (grid.getGridConfiguration().getCols() < (startingCol + patternCols)
                || grid.getGridConfiguration().getRows() < (startingRow + patternRows))
            throw new GridTooSmallException(this);
    }

    @Override
    public int getPatternCols() {
        return this.patternCols;
    }

    @Override
    public int getPatternRows() {
        return this.patternRows;
    }

    @Override
    public int getStartingCol() {
        return this.startingCol;
    }

    @Override
    public int getStartingRow() {
        return this.startingRow;
    }
}
