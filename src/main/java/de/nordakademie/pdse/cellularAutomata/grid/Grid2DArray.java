package de.nordakademie.pdse.cellularAutomata.grid;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.exceptions.InvalidCellException;
import de.nordakademie.pdse.cellularAutomata.neighborhood.INeighborhood;
import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;
import de.nordakademie.pdse.cellularAutomata.ruleset.IRuleset;

/**
 * The class <b>Grid2DArray</b> represents the implementation of an {@link IGrid} with a two dimensional array as its data structure.
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 *
 */
public class Grid2DArray extends Grid {

	private final State[][] grid;

	// copy constructor
	public Grid2DArray(Grid2DArray other) {
		super(other);
		this.grid = new State[other.getGridConfiguration().getCols()][other.getGridConfiguration().getRows()];
	}

	public Grid2DArray(final int cols, final int rows, final INeighborhood neighborhood, final IPattern startingPattern) {
		super(cols, rows, neighborhood, startingPattern);
		this.grid = new State[cols][rows];
		this.gridConfiguration.getStartingPattern().applyOn(this);
	}

	@Override
	public State getState(int col, int row) {
		if(invalidCell(col, row)) {
			throw new InvalidCellException(col, row);
		}
		
		return grid[col][row];
	}
	
	@Override
	public void setState(int col, int row, State state) {
		if(invalidCell(col, row)) {
			throw new InvalidCellException(col, row);
		}
		
		grid[col][row] = state;
	}

	@Override
	public IGrid evolveNextGeneration(IRuleset ruleset) {
		IGrid nextGeneration = new Grid2DArray(this);

		return applyRules(ruleset, nextGeneration);
	}

	public State[][] getGrid() {
		return this.grid;
	}


}
