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
        testLatinx = new Race("Latinx", 240, 30);
        testAsian = new Race("Asian", 422, 6);
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
        assertEquals(testWhite, georgia.getRace(RaceEnum.WHITE));
        assertEquals(testBlack, georgia.getRace(RaceEnum.BLACK));
        assertEquals(testLatinx, georgia.getRace(RaceEnum.LATINX));
        assertEquals(testAsian, georgia.getRace(RaceEnum.ASIAN));
        assertEquals(testOther, georgia.getRace(RaceEnum.OTHER));

    }


    /**
     * Tests the sortAlpha method
     */
    public void testSortAlpha() {

    }


    /**
     * Tests the sortCFR method
     */
    public void testSortCFR() {

    }


    /**
     * Tests the getName method
     */
    public void testGetName() {

    }
}
