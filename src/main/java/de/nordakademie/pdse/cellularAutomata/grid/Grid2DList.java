package de.nordakademie.pdse.cellularAutomata.grid;

import java.util.ArrayList;
import java.util.List;

import de.nordakademie.pdse.cellularAutomata.enums.State;
import de.nordakademie.pdse.cellularAutomata.exceptions.InvalidCellException;
import de.nordakademie.pdse.cellularAutomata.neighborhood.INeighborhood;
import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;
import de.nordakademie.pdse.cellularAutomata.ruleset.IRuleset;

/**
 * The class <b>Grid2DList</b> represents the implementation of an {@link IGrid} with a two dimensional list as its data structure.
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 *
 */
public class Grid2DList extends Grid{

	private List<List<State>> grid;

	// copy constructor
	public Grid2DList(Grid2DList other) {
		super(other);
		initializeGrid();
	}

	public Grid2DList(final int cols, final int rows, final INeighborhood neighborhood, final IPattern startingPattern) {
		super(cols, rows, neighborhood, startingPattern);
		initializeGrid();
		this.gridConfiguration.getStartingPattern().applyOn(this);
	}

	private void initializeGrid() {
		this.grid = new ArrayList<>();

		for(int i = 0; i < this.gridConfiguration.getCols(); i++) {
			List<State> row = new ArrayList<>();

			for(int j = 0; j < this.gridConfiguration.getRows(); j++) {
				row.add(State.DEAD);
			}

			this.grid.add(row);
		}
	}

	@Override
	public State getState(int col, int row) {
		if(invalidCell(col, row)) {
			throw new InvalidCellException(col, row);
		}

		return grid.get(col).get(row);
	}

	@Override
	public void setState(int col, int row, State state) {
		if(invalidCell(col, row)) {
			throw new InvalidCellException(col, row);
		}

		this.grid.get(col).set(row, state);
	}

	@Override
	public IGrid evolveNextGeneration(IRuleset ruleset) {
		IGrid nextGeneration = new Grid2DList(this);

		return applyRules(ruleset, nextGeneration);
	}

	public List<List<State>> getGrid() {
		return this.grid;
	}

}
