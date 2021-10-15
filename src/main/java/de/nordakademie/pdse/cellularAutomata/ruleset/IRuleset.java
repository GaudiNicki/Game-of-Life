package de.nordakademie.pdse.cellularAutomata.ruleset;

import de.nordakademie.pdse.cellularAutomata.enums.State;

/**
 * The <b>IRuleset</b> interface serves as abstraction for all rulesets.
 * It can work with various grids.
 *
 * @author 17015 (til.zoeller@nordakademie.de)
 * @author 16513 (merlin.ritsch@nordakademie.de)
 */
public interface IRuleset {
    /**
     * This method is used to get the {@link State} of a cell for the next generation.
     *
     * @param currentState State of a cell from this generation
     * @param neighborsAlive amount of living neighbors of a cell from this generation
     * @param maxNeighbors maximal allowed neighbors of a cell due to neighborhood relationship
     * @return State of the cell for next generation
     */
    State getNextGenerationState(State currentState, int neighborsAlive, int maxNeighbors);
}
