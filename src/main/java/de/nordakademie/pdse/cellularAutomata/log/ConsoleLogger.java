package de.nordakademie.pdse.cellularAutomata.log;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.ConsoleAppender;


/**
 * The <b>ConsoleLogger</b> represents the implementation of an
 * {@link ExperimentLogger}. The class uses methods from its parent to
 * initialize a {@link ConsoleAppender} and add it to the {@link Logger} which
 * is created by its parent. <br>
 * The {@link Logger} will only print to the console.
 * 
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 */
public class ConsoleLogger extends ExperimentLogger {

	public ConsoleLogger() {
		super();
	}

	@Override
	public void initAppender(String experimentName) {
		initConsoleAppender();
	}
}
