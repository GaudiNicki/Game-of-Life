package de.nordakademie.pdse.cellularAutomata.neighborhood;

import de.nordakademie.pdse.cellularAutomata.enums.Neighbor;
import de.nordakademie.pdse.cellularAutomata.exceptions.InvalidCellException;
import de.nordakademie.pdse.cellularAutomata.grid.IGrid;

import java.util.List;

/**
 * The class <b>Neighborhood</b> serves as abstraction for all types of neighborhood relationships.
 * It can handle all different implementations of an {@link IGrid} interface as well as various data structures.
 * The class holds a list of {@link Neighbor}s, which are the way to define different neighborhood relationships.
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class Neighborhood implements INeighborhood {

    protected final List<Neighbor> neighbors;

    // copy constructor
    public Neighborhood(INeighborhood other) {
        this.neighbors = other.getNeighbors();
    }

    public Neighborhood(List<Neighbor> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public int countNeighborsAlive(int col, int row, IGrid grid) {
        if (grid.invalidCell(col, row))
            throw new InvalidCellException(col, row);

        int sum = 0;

        for(Neighbor neighbor : neighbors) {
            int neighborCol = col + neighbor.getColOffset();
            int neighborRow = row + neighbor.getRowOffset();

            if(grid.invalidCell(neighborCol, neighborRow))
                continue;

            sum += grid.getState(neighborCol, neighborRow).getStateRepresentation();
        }

        return sum;
    }

    @Override
    public List<Neighbor> getNeighbors() {
        return this.neighbors;
    }
}
