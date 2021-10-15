package de.nordakademie.pdse.cellularAutomata.log;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;

/**
 * The <b>FileLogger</b> represents the implementation of an
 * {@link ExperimentLogger}. The class uses methods from its parent to
 * initialize a {@link FileAppender} and add it to the {@link Logger} which is
 * created by its parent. <br>
 * The {@link Logger} will only print to the file with the delivered name.
 * 
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 */
public class FileLogger extends ExperimentLogger {

	private FileAppender<ILoggingEvent> fileAppender;

	public FileLogger() {
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
		this.fileAppender = initFileAppender(experimentName);
	}


}
