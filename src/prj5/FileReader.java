package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;


public class FileReader {
    /**
     * Linked list of states
     */
    private LinkedList<State> states;

    /**
     * ArrayQueue of applicants
     */
    private ArrayQueue<Person> queue;

    /**
     * Takes in a file of applicants and a file of planets as parameters, parses
     * through them
     * 
     * @param applicantFileName
     *            name of file containing applicants and their attributes
     * @param planetFileName
     *            name of file containing planets and their attributes
     * @throws ParseException
     *             If input file has incorrect format
     * @throws SpaceColonyDataException
     *             If minimum skill values are not met
     * @throws FileNotFoundException
     *             If file cannot be found
     */
    public FileReader(String fileName)
        throws FileNotFoundException,
        ParseException {
        this.states = readFile(fileName);
    }


    /**
     * Declares and instantiates a local array that will store
     * planet objects in sequential order in array indices 0, 1, and 2.
     * 
     * @param fileName
     *            name of file containing planet objects
     * @return Array of Planets
     * @throws ParseException
     *             If input file has incorrect format
     * @throws SpaceColonyDataException
     *             If minimum skill values are not met
     * @throws FileNotFoundException
     *             If file cannot be found
     */
    private LinkedList<State> readFile(String fileName)
        throws FileNotFoundException,
        ParseException {
        // Race array created from file contents
        Race[] tempRace = new Race[5];
        // parses through file contents
        Scanner scanner = new Scanner(new File(fileName));
        int x = 0;
        // while there are still lines left to be scanned
        while (scanner.hasNextLine() && x <= 5) {
            String string = scanner.nextLine();
            String[] strArr = string.split(", *");
            // if file is incorrectly formatted
            if (strArr.length != 11) {
                scanner.close();
                throw new ParseException("Input file is not correct in format",
                    -1);
            }
            String stateName = strArr[0];
            Race white = new Race("white", strArr[1], strArr[6]);
            // adds planet found from file to planets array
            tempPlanet[x] = new Planet(strArr[0], ag, med, tech, Integer
                .parseInt(strArr[4]));
            x++;
        }
        scanner.close();
        // not enough/too many planets were added to planet array
        if (x != ColonyCalculator.NUM_PLANETS) {
            throw new SpaceColonyDataException("There are not 3 planets");
        }

        return tempPlanet;
    }


    /**
     * Declares and instantiates a local queue containing applicants
     * from an input file
     * 
     * @param fileName
     *            name of file containing Person objects
     * @return Array of Person objects
     * @throws ParseException
     *             If input file has incorrect format
     * @throws SpaceColonyDataException
     *             If minimum skill values are not met
     * @throws FileNotFoundException
     *             If file cannot be found
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws FileNotFoundException,
        SpaceColonyDataException,
        ParseException {
        // array queue created from file contents
        ArrayQueue<Person> tempArQ = new ArrayQueue<Person>(
            ArrayQueue.DEFAULT_CAPACITY);
        // parses through file contents
        Scanner scanner = new Scanner(new File(fileName));
        // while there are still lines left to be scanned
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            String[] strArray = string.split(", *");
            // person has no planet preference or file is formatted incorrectly
            if (strArray.length != 5) {
                // if person has no planet preference
                if (strArray.length == 4) {
                    strArray = new String[] { strArray[0], strArray[1],
                        strArray[2], strArray[3], " " };
                }
                // if file is formatted incorrectly
                else {
                    scanner.close();
                    throw new ParseException(
                        "The input file is not properly formatted.", -1);
                }
            }

            // person's skill values
            int ag = Integer.parseInt(strArray[1]);
            int med = Integer.parseInt(strArray[2]);
            int tech = Integer.parseInt(strArray[3]);

            // if person's skill values are invalid
            if (!isInSkillRange(ag, med, tech)) {
                scanner.close();
                throw new SpaceColonyDataException("Skills are not met");
            }

            // if skill values are valid, add to queue
            tempArQ.enqueue(new Person(strArray[0], ag, med, tech,
                strArray[4]));
        }
        scanner.close();
        return tempArQ;
    }


    /**
     * Determines whether or not the person's skill values fall within the range
     * of acceptable values. Returns true if they fall in range, false otherwise
     * 
     * @param num1
     *            agriculture skill value
     * @param num2
     *            medicine skill value
     * @param num3
     *            technology skill value
     * @return boolean representing whether or not all three values are valid
     */
    private boolean isInSkillRange(int num1, int num2, int num3) {
        int[] skillsArray = { num1, num2, num3 };
        for (int skill : skillsArray) {
            if (skill < ColonyCalculator.MIN_SKILL_LEVEL
                || skill > ColonyCalculator.MAX_SKILL_LEVEL) {
                return false;
            }
        }
        return true;
    }
}

}
