package de.nordakademie.pdse.cellularAutomata.log;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.FileAppender;
import de.nordakademie.pdse.cellularAutomata.experiment.IExperiment;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The abstract class <b>ExperimentLogger</b> serves as abstraction for all
 * {@link IExperimentLogger}. The class generates and holds a {@link Logger}
 * with depending {@link LoggerContext} and {@link PatternLayoutEncoder}. The
 * class also provides methods for initializing different appenders and logging,
 * which are used in several child classes equally.
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 */
public abstract class ExperimentLogger implements IExperimentLogger {

	protected final Logger logger;

	protected final LoggerContext loggerContext;
	protected PatternLayoutEncoder patternLayoutEncoder;

	public ExperimentLogger() {
		this.loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		initPatternLayoutEncoder();

		this.logger = (Logger) LoggerFactory.getLogger(IExperiment.class);
		this.logger.setAdditive(false);
		this.logger.detachAndStopAllAppenders();
	}

	private void initPatternLayoutEncoder() {
		this.patternLayoutEncoder = new PatternLayoutEncoder();

		this.patternLayoutEncoder.setPattern("%msg%n");
		this.patternLayoutEncoder.setContext(loggerContext);
		this.patternLayoutEncoder.start();
	}

	protected void initConsoleAppender() {
		ConsoleAppender<ILoggingEvent> consoleAppender = new ConsoleAppender<>();

		consoleAppender.setContext(this.loggerContext);
		consoleAppender.setEncoder(this.patternLayoutEncoder);
		consoleAppender.start();

		this.logger.addAppender(consoleAppender);
	}

	protected FileAppender<ILoggingEvent> initFileAppender(String experimentName) {
		File file = new File(System.getProperty("user.dir") + File.separator + experimentName + ".log");

		if (file.exists()) {
			try {
				new PrintWriter(file).close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		FileAppender<ILoggingEvent> fileAppender = new FileAppender<>();

		fileAppender.setFile(file.getName());
		fileAppender.setContext(this.loggerContext);
		fileAppender.setEncoder(this.patternLayoutEncoder);

		this.logger.addAppender(fileAppender);

		return fileAppender;
	}

	@Override
	public void log(String msg) {
		logger.info(msg);
	}

	@Override
	public void log(String msg, Object... placeholders) {
		logger.info(msg, placeholders);
	}

}
