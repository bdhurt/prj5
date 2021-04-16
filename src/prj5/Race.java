package prj5;

/**
 * Race class, contains information for a specific race's cases and deaths
 * 
 * @author benjaminhurt
 *
 */
public class Race {
    private int cases;
    private int deaths;
    private double cfr;

    /**
     * Constructor for the Race class
     * 
     * @param caseNumber
     *            the number of cases for this race
     * @param deathNumber
     *            the number of deaths for this race
     */
    public Race(int caseNumber, int deathNumber) {
        cases = caseNumber;
        deaths = deathNumber;
    }


    /**
     * Retrieves the number of cases for this race
     * 
     * @return cases int
     */
    public int getCases() {
        return cases;
    }


    /**
     * Retrieves the number of deaths for this race
     * 
     * @return deaths int
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * Calculates and returns the case fatality ratio
     * 
     * @return cfr double
     */
    public double getCFR() {
        cfr = deaths * 100;
        cfr = cfr / cases;
        return cfr;
    }
}
