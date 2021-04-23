package prj5;

/**
 * Test class for the State class
 * 
 * @author benjaminhurt
 *
 */
public class StateTest extends student.TestCase {

    /**
     * Test state
     */
    private State georgia;

    /**
     * test white race
     */
    private Race testWhite;

    /**
     * test black race
     */
    private Race testBlack;

    /**
     * test latinx race
     */
    private Race testLatinx;

    /**
     * test asian race
     */
    private Race testAsian;

    /**
     * test other race
     */
    private Race testOther;

    /**
     * Sets up the test methods before they run
     */
    public void setUp() {
        testWhite = new Race("white", 100, 8);
        testBlack = new Race("black", 150, 10);
        testLatinx = new Race("latinx", 240, 30);
        testAsian = new Race("asian", 422, 6);
        testOther = new Race("other", 80, 16);

        georgia = new State("Georgia", testWhite, testBlack, testLatinx,
            testAsian, testOther);

    }
  

    /**
     * Tests the getName method
     */
    public void testGetName() {
        assertEquals("Georgia", georgia.getName());
    }


    /**
     * Tests the getRace method
     */
    public void testGetRace() {
        assertEquals(testWhite, georgia.getRace("white"));
        assertEquals(testBlack, georgia.getRace("black"));
        assertEquals(testLatinx, georgia.getRace("latinx"));
        assertEquals(testAsian, georgia.getRace("asian"));
        assertEquals(testOther, georgia.getRace("other"));

    }


    /**
     * Tests the sortAlpha method
     */
    public void testSortAlpha() {
        Race[] testSorted = new Race[5];
        testSorted[0] = testAsian;
        testSorted[1] = testBlack;
        testSorted[2] = testLatinx;
        testSorted[3] = testOther;
        testSorted[4] = testWhite;

    }


    /**
     * Tests the sortCFR method
     */
    public void testSortCFR() {

    }
}
