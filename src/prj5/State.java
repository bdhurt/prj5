package prj5;

/**
 * State class, contains data for five races and the state
 * 
 * @author benjaminhurt
 *
 */
public class State implements Comparable<Race> {
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
        for (int i = 0; i < races.length; i++) 
        {
            for (int j = i + 1; j < races.length; j++) { 
                if (races[i].getName().compareTo(races[j].getName()) > 0) 
                {
                    tempRace = races[i];
                    races[i] = races[j];
                    races[j] = tempRace;
                }
            }
        }
        return races;
    }


    /**
     * 
     * Sorts the races by CFR
     * 
     * @return sorted array
     */
    public Race[] sortCFR() {
        return null;
    }


    @Override
    public int compareTo(Race o) {
        // TODO Auto-generated method stub
        return 0;
    }

}
