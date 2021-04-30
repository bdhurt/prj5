package prj5;

import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.Button;
import cs2.WindowSide;
import java.awt.Color;
import java.text.DecimalFormat;

/**
 * Creates the window in which we view the COVID visualization
 * 
 * @author Benjamin Hurt (benjaminhurt)
 * @author Anthony Yermas (ayermas)
 * @author Jared Orendorff (jaredo19)
 * @version 04/30/2021
 */
public class GUIWindow {

    // Creates our linked list of states
    private LinkedList<State> windowList;

    // Creates our window
    private Window window;

    // Keeps track of the state being displayed
    private int stateIndex;

    // The constant width of our bars
    private static final int WIDTH = 10;
    // X coordinate of our first bar
    private static final int BAR_X = 100;
    // Y coordinate of the bars
    private static final int BAR_Y = 100;

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

        // Draws the bars using the first state
        stateIndex = 0;
        Race[] sorted = windowList.get(stateIndex).sortAlpha();
        drawShapes(sorted);

        // Creates our sort by alpha button
        Button alphaButton = new Button("Sort by Alpha");
        alphaButton.onClick(this, "clickedAlpha");
        window.addButton(alphaButton, WindowSide.NORTH);

        // Creates our quit button
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        // Creates our Sort by CFR button
        Button cfrButton = new Button("Sort by CFR");
        cfrButton.onClick(this, "clickedCFR");
        window.addButton(cfrButton, WindowSide.NORTH);

        // Creates state buttons
        Button state1Button = new Button(windowList.get(0).getName());
        Button state2Button = new Button(windowList.get(1).getName());
        Button state3Button = new Button(windowList.get(2).getName());
        Button state4Button = new Button(windowList.get(3).getName());
        Button state5Button = new Button(windowList.get(4).getName());
        Button state6Button = new Button(windowList.get(5).getName());

        // Creates state button onClicks
        state1Button.onClick(this, "clickedState1Button");
        state2Button.onClick(this, "clickedState2Button");
        state3Button.onClick(this, "clickedState3Button");
        state4Button.onClick(this, "clickedState4Button");
        state5Button.onClick(this, "clickedState5Button");
        state6Button.onClick(this, "clickedState6Button");

