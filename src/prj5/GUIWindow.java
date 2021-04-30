package prj5;

import cs2.Shape;
import cs2.Window;
import cs2.Button;
import cs2.WindowSide;
import doublylinkedlist.DLList.Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates the window in which we view the COVID visualization
 * 
 * @author Benjamin Hurt (benjaminhurt)
 * @author Anthony Yermas (ayermas)
 * @author Jared Orendorff (jaredo19)
 * @version 03/18/2021
 */
public class GUIWindow {

    /**
     * Creates our linked list of states
     */
    private LinkedList<State> windowList;

    /**
     * Creates our window
     */
    private Window window;

    /**
     * The bar representing the white population
     */
    private Shape whiteBar;

    /**
     * The bar representing the black population
     */
    private Shape blackBar;

    /**
     * The bar representing the Latinx population
     */
    private Shape latinxBar;

    /**
     * The bar representing the Asian population
     */
    private Shape asianBar;

    /**
     * The bar representing the other population
     */
    private Shape otherBar;

    /**
     * The constant width of our bars
     */
    public static final int WIDTH = 10;

    /**
     * x coordinate of our first bar
     */
    public static final int BAR_X = 100;

    /**
     * y coordinate of our first bar
     */
    public static final int BAR_Y = 100;

    /**
     * Creates the window our visualization will be displayed in, initializes
     * fields
     * 
     * @param windowList
     *            linked list to iterate through to create the visualization
     */
    public GUIWindow(LinkedList<State> windowList) {
        this.windowList = windowList;
        
        // iterates through our linked list
        Iterator stateIter = windowList.iterator();
        
        // creates a new window named COVID Visualization
        window = new Window("COVID Visualization");
        
        // creates our white population bar
        whiteBar = new Shape(BAR_X,BAR_Y,WIDTH,windowList.get)
        
    }
    
    private class DLListIterator<A> implements Iterator<E> {
        private Node<E> curr;
        private boolean called;

        /**
         * Creates a new DLListIterator
         */
        public DLListIterator() {
            curr = head;
            called = false;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return curr.next.getData() != null;

        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (hasNext()) {
                called = true;
                E data = curr.next.getData();
                curr = curr.next();
                return data;
            }
            else {
                throw new NoSuchElementException(
                    "There are no nodes left in the list");
            }

        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {
            if (called) {
                curr.previous.setNext(curr.next);
                curr.next.setPrevious(curr.previous);
                called = false;
                size--;
            }
            else {
                throw new IllegalStateException(
                    "the element has already been removed "
                        + "and/or next has not been called yet");
            }

        }
    }
    
    
}
