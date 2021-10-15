package de.nordakademie.pdse.cellularAutomata.neighborhood;

import de.nordakademie.pdse.cellularAutomata.enums.Neighbor;

import java.util.Arrays;

/**
 * The class <b>Moore</b> is the implementation of the <i>Moore</i> neighborhood relationship
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public class Moore extends Neighborhood {
    public Moore() {
        super(Arrays.asList(Neighbor.TOP_LEFT, Neighbor.TOP, Neighbor.TOP_RIGHT, Neighbor.LEFT, Neighbor.RIGHT,
                Neighbor.BOTTOM_LEFT, Neighbor.BOTTOM, Neighbor.BOTTOM_RIGHT));
    }
}
