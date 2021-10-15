package de.nordakademie.pdse.cellularAutomata.grid;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.neighborhood.INeighborhood;
import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;
import de.nordakademie.pdse.cellularAutomata.ruleset.IRuleset;

/**
 * The <b>IGrid</b> interface serves as abstraction for all types of grids.
 * It can work with various data structures.
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 */
public interface IGrid {
	/**
	 * This method is used to check if col and row are invalid identifiers of a cell within the grid
	 *
	 * @param col the column which should be checked
	 * @param row the row which should be checked
	 * @return true, if col and rows are invalid identifiers and else false
	 */
	boolean invalidCell(int col, int row);

	/**
	 * This method is used to access the grid's configuration from outside
	 *
	 * @return the grid's configuration
	 */
	IGridConfiguration getGridConfiguration();

	/**
	 * This method is used to compare this grid with another grid. The methods evaluates to true if each cell of this grid
	 * has the same state as in the other grid
	 *
	 * @param other other grid to compare
	 * @return true if other grid is equal to this grid, else false
	 */
	boolean equals(IGrid other);

	/**
	 * This method is used to find out which {@link State} a cell in the {@link Grid} has
	 *
	 * @param col the column of the cell of which the state should be obtained
	 * @param row the row of the cell of which the state should be obtained
	 * @return the {@link State} of the cell
	 */
	State getState(int col, int row);

	/**
	 * This method is used to set the {@link State} of a cell
	 * @param col the column of the cell of which the {@link State} should be set
	 * @param row the row of the cell of which the {@link State} should be set
	 * @param state the new {@link State} to set
	 */
	void setState(int col, int row, State state);

	/**
	 * This method is used to evolve the next generation of this grid with the given ruleset
	 *
	 * @param ruleset the ruleset which is used to determine the state of the cells in the next generation
	 * @return the next generation grid
	 */
	IGrid evolveNextGeneration(IRuleset ruleset);

	/**
	 * The <b>IGridConfiguration</b> inner interface serves as abstraction for a configuration of a grid.
	 *
	 * @author 17015 (til.zoeller@nordakademie.de)
	 * @author 16513 (merlin.ritsch@nordakademie.de)
	 */
	interface IGridConfiguration {
		/**
		 * This method is used to get the defined columns amount.
		 *
		 * @return the amount of columns
		 */
		int getCols();

		/**
		 * This method is used to get the defined rows amount.
		 *
		 * @return the amount of rows
		 */
		int getRows();

		/**
		 * This method is used to get the defined neighborhood type.
		 *
		 * @return the neighborhood type
		 */
		INeighborhood getNeighborhood();

		/**
		 * This method is used to get the grid configurations starting pattern from outside
		 *
		 * @return the starting pattern
		 */
		IPattern getStartingPattern();
	}
}
