package integration.de.nordakademie.pdse.cellularAutomata.experiment;

import de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition;
import de.nordakademie.pdse.cellularAutomata.abortCondition.Simple.NoChange;
import de.nordakademie.pdse.cellularAutomata.abortCondition.complex.FixedNumber;
import de.nordakademie.pdse.cellularAutomata.abortCondition.complex.FixedNumberOrNoChange;
import de.nordakademie.pdse.cellularAutomata.experiment.GameOfLife_Experiment_1_1;
import de.nordakademie.pdse.cellularAutomata.experiment.GameOfLife_Experiment_3_1;
import de.nordakademie.pdse.cellularAutomata.experiment.IExperiment;
import de.nordakademie.pdse.cellularAutomata.log.ConsoleAndFileLogger;
import de.nordakademie.pdse.cellularAutomata.log.ConsoleLogger;
import de.nordakademie.pdse.cellularAutomata.log.FileLogger;
import de.nordakademie.pdse.cellularAutomata.log.NoneLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Integration-test class for {@link IExperiment}
 * to test the interaction with the classes of {@link IExperiment} and {@link IAbortCondition}
 *
 * @author 17015 (til.zoeller@nordakademie.de)
 */
public class ExperimentIntegrationTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    private IExperiment experiment;

    private IAbortCondition noChange;
    private IAbortCondition fixedNumber;
    private IAbortCondition fixedNumberOrNoChange;

    @Before
    public void beforeEach() {
        this.noChange = new NoChange();
        this.fixedNumber = new FixedNumber(2);
        this.fixedNumberOrNoChange = new FixedNumberOrNoChange(2);

        this.originalOut = System.out;
        this.outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restore() {
        System.setOut(originalOut);
    }

    @Test
    public void testExperimentWithNoChangeAbortConditionAndConsoleLogger() {
        this.experiment = new GameOfLife_Experiment_3_1(this.noChange, new ConsoleLogger());
        this.experiment.run();

        assertThat(outContent.toString(), is(any(String.class)));
        assertThat(outContent.toString(), containsString("0"));
        // Replacing iteration number "(1)" with an empty string, to check only the "1"s from the grid
        assertThat(outContent.toString().replace("(1)", ""), not(containsString("1")));

        assertThat(this.experiment.getIterations(), is(1));
    }

    @Test
    public void testExperimentWithNoChangeAbortConditionAndFileLogger() throws FileNotFoundException {
        this.experiment = new GameOfLife_Experiment_3_1(this.noChange, new FileLogger());
        this.experiment.run();

        File logFile = new File(System.getProperty("user.dir")
                + File.separator + "GameOfLife_Experiment_3_1.log");
        Scanner fileScanner = new Scanner(logFile);
        StringBuilder logContent = new StringBuilder();
        while (fileScanner.hasNextLine())
            logContent.append(fileScanner.nextLine());
        fileScanner.close();

        assertThat(logFile.delete(), is(true));

        assertThat(logContent.toString(), is(any(String.class)));
        assertThat(logContent.toString(), containsString("0"));
        // Replacing iteration number "(1)" with an empty string, to check only the "1"s from the grid
        assertThat(logContent.toString().replace("(1)", ""), not(containsString("1")));

        assertThat(this.experiment.getIterations(), is(1));
    }

    @Test
    public void testExperimentWithNoChangeAbortConditionAndConsoleAndFileLogger() throws FileNotFoundException {
        this.experiment = new GameOfLife_Experiment_3_1(this.noChange, new ConsoleAndFileLogger());
        this.experiment.run();

        File logFile = new File(System.getProperty("user.dir")
                + File.separator + "GameOfLife_Experiment_3_1.log");
        Scanner fileScanner = new Scanner(logFile);
        StringBuilder logContent = new StringBuilder();
        while (fileScanner.hasNextLine())
            logContent.append(fileScanner.nextLine());
        fileScanner.close();

        assertThat(logFile.delete(), is(true));

        assertThat(logContent.toString(), is(any(String.class)));
        assertThat(logContent.toString(), containsString("0"));
        // Replacing iteration number "(1)" with an empty string, to check only the "1"s from the grid
        assertThat(logContent.toString().replace("(1)", ""), not(containsString("1")));

        assertThat(outContent.toString(), is(any(String.class)));
        assertThat(outContent.toString(), containsString("0"));
        // Replacing iteration number "(1)" with an empty string, to check only the "1"s from the grid
        assertThat(outContent.toString().replace("(1)", ""), not(containsString("1")));

        assertThat(this.experiment.getIterations(), is(1));
    }

    @Test
    public void testExperimentWithNoChangeAbortConditionAndNoLogger() {
        this.experiment = new GameOfLife_Experiment_3_1(this.noChange, new NoneLogger());
        this.experiment.run();

        File logFile = new File(System.getProperty("user.dir")
                + File.separator + "GameOfLife_Experiment_3_1.log");

        assertThat(logFile.exists(), is(false));

        assertThat(outContent.toString().isEmpty(), is(true));

        assertThat(this.experiment.getIterations(), is(1));
    }

    @Test
    public void testExperimentWithFixedNumberAbortConditionAndConsoleLogger() {
        this.experiment = new GameOfLife_Experiment_1_1(this.fixedNumber, new ConsoleLogger());
        this.experiment.run();

        assertThat(outContent.toString(), is(any(String.class)));
        assertThat(outContent.toString(), containsString("0"));
        assertThat(outContent.toString(), containsString("1"));

        assertThat(this.experiment.getIterations(), is(2));
    }

    @Test
    public void testExperimentWithFixedNumberAbortConditionAndFileLogger() throws FileNotFoundException {
        this.experiment = new GameOfLife_Experiment_1_1(this.fixedNumber, new FileLogger());
        this.experiment.run();

        File logFile = new File(System.getProperty("user.dir")
                + File.separator + "GameOfLife_Experiment_1_1.log");
        Scanner fileScanner = new Scanner(logFile);
        StringBuilder logContent = new StringBuilder();
        while (fileScanner.hasNextLine())
            logContent.append(fileScanner.nextLine());
        fileScanner.close();

        assertThat(logFile.delete(), is(true));

        assertThat(logContent.toString(), is(any(String.class)));
        assertThat(logContent.toString(), containsString("0"));
        assertThat(logContent.toString(), containsString("1"));

        assertThat(this.experiment.getIterations(), is(2));
    }

    @Test
    public void testExperimentWithFixedNumberAbortConditionAndConsoleAndFileLogger() throws FileNotFoundException {
        this.experiment = new GameOfLife_Experiment_1_1(this.fixedNumber, new ConsoleAndFileLogger());
        this.experiment.run();

        File logFile = new File(System.getProperty("user.dir")
                + File.separator + "GameOfLife_Experiment_1_1.log");
        Scanner fileScanner = new Scanner(logFile);
        StringBuilder logContent = new StringBuilder();
        while (fileScanner.hasNextLine())
            logContent.append(fileScanner.nextLine());
        fileScanner.close();

        assertThat(logFile.delete(), is(true));

        assertThat(logContent.toString(), is(any(String.class)));
        assertThat(logContent.toString(), containsString("0"));
        assertThat(logContent.toString(), containsString("1"));

        assertThat(outContent.toString(), is(any(String.class)));
        assertThat(outContent.toString(), containsString("0"));
        assertThat(outContent.toString(), containsString("1"));

        assertThat(this.experiment.getIterations(), is(2));
    }

    @Test
    public void testExperimentWithFixedNumberAbortConditionAndNoLogger() {
        this.experiment = new GameOfLife_Experiment_1_1(this.fixedNumber, new NoneLogger());
        this.experiment.run();

        File logFile = new File(System.getProperty("user.dir")
                + File.separator + "GameOfLife_Experiment_1_1.log");

        assertThat(logFile.exists(), is(false));

        assertThat(outContent.toString().isEmpty(), is(true));

        assertThat(this.experiment.getIterations(), is(2));
    }

    @Test
    public void testExperimentWithNoChangingGridAndFixedNumberAndNoChangeAbortConditionAndConsoleLogger() {
        this.experiment = new GameOfLife_Experiment_3_1(this.fixedNumberOrNoChange, new ConsoleLogger());
        this.experiment.run();

        assertThat(outContent.toString(), is(any(String.class)));
        assertThat(outContent.toString(), containsString("0"));
        // Replacing iteration number "(1)" with an empty string, to check only the "1"s from the grid
        assertThat(outContent.toString().replace("(1)", ""), not(containsString("1")));

        assertThat(this.experiment.getIterations(), is(1));
    }

    @Test
    public void testExperimentWithNoChangingGridAndFixedNumberAndNoChangeAbortConditionAndFileLogger()
            throws FileNotFoundException {
        this.experiment = new GameOfLife_Experiment_3_1(this.fixedNumberOrNoChange, new FileLogger());
        this.experiment.run();

        File logFile = new File(System.getProperty("user.dir")
                + File.separator + "GameOfLife_Experiment_3_1.log");
        Scanner fileScanner = new Scanner(logFile);
        StringBuilder logContent = new StringBuilder();
        while (fileScanner.hasNextLine())
            logContent.append(fileScanner.nextLine());
        fileScanner.close();

        assertThat(logFile.delete(), is(true));

        assertThat(logContent.toString(), is(any(String.class)));
        assertThat(logContent.toString(), containsString("0"));
        // Replacing iteration number "(1)" with an empty string, to check only the "1"s from the grid
        assertThat(logContent.toString().replace("(1)", ""), not(containsString("1")));

        assertThat(this.experiment.getIterations(), is(1));
    }

    @Test
    public void testExperimentWithNoChangingGridAndFixedNumberAndNoChangeAbortConditionAndConsoleAndFileLogger()
            throws FileNotFoundException {
        this.experiment = new GameOfLife_Experiment_3_1(this.fixedNumberOrNoChange, new ConsoleAndFileLogger());
        this.experiment.run();

        File logFile = new File(System.getProperty("user.dir")
                + File.separator + "GameOfLife_Experiment_3_1.log");
        Scanner fileScanner = new Scanner(logFile);
        StringBuilder logContent = new StringBuilder();
        while (fileScanner.hasNextLine())
            logContent.append(fileScanner.nextLine());
        fileScanner.close();

        assertThat(logFile.delete(), is(true));

        assertThat(logContent.toString(), is(any(String.class)));
        assertThat(logContent.toString(), containsString("0"));
        // Replacing iteration number "(1)" with an empty string, to check only the "1"s from the grid
        assertThat(logContent.toString().replace("(1)", ""), not(containsString("1")));

        assertThat(outContent.toString(), is(any(String.class)));
        assertThat(outContent.toString(), containsString("0"));
        // Replacing iteration number "(1)" with an empty string, to check only the "1"s from the grid
        assertThat(outContent.toString().replace("(1)", ""), not(containsString("1")));

        assertThat(this.experiment.getIterations(), is(1));
    }

    @Test
    public void testExperimentWithNoChangingGridAndFixedNumberAndNoChangeAbortConditionAndNoLogger() {
        this.experiment = new GameOfLife_Experiment_3_1(this.fixedNumberOrNoChange, new NoneLogger());
        this.experiment.run();

        File logFile = new File(System.getProperty("user.dir")
                + File.separator + "GameOfLife_Experiment_3_1.log");

        assertThat(logFile.exists(), is(false));

        assertThat(outContent.toString().isEmpty(), is(true));

        assertThat(this.experiment.getIterations(), is(1));
    }

    @Test
    public void testExperimentWithChangingGridAndFixedNumberAndNoChangeAbortConditionAndConsoleLogger() {
        this.experiment = new GameOfLife_Experiment_1_1(this.fixedNumberOrNoChange, new ConsoleLogger());
        this.experiment.run();

        assertThat(outContent.toString(), is(any(String.class)));
        assertThat(outContent.toString(), containsString("0"));
        assertThat(outContent.toString(), containsString("1"));

        assertThat(this.experiment.getIterations(), is(2));
    }

    @Test
    public void testExperimentWithChangingGridAndFixedNumberAndNoChangeAbortConditionAndFileLogger()
            throws FileNotFoundException {
        this.experiment = new GameOfLife_Experiment_1_1(this.fixedNumberOrNoChange, new FileLogger());
        this.experiment.run();

        File logFile = new File(System.getProperty("user.dir")
                + File.separator + "GameOfLife_Experiment_1_1.log");
        Scanner fileScanner = new Scanner(logFile);
        StringBuilder logContent = new StringBuilder();
        while (fileScanner.hasNextLine())
            logContent.append(fileScanner.nextLine());
        fileScanner.close();

        assertThat(logFile.delete(), is(true));

        assertThat(logContent.toString(), is(any(String.class)));
        assertThat(logContent.toString(), containsString("0"));
        assertThat(logContent.toString(), containsString("1"));

        assertThat(this.experiment.getIterations(), is(2));
    }

    @Test
    public void testExperimentWithChangingGridAndFixedNumberAndNoChangeAbortConditionAndConsoleAndFileLogger()
            throws FileNotFoundException {
        this.experiment = new GameOfLife_Experiment_1_1(this.fixedNumberOrNoChange, new ConsoleAndFileLogger());
        this.experiment.run();

        File logFile = new File(System.getProperty("user.dir")
                + File.separator + "GameOfLife_Experiment_1_1.log");
        Scanner fileScanner = new Scanner(logFile);
        StringBuilder logContent = new StringBuilder();
        while (fileScanner.hasNextLine())
            logContent.append(fileScanner.nextLine());
        fileScanner.close();

        assertThat(logFile.delete(), is(true));

        assertThat(logContent.toString(), is(any(String.class)));
        assertThat(logContent.toString(), containsString("0"));
        assertThat(logContent.toString(), containsString("1"));

        assertThat(outContent.toString(), is(any(String.class)));
        assertThat(outContent.toString(), containsString("0"));
        assertThat(outContent.toString(), containsString("1"));

        assertThat(this.experiment.getIterations(), is(2));
    }

    @Test
    public void testExperimentWithChangingGridAndFixedNumberAndNoChangeAbortConditionAndNoLogger() {
        this.experiment = new GameOfLife_Experiment_1_1(this.fixedNumberOrNoChange, new NoneLogger());
        this.experiment.run();

        File logFile = new File(System.getProperty("user.dir")
                + File.separator + "GameOfLife_Experiment_1_1.log");

        assertThat(logFile.exists(), is(false));

        assertThat(outContent.toString().isEmpty(), is(true));

        assertThat(this.experiment.getIterations(), is(2));
    }


}
