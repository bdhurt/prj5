package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * Tests the FileReader class
 * 
 * @author Benjamin Hurt benjaminhurt
 * @version 04.23.2021
 *
 */
public class FileReaderTest extends student.TestCase{
    private FileReader reader;
    
    public void setUp() throws FileNotFoundException, ParseException {
        reader = new FileReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }
    
    
    public void testFileReader() {
        
    }
}
