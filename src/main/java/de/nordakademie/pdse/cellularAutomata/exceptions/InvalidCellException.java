package de.nordakademie.pdse.cellularAutomata.exceptions;

/**
 * The exception <b>InvalidCellException</b> is thrown, if a cell is invalid.
 * For context information we also store the column and row of the invalid cell.
 * 
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 *
 */
public class InvalidCellException extends RuntimeException {
	public InvalidCellException(int col, int row) {
		super("Invalid cell with following coordinates: " + col + ", " + row);
	}
}
