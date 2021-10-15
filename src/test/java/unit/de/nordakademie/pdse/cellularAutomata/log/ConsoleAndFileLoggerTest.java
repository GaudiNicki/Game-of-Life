package unit.de.nordakademie.pdse.cellularAutomata.log;

import de.nordakademie.pdse.cellularAutomata.log.ConsoleAndFileLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link ConsoleAndFileLogger}.
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 *
 */
public class ConsoleAndFileLoggerTest {

	private ByteArrayOutputStream outContent;

	private File logFile;
	private ConsoleAndFileLogger consoleAndFileLogger;

	@Before
	public void beforeEach() {
		this.outContent = new ByteArrayOutputStream();
		this.logFile = new File(System.getProperty("user.dir") + File.separator + "experiment.log");
		this.consoleAndFileLogger = new ConsoleAndFileLogger();

		this.consoleAndFileLogger.initAppender("experiment");

		System.setOut(new PrintStream(outContent));
	}

	@After
	public void afterEach() {
		System.setOut(System.out);
		this.logFile.delete();
	}

	@Test
	public void testLogMessageOnConsoleAndFile() throws FileNotFoundException {
		String testMessage = "test log message";
		this.consoleAndFileLogger.log(testMessage);

		Scanner fileScanner = new Scanner(this.logFile);
		StringBuilder logContent = new StringBuilder();
		while (fileScanner.hasNextLine())
			logContent.append(fileScanner.nextLine());
		fileScanner.close();

		assertThat(outContent.toString(), is(testMessage + "\r\n"));
		assertThat(logContent.toString(), is(testMessage));
	}

	@Test
	public void testLogMessageWithPlaceholderOnConsoleAndFile() throws FileNotFoundException {
		String testMessage = "test {} message";
		this.consoleAndFileLogger.log(testMessage, "log");

		Scanner fileScanner = new Scanner(this.logFile);
		StringBuilder logContent = new StringBuilder();
		while (fileScanner.hasNextLine())
			logContent.append(fileScanner.nextLine());
		fileScanner.close();

		assertThat(outContent.toString(), is("test log message" + "\r\n"));
		assertThat(logContent.toString(), is("test log message"));
	}

	@Test
	public void testLogMessageWithMultiplePlaceholdersOnConsoleAndFile() throws FileNotFoundException {
		String testMessage = "test {} {} message";
		this.consoleAndFileLogger.log(testMessage, 1, "log");

		Scanner fileScanner = new Scanner(this.logFile);
		StringBuilder logContent = new StringBuilder();
		while (fileScanner.hasNextLine())
			logContent.append(fileScanner.nextLine());
		fileScanner.close();

		assertThat(outContent.toString(), is("test 1 log message" + "\r\n"));
		assertThat(logContent.toString(), is("test 1 log message"));
	}
}
