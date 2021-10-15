package de.nordakademie.pdse.cellularAutomata.log;

import ch.qos.logback.classic.Logger;

/**
 * The <b>NoneLogger</b> represents the implementation of an
 * {@link ExperimentLogger}. The class will add <b>no</b> appenders to the
 * {@link Logger} which is created by its parent. <br>
 * The {@link Logger} will print <b>nothing</b>.
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 */
public class NoneLogger extends ExperimentLogger {

	public NoneLogger() {
		super();
	}

	@Override
	public void initAppender(String experimentName) {
		// no appender is needed
	}
}
