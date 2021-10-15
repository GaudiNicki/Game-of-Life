package unit.de.nordakademie.pdse.cellularAutomata.log;

import de.nordakademie.pdse.cellularAutomata.log.ConsoleLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link ConsoleLogger}.
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 *
 */
public class ConsoleLoggerTest {

	private ByteArrayOutputStream outContent;
	private ConsoleLogger consoleLogger;

	@Before
	public void beforeEach() {
		this.outContent = new ByteArrayOutputStream();
		this.consoleLogger = new ConsoleLogger();
		consoleLogger.initAppender("experiment");

		System.setOut(new PrintStream(outContent));
	}

	@After
	public void afterEach() {
		System.setOut(System.out);
	}

	@Test
	public void testLogMessageOnConsole() {
		String testMessage = "test log message";
		this.consoleLogger.log(testMessage);
		assertThat(outContent.toString(), is(testMessage + "\r\n"));
	}

	@Test
	public void testLogMessageWithPlaceholderOnConsole() {
		String testMessage = "test {} message";
		this.consoleLogger.log(testMessage, "log");
		assertThat(outContent.toString(), is("test log message" + "\r\n"));
	}

	@Test
	public void testLogMessageWithMultiplePlaceholdersOnConsole() {
		String testMessage = "test {} {} {}";
		this.consoleLogger.log(testMessage, 1, "log", "message");
		assertThat(outContent.toString(), is("test 1 log message" + "\r\n"));
	}
}