        // Adds the state buttons to the window
        window.addButton(state1Button, WindowSide.SOUTH);
        window.addButton(state2Button, WindowSide.SOUTH);
        window.addButton(state3Button, WindowSide.SOUTH);
        window.addButton(state4Button, WindowSide.SOUTH);
        window.addButton(state5Button, WindowSide.SOUTH);
        window.addButton(state6Button, WindowSide.SOUTH);
    }


    /**
     * Changes the height of the bars
     * 
     * @param listIndex
     *            the state that is being displayed
     */
    private void drawShapes(Race[] races) {
        // Gets the CFR for each race
        double p1CFR = races[0].getCFR();
        double p2CFR = races[1].getCFR();
        double p3CFR = races[2].getCFR();
        double p4CFR = races[3].getCFR();
        double p5CFR = races[4].getCFR();

        // Calculates the height of each bar
        int p1Height = (int)Math.round(10 * p1CFR);
        int p2Height = (int)Math.round(10 * p2CFR);
        int p3Height = (int)Math.round(10 * p3CFR);
        int p4Height = (int)Math.round(10 * p4CFR);
        int p5Height = (int)Math.round(10 * p5CFR);

        // Calculates the y-value of each bar
        int p1Y = BAR_Y + (100 - p1Height);
        int p2Y = BAR_Y + (100 - p2Height);
        int p3Y = BAR_Y + (100 - p3Height);
        int p4Y = BAR_Y + (100 - p4Height);
        int p5Y = BAR_Y + (100 - p5Height);

        // Recreates the shapes with the new heights
        Shape barP1 = new Shape(BAR_X * 1, p1Y, WIDTH, p1Height, Color.BLUE);
        Shape barP2 = new Shape(BAR_X * 2, p2Y, WIDTH, p2Height, Color.BLUE);
        Shape barP3 = new Shape(BAR_X * 3, p3Y, WIDTH, p3Height, Color.BLUE);
        Shape barP4 = new Shape(BAR_X * 4, p4Y, WIDTH, p4Height, Color.BLUE);
        Shape barP5 = new Shape(BAR_X * 5, p5Y, WIDTH, p5Height, Color.BLUE);

        // Creates the race name text boxes displayed in the window
        TextShape raceText1 = new TextShape(BAR_X * 1 - 15, BAR_Y + 110,
            races[0].getName());
        TextShape raceText2 = new TextShape(BAR_X * 2 - 15, BAR_Y + 110,
            races[1].getName());
        TextShape raceText3 = new TextShape(BAR_X * 3 - 15, BAR_Y + 110,
            races[2].getName());
        TextShape raceText4 = new TextShape(BAR_X * 4 - 15, BAR_Y + 110,
            races[3].getName());
        TextShape raceText5 = new TextShape(BAR_X * 5 - 15, BAR_Y + 110,
            races[4].getName());

        // Creates Strings containing the CFR values of each race
        DecimalFormat df = new DecimalFormat("###.#");
        String cfr1 = df.format(races[0].getCFR()) + "%";
        String cfr2 = df.format(races[1].getCFR()) + "%";
        String cfr3 = df.format(races[2].getCFR()) + "%";
        String cfr4 = df.format(races[3].getCFR()) + "%";
        String cfr5 = df.format(races[4].getCFR()) + "%";

        // Creates the CFR text boxes displayed in the window
        TextShape cfrText1 = new TextShape(BAR_X * 1 - 15, BAR_Y + 135, cfr1);
        TextShape cfrText2 = new TextShape(BAR_X * 2 - 15, BAR_Y + 135, cfr2);
        TextShape cfrText3 = new TextShape(BAR_X * 3 - 15, BAR_Y + 135, cfr3);
        TextShape cfrText4 = new TextShape(BAR_X * 4 - 15, BAR_Y + 135, cfr4);
        TextShape cfrText5 = new TextShape(BAR_X * 5 - 15, BAR_Y + 135, cfr5);

        // Adds the shapes to the window
        window.removeAllShapes();
        window.addShape(barP1);
        window.addShape(barP2);
        window.addShape(barP3);
        window.addShape(barP4);
        window.addShape(barP5);
        window.addShape(raceText1);
        window.addShape(raceText2);
        window.addShape(raceText3);
        window.addShape(raceText4);
        window.addShape(raceText5);
        window.addShape(cfrText1);
        window.addShape(cfrText2);
        window.addShape(cfrText3);
        window.addShape(cfrText4);
        window.addShape(cfrText5);
    }


    /**
     * Sorts alphabetically and redraws the bars when clicked
     */
    public void clickedAlpha(Button button) {
        Race[] sorted = windowList.get(stateIndex).sortAlpha();
        drawShapes(sorted);
    }


    /**
     * Sorts by CFR and redraws the bars when clicked
     */
    public void clickedCFR(Button button) {
        Race[] sorted = windowList.get(stateIndex).sortCFR();
        drawShapes(sorted);
    }


    /**
     * Quits the window
     * 
     * @param button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Changes to the first state
     * 
     * @param button
     *            state button
     */
    public void clickedState1Button(Button button) {
        stateIndex = 0;
        Race[] sorted = windowList.get(stateIndex).sortAlpha();
        drawShapes(sorted);
    }


    /**
     * Changes to the first state
     * 
     * @param button
     *            state button
     */
    public void clickedState2Button(Button button) {
        stateIndex = 1;
        Race[] sorted = windowList.get(stateIndex).sortAlpha();
        drawShapes(sorted);
    }


    /**
     * Changes the state
     * 
     * @param button
     *            state button
     */
    public void clickedState3Button(Button button) {
        stateIndex = 2;
        Race[] sorted = windowList.get(stateIndex).sortAlpha();
        drawShapes(sorted);
    }


    /**
     * Changes the state
     * 
     * @param button
     *            state button
     */
    public void clickedState4Button(Button button) {
        stateIndex = 3;
        Race[] sorted = windowList.get(stateIndex).sortAlpha();
        drawShapes(sorted);
    }


    /**
     * Changes the state
     * 
     * @param button
     *            state button
     */
    public void clickedState5Button(Button button) {
        stateIndex = 4;
        Race[] sorted = windowList.get(stateIndex).sortAlpha();
        drawShapes(sorted);
    }


    /**
     * Changes the state
     * 
     * @param button
     *            state button
     */
    public void clickedState6Button(Button button) {
        stateIndex = 5;
        Race[] sorted = windowList.get(stateIndex).sortAlpha();
        drawShapes(sorted);
    }

}
