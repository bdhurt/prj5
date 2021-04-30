package prj5;

/**
 * Test class for the State class
 * 
 * @author Benjamin Hurt benjaminhurt
 * @author Anthony Yermas ayermas
 * @author Jared Orendorff jaredo19
 * @version 04/30/2021
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

        System.out.println(testWhite.getCases());
        System.out.println(testWhite.getCFR());

        System.out.println(testBlack.getCases());
        System.out.println(testBlack.getCFR());

        System.out.println(testLatinx.getCases());
        System.out.println(testLatinx.getCFR());

        System.out.println(testAsian.getCases());
        System.out.println(testAsian.getCFR());

        System.out.println(testOther.getCases());
        System.out.println(testOther.getCFR());

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
        assertNull(georgia.getRace("martian"));

    }


    /**
     * Tests the sortAlpha method
     */
    public void testSortAlpha() {
        Race[] sorted = georgia.sortAlpha();
        assertEquals(testAsian, sorted[0]);
        assertEquals(testBlack, sorted[1]);
        assertEquals(testLatinx, sorted[2]);
        assertEquals(testOther, sorted[3]);
        assertEquals(testWhite, sorted[4]);
    }


    /**
     * Tests the sortCFR method
     */
    public void testSortCFR() {
        Race[] sorted = georgia.sortCFR();
        assertEquals(testOther.getCFR(), sorted[0].getCFR(), 0.1);
        assertEquals(testLatinx.getCFR(), sorted[1].getCFR(), 0.1);
        assertEquals(testWhite.getCFR(), sorted[2].getCFR(), 0.1);
        assertEquals(testBlack.getCFR(), sorted[3].getCFR(), 0.1);
        assertEquals(testAsian.getCFR(), sorted[4].getCFR(), 0.1);

    }


    /**
     * Tests the toString method
     */
    public void testToString() {
        assertEquals("Georgia\n" + "asian: 422 cases, 1.4% CFR\n"
            + "black: 150 cases, 6.7% CFR\n" + "latinx: 240 cases, 12.5% CFR\n"
            + "other: 80 cases, 20% CFR\n" + "white: 100 cases, 8% CFR\n"
            + "=====\n" + "other: 80 cases, 20% CFR\n"
            + "latinx: 240 cases, 12.5% CFR\n" + "white: 100 cases, 8% CFR\n"
            + "black: 150 cases, 6.7% CFR\n" + "asian: 422 cases, 1.4% CFR\n"
            + "=====", georgia.toString());
    }
}
