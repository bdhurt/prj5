package prj5;

import java.text.DecimalFormat;

/**
 * Race class, contains information for a specific race's cases and deaths
 * 
 * @author benjaminhurt
 * @author ayermas
 * @author jaredo19
 * @version 04.23.2021
 *
 */
public class Race {
    private int cases;
    private int deaths;
    private String name;

    /**
     * Constructor for the Race class
     * 
     * @param caseNumber
     *            the number of cases for this race
     * @param deathNumber
     *            the number of deaths for this race
     * @param raceName
     *            name of race object
     * 
     */
    public Race(String raceName, int caseNumber, int deathNumber) {
        cases = caseNumber;
        deaths = deathNumber;
        name = raceName;
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
        if (deaths == -1.0 || cases == -1.0) {
            return -1.0;
        }
        double cfr = deaths * 100;
        cfr = cfr / cases;
        return cfr;
    }


    /**
     * Retrieves the name for this race
     * 
     * @return String name of state
     */
    public String getName() {
        return name;
    }


    /**
     * represents the attributes of our race object as a string
     * 
     * @return race object in String format
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("");
        builder.append(name + ": ");
        builder.append(cases + " cases, ");
        DecimalFormat df = new DecimalFormat("###.#");
        String cfrFormatted = df.format(this.getCFR());
        builder.append(cfrFormatted + "% CFR");
        return builder.toString();
    }
}
