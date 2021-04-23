package prj5;

/**
 * Test class for the Race class
 * @author benjaminhurt
 *
 */
public class RaceTest extends student.TestCase{
    private Race r1;

    /**
     * Sets up the test class
     */
    public void setUp() {
        r1 = new Race("Asian", 1000, 23);
    }
    
    
    /**
     * Tests the getCases method
     */
    public void testGetCases() {
        assertEquals(1000, r1.getCases());
    }
    
    
    /**
     * Tests the getDeaths method
     */
    public void testGetDeaths() {
        assertEquals(23, r1.getDeaths());
    }
    
    
    /**
     * Tests the getCFR method
     */
    public void testGetCFR() {
        assertEquals(2.3, r1.getCFR(), .01);
    }
    
    /**
     * Tests the getName method
     */
    public void testGetName() {
        assertEquals("Asian", r1.getName());
    }
}
