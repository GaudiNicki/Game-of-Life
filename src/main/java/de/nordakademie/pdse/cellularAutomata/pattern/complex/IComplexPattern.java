package de.nordakademie.pdse.cellularAutomata.pattern.complex;

import de.nordakademie.pdse.cellularAutomata.grid.IGrid;
import de.nordakademie.pdse.cellularAutomata.pattern.IPattern;

/**
 * The interface <b>IComplexPattern</b> serves as abstraction for all complex patterns, which could be applied to a grid.
 * This class can work with all different implementations of an {@link IGrid} interface.
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 */
public interface IComplexPattern extends IPattern, HasSize, HasStartingPosition {}
