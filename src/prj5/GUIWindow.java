package prj5;

import cs2.Shape;
import cs2.Window;
import cs2.Button;
import cs2.WindowSide;
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
    
    
}
