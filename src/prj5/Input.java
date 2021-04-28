package prj5;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Reads input
 * 
 * @author jared
 * @author benjaminhurt
 * @author Anthony Yermas
 * @version 04/16/2021
 *
 */
public class Input {

    /**
     * Main method for the project runner
     * 
     * @param args
     *            optional input values
     * @throws ParseException
     * @throws FileNotFoundException
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        IOException {
        FileReader runner;
        if (args.length == 1) {
            runner = new FileReader(args[0]);
        }
        else {
            runner = new FileReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
        LinkedList<State> states = runner.getStates();
        System.out.print(states.toString());
    }
}
