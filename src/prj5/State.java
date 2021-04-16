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


    public Race getRace(RaceEnum r) {
        Race[] tempList;
        State tempState;
        tempState = this;
        tempList = tempState.sortAlpha();

        switch (r) {
            case ASIAN:
                return tempList[0];
            case BLACK:
                return tempList[1];
            case LATINX:
                return tempList[2];
            case OTHER:
                return tempList[3];
            case WHITE:
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
