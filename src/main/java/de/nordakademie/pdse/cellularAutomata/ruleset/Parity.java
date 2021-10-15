package de.nordakademie.pdse.cellularAutomata.ruleset;

import de.nordakademie.pdse.cellularAutomata.enums.State;

/**
 * The class <b>Parity</b> represents the implementation of a {@link IRuleset} with rules of Parity Model.
 *
 * @author 17015 (til.zoeller@nordakademie.de)
 * @author 16513 (merlin.ritsch@nordakademie.de)
 */
public class Parity extends Ruleset {

    @Override
    public State getNextGenerationState(State currentState, int neighborsAlive, int maxNeighbors) {

        checkForIllegalInput(neighborsAlive, maxNeighbors);

        if (neighborsAlive % 2 == 0) {
            return State.DEAD;
        }

        return State.ALIVE;
    }
}
