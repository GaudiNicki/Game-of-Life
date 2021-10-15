package de.nordakademie.pdse.cellularAutomata.neighborhood;

import de.nordakademie.pdse.cellularAutomata.enums.Neighbor;

import java.util.Arrays;

/**
 * The class <b>VonNeumann</b> is the implementation of the <i>Von Neumann</i> neighborhood relationship
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class VonNeumann extends Neighborhood {
    public VonNeumann() {
        super(Arrays.asList(Neighbor.TOP, Neighbor.LEFT, Neighbor.RIGHT, Neighbor.BOTTOM));
    }
}
