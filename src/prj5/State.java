package prj5;

/**
 * State class, contains data for five races and the state
 * 
 * @author benjaminhurt
 *
 */
public class State {
    private LinkedList<Race> races;
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
        races.add(white);
        races.add(black);
        races.add(latinx);
        races.add(asian);
        races.add(other);
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
        Race[] tempList;
        State tempState;
        tempState = this;
        tempList = tempState.sortAlpha();

        switch (r) {
            case "asian":
                return tempList[0];
            case "black":
                return tempList[1];
            case "latinx":
                return tempList[2];
            case "other":
                return tempList[3];
            case "white":
                return tempList[4];
            default:
                return null;
        }

    }


    /**
     * Sorts the races alphabetically
     * 
     * @return alphabetized array
     */
    public Race[] sortAlpha() {

        return null;
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

}
