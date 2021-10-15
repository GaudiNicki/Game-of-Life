package de.nordakademie.pdse.cellularAutomata.ruleset;

/**
 * The abstract class <b>Ruleset</b> serves as abstraction for all types of Rulesets. It holds redundant methods.
 *
 * @author 16513 (merlin.ritsch@nordakademie.de)
 */

public abstract class Ruleset implements IRuleset {
    protected void checkForIllegalInput(int neighborsAlive, int maxNeighbors) {
        if(maxNeighbors < 0) {
            throw new IllegalArgumentException("MaxNeighbors should be greater than or equal to 0 but is " + maxNeighbors + ".");
        }

        if(neighborsAlive < 0 || neighborsAlive > maxNeighbors) {
            throw new IllegalArgumentException("NeighborsAlive should be between 0 and " + maxNeighbors + " but was " + neighborsAlive + ".");
        }
    }
}
