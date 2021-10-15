package de.nordakademie.pdse.cellularAutomata.neighborhood;

import de.nordakademie.pdse.cellularAutomata.enums.Neighbor;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;

import java.util.List;

/**
 * The <b>INeighborhood</b> interface serves as abstraction for all types of neighborhood relationships.
 * It can work with all different implementations of an {@link IGrid} interface.
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public interface INeighborhood {
    /**
     * This method is used to count the live neighbors of a cell
     *
     * @param col the column of the cell of which the live neighbors should be counted
     * @param row the row of the cell of which the live neighbors should be counted
     * @return the count of live neighbors
     */
    int countNeighborsAlive(int col, int row, IGrid grid);

    /**
     * This method is used to get the list of neighbors from outside
     *
     * @return the list of neighbors
     */
    List<Neighbor> getNeighbors();
}
