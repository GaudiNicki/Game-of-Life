package de.nordakademie.pdse.cellularAutomata.log;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.FileAppender;

/**
 * The <b>ConsoleAndFileLogger</b> represents the implementation of an
 * {@link ExperimentLogger}. The class uses methods from its parent to
 * initialize a {@link FileAppender} and a {@link ConsoleAppender} and add them
 * to the {@link Logger} which is created by its parent. <br>
 * The {@link Logger} will print to the file with the delivered name <b>and</b>
 * the console.
 * 
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 */
public class ConsoleAndFileLogger extends ExperimentLogger {

	private FileAppender<ILoggingEvent> fileAppender;

	public ConsoleAndFileLogger() {
		super();
	}

	@Override
	public void log(String msg) {
		this.fileAppender.start();
		this.logger.info(msg);
		this.fileAppender.stop();
	}

	@Override
	public void log(String msg, Object... placeholders) {
		this.fileAppender.start();
		this.logger.info(msg, placeholders);
		this.fileAppender.stop();
	}

	@Override
	public void initAppender(String experimentName) {
		initConsoleAppender();
		this.fileAppender = initFileAppender(experimentName);
	}

}
