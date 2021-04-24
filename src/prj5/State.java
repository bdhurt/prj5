package prj5;

/**
 * State class, contains data for five races and the state
 * 
 * @author benjaminhurt
 * @author ayermas
 * @author jaredo19
 * @version 04.23.2021
 *
 */
public class State {
    private Race[] races;
    private String name;

    /**
     * Constructor for the State class
     * 
     * @param stateName
     *            name of the state
     * @param white
     *            white race object
     * @param black
     *            black race object
     * @param latinx
     *            latinx race object
     * @param asian
     *            asian race object
     * @param other
     *            other race object
     */
    public State(
        String stateName,
        Race white,
        Race black,
        Race latinx,
        Race asian,
        Race other) {
        name = stateName;
        races = new Race[5];
        races[0] = white;
        races[1] = black;
        races[2] = latinx;
        races[3] = asian;
        races[4] = other;
    }


    /**
     * Returns the name of the state object
     * 
     * @return string representing the name of the state
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the race object corresponding to the race name
     * 
     * @param r
     *            name of race we are looking for
     * @return race object we are looking for
     */
    public Race getRace(String r) {
        // Checks each race in the races array for matching name
        for (int i = 0; i < races.length; i++) {
            if (r.equals(races[i].getName())) {
                return races[i];
            }
        }
        // Returns null if there is no matching race
        return null;
    }


    /**
     * Sorts the races alphabetically
     * 
     * @return alphabetized array
     */
    public Race[] sortAlpha() {
        Race tempRace;
        Race[] sortedRace = races;
        for (int i = 0; i < sortedRace.length; i++) {
            for (int j = i + 1; j < sortedRace.length; j++) {
                if (sortedRace[i].getName().compareTo(sortedRace[j]
                    .getName()) > 0) {
                    tempRace = sortedRace[i];
                    sortedRace[i] = sortedRace[j];
                    sortedRace[j] = tempRace;
                }
            }
        }
        return sortedRace;
    }


    /**
     * 
     * Sorts the races by CFR
     * 
     * @return sorted array
     */
    public Race[] sortCFR() {
        Race tempRace;
        Race[] sortedRace = races;
        for (int i = 0; i < sortedRace.length; i++) {
            for (int j = i + 1; j < sortedRace.length; j++) {
                if (sortedRace[i].getCFR() < sortedRace[j].getCFR()) {
                    tempRace = sortedRace[i];
                    sortedRace[i] = sortedRace[j];
                    sortedRace[j] = tempRace;
                }
            }
        }
        return sortedRace;
    }


    /**
     * 
     * 
     * @return State in a string format
     */
    public String toString() {
        Race[] byAlpha = this.sortAlpha();

        StringBuilder s = new StringBuilder();
        s.append(this.getName());
        s.append("\n");
        for (int i = 0; i < byAlpha.length; i++) {
            s.append(byAlpha[i].toString());
            s.append("\n");
        }
        s.append("=====");
        s.append("\n");

        Race[] byCFR = this.sortCFR();
        for (int i = 0; i < byCFR.length; i++) {
            s.append(byCFR[i].toString());
            s.append("\n");
        }
        s.append("=====");
        return s.toString();

    }

}
