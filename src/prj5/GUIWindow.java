package prj5;

import cs2.Shape;
import cs2.Window;
import cs2.Button;
import cs2.WindowSide;
import java.awt.Color;

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
     * Creates the bars displayed in the window
     */
    private Shape barP1;
    private Shape barP2;
    private Shape barP3;
    private Shape barP4;
    private Shape barP5;

    /**
     * The constant width of our bars
     */
    public static final int WIDTH = 10;

    /**
     * X coordinate of our first bar
     */
    public static final int BAR_X = 100;

    /**
     * Y coordinate of the bars
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

        // Creates a new window named COVID Visualization
        window = new Window("COVID Visualization");

        // Makes default bars
        barP1 = new Shape(BAR_X, BAR_Y, WIDTH, 0, Color.BLUE);
        barP2 = new Shape(BAR_X, BAR_Y, WIDTH, 0, Color.BLUE);
        barP3 = new Shape(BAR_X, BAR_Y, WIDTH, 0, Color.BLUE);
        barP4 = new Shape(BAR_X, BAR_Y, WIDTH, 0, Color.BLUE);
        barP5 = new Shape(BAR_X, BAR_Y, WIDTH, 0, Color.BLUE);
        // Draws the bars using the first state
        drawShapes(0);

        // Creates our quit button
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        // Creates our sort by alpha button
        Button alphaButton = new Button("Sort by Alpha");
        alphaButton.onClick(this, "clickedAlpha");
        window.addButton(alphaButton, WindowSide.NORTH);

        // Creates our Sort by CFR button
        Button cfrButton = new Button("Sort by CFR");
        cfrButton.onClick(this, "clickedCFR");
        window.addButton(cfrButton, WindowSide.NORTH);
    }


    /**
     * Changes the height of the bars
     * 
     * @param listIndex
     *            the state that is being displayed
     */
    private void drawShapes(int listIndex) {

    }


    /**
     * Sorts alphabetically and redraws the bars when clicked
     */
    public void clickedAlpha() {

    }


    /**
     * Sorts by CFR and redraws the bars when clicked
     */
    public void clickedCFR() {

    }


    public void clickedQuit(Button button) {
        System.exit(0);
    }

}
