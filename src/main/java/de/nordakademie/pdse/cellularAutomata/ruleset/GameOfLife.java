package de.nordakademie.pdse.cellularAutomata.ruleset;

import de.nordakademie.pdse.cellularAutomata.enums.State;

/**
 * The class <b>GameOfLife</b> represents the implementation of a {@link IRuleset} with rules of GameOfLife
 *
 * @author 17015 (til.zoeller@nordakademie.de)
 * @author 16513 (merlin.ritsch@nordakademie.de)
 */
public class GameOfLife extends Ruleset {

    @Override
    public State getNextGenerationState(State currentState, int neighborsAlive, int maxNeighbors) {

        checkForIllegalInput(neighborsAlive, maxNeighbors);

        if(currentState == State.ALIVE) {
            if(neighborsAlive < 2 || neighborsAlive > 3) {
                return State.DEAD;
            }

            return State.ALIVE;
        }
        else {
            if(neighborsAlive == 3) {
                return State.ALIVE;
            }

            return State.DEAD;
        }
    }
}
