package de.nordakademie.pdse.cellularAutomata.grid;

import de.nordakademie.pdse.cellularAutomata.neighborhood.INeighborhood;
import de.nordakademie.pdse.cellularAutomata.neighborhood.Neighborhood;
import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;
import de.nordakademie.pdse.cellularAutomata.ruleset.IRuleset;

/**
 * The abstract class <b>Grid</b> serves as abstraction for all types of grids. It can handle various data structures.
 * The class holds the grid-configuration, which therefore holds the columns, rows, neighborhood relationship and
 * starting pattern.
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 */
public abstract class Grid implements IGrid {

	protected final IGridConfiguration gridConfiguration;

	// copy constructor
	public Grid(Grid other) {
		this.gridConfiguration = new GridConfiguration(other.getGridConfiguration());
	}

	public Grid(final int cols, final int rows, final INeighborhood neighborhood, final IPattern startingPattern) {
		this.gridConfiguration = new GridConfiguration(rows, cols, neighborhood, startingPattern);
	}

	@Override
	public boolean invalidCell(int col, int row) {
		return !(col >= 0
				&& col < this.gridConfiguration.getCols()
				&& row >= 0
				&& row < this.gridConfiguration.getRows());
	}

	@Override
	public IGridConfiguration getGridConfiguration() {
		return this.gridConfiguration;
	}

	@Override
	public boolean equals(IGrid other) {
		if(this.gridConfiguration.getCols() != other.getGridConfiguration().getCols())
			return false;

		if(this.gridConfiguration.getRows() != other.getGridConfiguration().getRows())
			return false;

		for(int col = 0; col < this.gridConfiguration.getCols(); col++) {
			for(int row = 0; row < this.gridConfiguration.getRows(); row++) {
				if(this.getState(col, row) != other.getState(col, row)) {
					return false;
				}
			}
		}

		return true;
	}

	// This method is a helper method for evolveNextGeneration() function. You can look for documentation there
	protected IGrid applyRules(IRuleset ruleset, IGrid nextGeneration) {
		for(int col = 0; col < this.gridConfiguration.getCols(); col++) {
			for(int row = 0; row < this.gridConfiguration.getRows(); row++) {
				nextGeneration.setState(col, row, ruleset.getNextGenerationState(
						this.getState(col, row),
						this.getGridConfiguration().getNeighborhood().countNeighborsAlive(col, row, this),
						this.getGridConfiguration().getNeighborhood().getNeighbors().size()));
			}
		}

		return nextGeneration;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (int row = 0; row < this.gridConfiguration.getRows(); row++) {
			for (int col = 0; col < this.gridConfiguration.getCols(); col++) {
				builder.append(getState(col, row).getStateRepresentation());
			}
			builder.append("\n");
		}

		return builder.toString();
	}

	/**
	 *
	 * The inner class <b>GridConfiguration</b> serves as encapsulation of the grid's configuration.
	 * This class holds the number of columns and row of the grid, the desired neighborhood relationship
	 * as well as the starting pattern for the grid.
	 *
	 * @author 17015 (til.zoeller@nordakademie.de)
	 * @author 16513 (merlin.ritsch@nordakademie.de)
	 */
	protected class GridConfiguration implements IGridConfiguration {

		protected int cols;
		protected int rows;

		protected INeighborhood neighborhood;
		protected IPattern startingPattern;

		// copy constructor
		protected GridConfiguration(IGridConfiguration other) {
			this.cols = other.getCols();
			this.rows = other.getRows();

			this.neighborhood = new Neighborhood(other.getNeighborhood());
			this.startingPattern = other.getStartingPattern();
		}

		protected GridConfiguration(int rows, int cols, INeighborhood neighborhood, IPattern startingPattern) {
			if (rows < 1 || cols < 1)
				throw new IndexOutOfBoundsException("Rows: " + rows + ", Cols: " + cols);

			this.rows = rows;
			this.cols = cols;

			this.neighborhood = new Neighborhood(neighborhood.getNeighbors());
			this.startingPattern = startingPattern;
		}

		@Override
		public int getCols() {
			return this.cols;
		}

		@Override
		public int getRows() {
			return this.rows;
		}

		@Override
		public INeighborhood getNeighborhood() {
			return this.neighborhood;
		}

		@Override
		public IPattern getStartingPattern() {
			return startingPattern;
		}
	}
}
