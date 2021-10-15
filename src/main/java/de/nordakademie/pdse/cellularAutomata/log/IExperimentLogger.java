package de.nordakademie.pdse.cellularAutomata.log;

/**
 * The <b>IExperimentLogger</b> interface serves as abstraction for all types of
 * loggers for experiments.
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 */
public interface IExperimentLogger {
	/**
	 * This method is used to log a message.
	 *
	 * @param msg the message to be logged
	 */
	void log(String msg);

	/**
	 * This method is used to log a message with any number of placeholders.
	 *
	 * @param msg  the message to be logged with "{}" as placeholders
	 * @param placeholders the placeholders to be inserted in the message
	 */
	void log(String msg, Object... placeholders);

	/**
	 * This method is used to initialize the desired appender in the logger
	 *
	 * @param experimentName the name of the experiment the logger is used in
	 */
	void initAppender(String experimentName);

}
