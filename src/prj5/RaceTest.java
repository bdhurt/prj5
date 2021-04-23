package prj5;

/**
 * Test class for the Race class
 * @author benjaminhurt
 *
 */
public class RaceTest extends student.TestCase{
    private Race r1;
    private Race r2;
    private Race r3;

    /**
     * Sets up the test class
     */
    public void setUp() {
        r1 = new Race("Asian", 1000, 23);
        r2 = new Race("White", -1, 20);
        r3 = new Race("White", 25, -1);
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
        assertEquals(-1.0, r2.getCFR(), .01);
        assertEquals(-1.0, r3.getCFR(), .01);
    }
    
    /**
     * Tests the getName method
     */
    public void testGetName() {
        assertEquals("Asian", r1.getName());
    }
    
    
    /**
     * Tests the toString method
     */
    public void testToString() {
        assertEquals("Asian: 1000 cases, 2.3% CFR", r1.toString());
    }
}
