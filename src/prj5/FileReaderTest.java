package prj5;

import java.io.FileNotFoundException;
import java.io.IOException;

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
     * 
     * @throws IOException
     */
    public void setUp() throws FileNotFoundException, IOException {
        reader = new FileReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }


    /**
     * Attempts to read the file
     * 
     * @throws IOException
     */
    public void testReadFile() throws FileNotFoundException, IOException {
        assertNotNull(reader.readFile(
            "Cases_and_Deaths_by_race_CRDT_Sep2020.csv"));
    }


    /**
     * Attempts to catch IOException
     * 
     * @throws FileNotFoundException
     *             if file not found
     * @throws IOException
     *             if file formatted incorrectly
     */
    public void testIOException() throws FileNotFoundException, IOException {
        Exception exception = null;
        try {
            reader = new FileReader("wrong_cases_and_deaths.csv");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("file has wrong format", exception instanceof IOException);
    }


    /**
     * Attempts to catch FileNotFoundException
     * 
     * @throws FileNotFoundException
     *             if file not found
     * @throws IOException
     *             if file formatted incorrectly
     */
    public void testFileException() throws FileNotFoundException, IOException {
        Exception exception = null;
        try {
            reader = new FileReader("blah.csv");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("file not found",
            exception instanceof FileNotFoundException);
    }
}
