package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * Tests the FileReader class
 * 
 * @author benjaminhurt
 * @author ayermas
 * @author jaredo19
 * @version 04.23.2021
 *
 */
public class FileReaderTest extends student.TestCase {
    private FileReader reader;

    /**
     * Sets up the test class
     */
    public void setUp() throws FileNotFoundException, ParseException {
        reader = new FileReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }
    
    /**
     * Attempts to read the file
     */
    public void testReadFile() throws FileNotFoundException, ParseException{
        reader.readFile("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }
    
    /**
     * Ensures a ParseException is thrown when input file has bad format
     */
    public void parseExceptionCheck() throws FileNotFoundException, ParseException{
        FileReader badReader = new FileReader("wrong_cases_and_deaths.csv");
        Exception exception = null;
        try {
            badReader.readFile("wrong_cases_and_deaths.csv");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("file is formatted incorrectly",
            exception instanceof ParseException);
    }
    
    public void exceptionCheck() throws FileNotFoundException, ParseException{
        FileReader badReader = new FileReader("blah.csv");
        Exception exception = null;
        try {
            badReader.readFile("blah.csv");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("file is formatted incorrectly",
            exception instanceof ParseException);
    }
}
