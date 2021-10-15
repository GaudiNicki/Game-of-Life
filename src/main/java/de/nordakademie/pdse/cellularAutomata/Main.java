package de.nordakademie.pdse.cellularAutomata;

import de.nordakademie.pdse.cellularAutomata.abortCondition.IAbortCondition;
import de.nordakademie.pdse.cellularAutomata.abortCondition.complex.FixedNumberOrNoChange;
import de.nordakademie.pdse.cellularAutomata.experiment.GameOfLife_Experiment_1_1;
import de.nordakademie.pdse.cellularAutomata.experiment.IExperiment;
import de.nordakademie.pdse.cellularAutomata.log.ConsoleLogger;
import de.nordakademie.pdse.cellularAutomata.log.IExperimentLogger;

/**
 * The class <b>Main</b> is the entry point of our application and is used to configure and run experiments
 *
 * @author 16455 (niklas.witzel@nordakademie.de)
 * */
public class Main {
    public static void main(String[] args) {
        /*
        Configure abort condition to use in the experiment
        You can use the following options:
            1. NoChange - experiment stops if the state of each cell isn't changing in the next generation of the grid
            2. FixedNumber(n) - experiments stops after n generations
            3. FixedNumberOrNoChange(n) - experiments stops if abort condition 1. or 2. is met
         */
        IAbortCondition abortCondition = new FixedNumberOrNoChange(100);

        /*
        Configure logger to use in the experiment
        You can use the following options:
            1. ConsoleLogger - output of the experiment is printed to console
            2. FileLogger - output is printed to a log file in the project root with the name of the experiment
            3. ConsoleAndFileLogger - output of the experiment is printed to console and toa log file in the project
                root with the name of the experiment
            4. NoneLogger - output of the experiment is not printed anywhere
         */
        IExperimentLogger logger = new ConsoleLogger();

        /*
        Instantiate the desired experiment with abortCondition and logTarget
        You can choose between the following experiments:
            1. GameOfLife_Experiment_1_1 - Grid = Grid2DArray(cols=41, rows=40, neighborhood=Moore, startingPattern=TumblerPattern), Ruleset=GameOfLife
            2. GameOfLife_Experiment_1_2 - Grid = Grid2DList(cols=41, rows=40, neighborhood=Moore, startingPattern=TumblerPattern), Ruleset=GameOfLife
            3. GameOfLife_Experiment_2_1 - Grid = Grid2DArray(cols=100, rows=100, neighborhood=Moore, startingPattern=ChessFieldPattern), Ruleset=GameOfLife
            4. GameOfLife_Experiment_2_2 - Grid = Grid2DList(cols=100, rows=100, neighborhood=Moore, startingPattern=ChessFieldPattern), Ruleset=GameOfLife
            5. GameOfLife_Experiment_3_1 - Grid = Grid2DArray(cols=300, rows=300, neighborhood=Moore, startingPattern=AllDeadPattern), Ruleset=GameOfLife
            6. GameOfLife_Experiment_3_2 - Grid = Grid2DList(cols=300, rows=300, neighborhood=Moore, startingPattern=AllDeadPattern), Ruleset=GameOfLife
            7. Parity_Experiment_1_1 - Grid = Grid2DArray(cols=400, rows=400, neighborhood=VonNeumann, startingPattern=SquarePattern), Ruleset=Parity
            8. Parity_Experiment_1_2 - Grid = Grid2DList(cols=400, rows=400, neighborhood=VonNeumann, startingPattern=SquarePattern), Ruleset=Parity
            9. Parity_Experiment_2_1 - Grid = Grid2DArray(cols=100, rows=100, neighborhood=VonNeumann, startingPattern=ChessFieldPattern), Ruleset=Parity
            10. Parity_Experiment_2_2 - Grid = Grid2DList(cols=100, rows=100, neighborhood=VonNeumann, startingPattern=ChessFieldPattern), Ruleset=Parity
         */
        IExperiment experiment = new GameOfLife_Experiment_1_1(abortCondition, logger);

        // run the experiment
        experiment.run();

        // you can also use this short way to configure and run an experiment
        new GameOfLife_Experiment_1_1(new FixedNumberOrNoChange(100), new ConsoleLogger()).run();
    }
}
