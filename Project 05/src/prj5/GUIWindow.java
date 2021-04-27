/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 *            and integrity at all times. I will not lie, cheat, or steal,
 *            nor will I accept the actions of those who do.
 */
package prj5;

import cs2.Button;
import cs2.Window;
import cs2.WindowSide;

/**
 * TBD
 * 
 * @author Ryan Clarke (ryanc01)
 * @version 04.27.2021
 *
 */
public class GUIWindow {
    
    private Window window;
    private SinglyLinkedList<State> list;
    private Button quit;
    private Button sortByAlpha;
    private Button sortByCFR;
    
    /**
     * Creates a new GUIWindow object
     * @param newList 
 *                  the list of states to be represented on the window
     */
    public GUIWindow(SinglyLinkedList<State> newList) {
        list = newList;
        window = new Window("van7 omarelgeoushy ryanc01");
        quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this, "clickedQuit");
        sortByAlpha = new Button("Sort by Alpha");
        window.addButton(sortByAlpha, WindowSide.NORTH);
        sortByAlpha.onClick(this, "clickedAlpha");
        sortByCFR = new Button("Sort by CFR");
        window.addButton(sortByCFR, WindowSide.NORTH);
        sortByCFR.onClick(this, "clickedCFR");
        for (int i = 0; i < list.size(); i++) {
            Button state = new Button();
            window.addButton(state, WindowSide.SOUTH);
            state.onClick(this, "clickedState");
        }
    }
    
    public void clickedQuit(Button button) {
        System.exit(0);
    }
    
    public void clickedAlpha(Button button) {
        //TODO 
    }
    
    public void clickedCFR(Button button) {
        //TODO
    }
    
    public void clickedState(Button button, SinglyLinkedList<State> list) {
        //TODO
    }
    
    private void displayState(State state) {
        //TODO
    }
}
