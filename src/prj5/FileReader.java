package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    private LinkedList<State> states;

    /**
     * Reads the input file of states and cases
     * 
     * @param fileName
     *            name of the file being read
     * @throws IOException,
     *             FileNotFoundException
     * @throws ParseException
     *             if the file is in the wrong format
     */
    public FileReader(String fileName)
        throws IOException,
        FileNotFoundException {
        this.states = readFile(fileName);
    }


    /**
     * 
     * @param fileName
     *            name of the file being read
     * @return LinkedList of states
     * @throws IOException
     * @throws ParseException
     *             if the file is in the wrong format
     */
    public LinkedList<State> readFile(String fileName) throws IOException {
        // Scanner parses through file contents
        File fileScan = new File(fileName);
        Scanner scanner = new Scanner(fileScan);
        scanner.nextLine();
        LinkedList<State> states = new LinkedList<State>();
        int x = 0;
        // While there are still lines left to be scanned
        while (scanner.hasNextLine() && x <= 5) {
            String string = scanner.nextLine();
            String[] strArr = string.split(", *");
            // Throw error if file is incorrectly formatted
            if (strArr.length != 11) {
                scanner.close();
                throw new java.io.IOException();
            }
            // First value in input file is the name of the state
            String stateName = strArr[0];
            // If NA, set to -1
            for (int i = 1; i < strArr.length; i++) {
                if (strArr[i].equals("NA")) {
                    strArr[i] = "-1";
                }
            }
            // Take data for cases and deaths into integers
            int whiteCases = Integer.valueOf(strArr[1]);
            int whiteDeaths = Integer.valueOf(strArr[6]);
            int blackCases = Integer.valueOf(strArr[2]);
            int blackDeaths = Integer.valueOf(strArr[7]);
            int latinxCases = Integer.valueOf(strArr[3]);
            int latinxDeaths = Integer.valueOf(strArr[8]);
            int asianCases = Integer.valueOf(strArr[4]);
            int asianDeaths = Integer.valueOf(strArr[9]);
            int otherCases = Integer.valueOf(strArr[5]);
            int otherDeaths = Integer.valueOf(strArr[10]);
            // Create each race
            Race white = new Race("white", whiteCases, whiteDeaths);
            Race black = new Race("black", blackCases, blackDeaths);
            Race latinx = new Race("latinx", latinxCases, latinxDeaths);
            Race asian = new Race("asian", asianCases, asianDeaths);
            Race other = new Race("other", otherCases, otherDeaths);
            // Constructs state with races and adds to LinkedList
            State tempState = new State(stateName, white, black, latinx, asian,
                other);
            states.add(tempState);
            x++;
        }
        scanner.close();

        return states;

    }


    /**
     * Retrieves the LinkedList of states from the fileReader
     * 
     * @return states variable
     */
    public LinkedList<State> getStates() {
        return states;
    }
}
