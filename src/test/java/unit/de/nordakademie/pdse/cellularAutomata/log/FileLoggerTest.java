package unit.de.nordakademie.pdse.cellularAutomata.log;

import de.nordakademie.pdse.cellularAutomata.log.FileLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link FileLogger}.
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 *
 */
public class FileLoggerTest {
	private FileLogger fileLogger;
	private File logFile;

	@Before
	public void beforeEach() {
		this.fileLogger = new FileLogger();

		this.fileLogger.initAppender("experiment");

		this.logFile = new File(System.getProperty("user.dir") + File.separator + "experiment.log");
	}

	@After
	public void afterEach() {
		this.logFile.delete();
	}

	@Test
	public void testLogMessageInFile() throws FileNotFoundException {
		String testMessage = "test log message";
		this.fileLogger.log(testMessage);

		Scanner fileScanner = new Scanner(this.logFile);
		StringBuilder logContent = new StringBuilder();

		while (fileScanner.hasNextLine())
			logContent.append(fileScanner.nextLine());

		fileScanner.close();

		assertThat(logContent.toString(), is(testMessage));
	}

	@Test
	public void testLogMessageWithPlaceholderInFile() throws FileNotFoundException {
		String testMessage = "test {} message";
		this.fileLogger.log(testMessage, "log");

		Scanner fileScanner = new Scanner(this.logFile);
		StringBuilder logContent = new StringBuilder();
		while (fileScanner.hasNextLine())
			logContent.append(fileScanner.nextLine());
		fileScanner.close();

		assertThat(logContent.toString(), is("test log message"));
	}

	@Test
	public void testLogMessageWithMultiplePlaceholdersInFile()
			throws FileNotFoundException {
		String testMessage = "test {} {} {}";
		this.fileLogger.log(testMessage, 1, "log", "message");

		Scanner fileScanner = new Scanner(this.logFile);
		StringBuilder logContent = new StringBuilder();
		while (fileScanner.hasNextLine())
			logContent.append(fileScanner.nextLine());
		fileScanner.close();

		assertThat(logContent.toString(), is("test 1 log message"));
	}
}
