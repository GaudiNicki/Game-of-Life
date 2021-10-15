package de.nordakademie.pdse.cellularAutomata.enums;

/**
 * The <b>Neighbor</b> enum holds all possible neighbors of a cell in a two-dimensional grid
 * as well as the correspondent column and row offset
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public enum Neighbor {
    TOP_LEFT(-1,-1),
    TOP(0, -1),
    TOP_RIGHT(1,-1),
    LEFT(-1,0),
    RIGHT(1,0),
    BOTTOM_LEFT(-1,1),
    BOTTOM(0,1),
    BOTTOM_RIGHT(1,1);

    private final int colOffset;
    private final int rowOffset;

    Neighbor(Integer colOffset, Integer rowOffset) {
        this.colOffset = colOffset;
        this.rowOffset = rowOffset;
    }

    public int getColOffset() {
        return colOffset;
    }

    public int getRowOffset() {
        return rowOffset;
    }
}
