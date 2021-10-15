package unit.de.nordakademie.pdse.cellularAutomata.log;

import de.nordakademie.pdse.cellularAutomata.log.NoneLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link NoneLogger}.
 *
 * @author 16593 (falko_vincent.partzsch@nordakademie.de)
 *
 */
public class NoneLoggerTest {

	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private PrintStream originalOut = System.out;

	private NoneLogger noneLogger;
	private File logFile;

	@Before
	public void beforeEach() throws FileNotFoundException {
		this.noneLogger = new NoneLogger();
		noneLogger.initAppender("experiment");
		this.logFile = new File(System.getProperty("user.dir") + File.separator  + "experiment.log");


		System.setOut(new PrintStream(outContent));

		if (this.logFile.exists())
			new PrintWriter(this.logFile.getAbsoluteFile()).close();
	}

	@After
	public void afterEach() {
		System.setOut(originalOut);
	}

	@Test
	public void testLogMessageOnNone() throws FileNotFoundException {
		NoneLogger noneLogger = new NoneLogger();
		String testMessage = "test no message";
		noneLogger.log(testMessage);

		if (this.logFile.exists()) {
			Scanner fileScanner = new Scanner(this.logFile);
			StringBuilder logContent = new StringBuilder();
			while (fileScanner.hasNextLine())
				logContent.append(fileScanner.nextLine());
			fileScanner.close();

			assertThat(logContent.toString(), is(""));
		}

		assertThat(outContent.toString(), is(""));
	}

}
