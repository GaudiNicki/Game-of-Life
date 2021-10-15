package de.nordakademie.pdse.cellularAutomata.enums;

/**
 * The <b>State</b> enum holds all possible states of a grid cell as well as its numeric representation
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 */
public enum State {
    DEAD(0), ALIVE(1);

    private final int stateRepresentation;

    State(int stateRepresentation) {
        this.stateRepresentation = stateRepresentation;
    }

    public int getStateRepresentation() {
        return stateRepresentation;
    }
}
