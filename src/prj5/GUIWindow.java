package prj5;

import cs2.Shape;
import cs2.Window;
import cs2.Button;
import cs2.WindowSide;
import java.awt.Color;
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
    private Shape barP1;

    /**
     * The bar representing the black population
     */
    private Shape barP2;

    /**
     * The bar representing the Latinx population
     */
    private Shape barP3;

    /**
     * The bar representing the Asian population
     */
    private Shape barP4;

    /**
     * The bar representing the other population
     */
    private Shape barP5;

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

        // creates a new window named COVID Visualization
        window = new Window("COVID Visualization");

        // creates our white population bar
        barP1 = new Shape(BAR_X, BAR_Y, WIDTH, 0, Color.BLUE);
        barP2 = new Shape(BAR_X, BAR_Y, WIDTH, 0, Color.BLUE);
        barP3 = new Shape(BAR_X, BAR_Y, WIDTH, 0, Color.BLUE);
        barP4 = new Shape(BAR_X, BAR_Y, WIDTH, 0, Color.BLUE);
        barP5 = new Shape(BAR_X, BAR_Y, WIDTH, 0, Color.BLUE);
        drawShapes(0);

        
        // creates our quit button
        Button quitButton = new Button("Quit");

        // tells our button what to do when it's clicked
        quitButton.onClick(this, "clickedQuit");

        // adds our Solve button to the top of the window
        window.addButton(quitButton, WindowSide.NORTH);
        
        // creates our solve button
        Button alphaButton = new Button("Sort by Alpha");

        // tells our button what to do when it's clicked
        alphaButton.onClick(this, "clickedAlpha");

        // adds our Solve button to the top of the window
        window.addButton(alphaButton, WindowSide.NORTH);
        
        // creates our solve button
        Button cfrButton = new Button("Sort by CFR");

        // tells our button what to do when it's clicked
        cfrButton.onClick(this, "clickedCFR");

        // adds our Solve button to the top of the window
        window.addButton(cfrButton, WindowSide.NORTH);
    }
    
    private void drawShapes(int listIndex) {
        
    }

}
