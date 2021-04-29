/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 *            and integrity at all times. I will not lie, cheat, or steal,
 *            nor will I accept the actions of those who do.
 */
package prj5;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Scanner;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * The GUIWindow class creates and updates a visual representation of 
 * COVID-19 data (cases and deaths) across a list of states. Each state is 
 * split up into different races/ethnicities and displayed on the graph. The 
 * GUIWindow can also sort the races by alphabetical order or by case-fatality
 * ratio.
 * 
 * @author Ryan Clarke (ryanc01)
 * @version 04.28.2021
 *
 */
public class GUIWindow {
    
    private Window window;
    private SinglyLinkedList<State> list;
    private Button quit;
    private Button sortByAlpha;
    private Button sortByCFR;
    private State current;
    private Button state1;
    private Button state2;
    private Button state3;
    private Button state4;
    private Button state5;
    private Button state6;
    private Button buttons[];
    
    /**
     * Creates a new GUIWindow object
     * @param newList 
 *                  the list of states to be represented on the window
     */
    public GUIWindow(SinglyLinkedList<State> newList) {
        list = newList;
        window = new Window("van7 omarelgeoushy ryanc01");        
        sortByAlpha = new Button("Sort by Alpha");
        window.addButton(sortByAlpha, WindowSide.NORTH);
        sortByAlpha.onClick(this, "clickedAlpha");
        quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this, "clickedQuit");
        sortByCFR = new Button("Sort by CFR");
        window.addButton(sortByCFR, WindowSide.NORTH);
        sortByCFR.onClick(this, "clickedCFR");
        buttons = addButtons();
        current = list.get(0);
        displayState(current);
    }
    
    /**
     * Getter method for the names of the states on display
     * @param list
     *          the list of the states on display
     * @return
     *          an array of the states' names
     */
    private String[] getNames(SinglyLinkedList<State> list) {
        String[] names = new String[6];
        for (int i = 0; i < 6; i++) {
            State state = list.get(i);
            names[i] = state.getName();
        }
        return names; 
    }
    
    /**
     * Adds the buttons representing each state at the bottom of the window
     * @return
     *          the state-representing buttons in an array
     */
    private Button[] addButtons() {
        String[] names = getNames(list);
        state1 = new Button("Represent " + names[0]);
        state2 = new Button("Represent " + names[1]);
        state3 = new Button("Represent " + names[2]);
        state4 = new Button("Represent " + names[3]);
        state5 = new Button("Represent " + names[4]);
        state6 = new Button("Represent " + names[5]);
        Button stateRep[] = {state1, state2, state3, state4, state5, state6};
        for (Button button : stateRep) {
            window.addButton(button, WindowSide.SOUTH);
            button.onClick(this, "clickedState");
        }
        return stateRep;
    } 
    
    /**
     * Closes out of the window when the "Quit" button is clicked
     * @param button
     *          the "Quit" button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }
    
    /**
     * Sorts the graphs on the window in alphabetical order based on race
     * @param button 
     *          the "Sort by Alpha" button
     */
    public void clickedAlpha(Button button) {
        window.removeAllShapes();
        current.sortByAlpha();
        displayState(current);
    }
    
    /**
     * Sorts the graphs on the window from highest case-fatality ratio to 
     * lowest case-fatality ratio
     * @param button 
     *          the "Sort by CFR" button
     */
    public void clickedCFR(Button button) {
        window.removeAllShapes();
        current.sortByCFR();
        displayState(current);
    }
    
    /**
     * Shows the specified state's graph on the window
     * @param button 
     *          the specified state button ("Represent [State Name]")
     * @param list 
     *          the list of states
     */
    public void clickedState(Button button) {
        window.removeAllShapes();
        Button clicked = button;
        State target = null;
        for (int i = 0; i < 6; i++) {
            if (clicked == buttons[i]) {
                target = list.get(i);
            }
        } 
        displayState(target);
    }
    
    /**
     * Displays the graph of each race's case-fatality ratio for a
     * specific state
     * @param state 
     *          the specified state to display
     */
    private void displayState(State state) {
        TextShape title = new TextShape(30, 10, state.getName() + " Case " + 
            "Fatality Ratios by Race");
        window.addShape(title);
        title.moveTo(300, title.getHeight());
        SinglyLinkedList<Race> races = state.getRaces();
        //generates the cfr bar graph for each race in that state
        for (int i = 0; i < races.size(); i++) {
            Race race = races.get(i);
            double cfr = race.caseFatalityRatio();
            //displays NA if there is no data
            if (cfr < 0) {
                TextShape notAvail = new TextShape(10, 5, "NA");
                window.addShape(notAvail);
                notAvail.moveTo((100 + (i * 150)), 220);
                TextShape name = new TextShape(15, 5, race.getName());
                window.addShape(name);
                name.moveTo((100 + (i * 150)), 250);
            }
            //displays bar graph and ratio % if there is data
            else {
                Shape shape = new Shape((100 + (i * 150)), 100, 25, ((int) 
                    (cfr * 10)));
                window.addShape(shape);
                adjustHeight(shape);
                TextShape name = new TextShape(15, 5, race.getName());
                window.addShape(name);
                name.moveTo((90 + (i * 150)), 250);
                DecimalFormat df = new DecimalFormat("0.#");
                
                TextShape ratio = new TextShape(10, 5, df.format(cfr) + 
                    "%");
                window.addShape(ratio);
                ratio.moveTo((90 + (i * 150)), 275);
            }
            
        }
        current = state;
    }
    
    /**
     * Moves the shape down so it is sitting on the x-axis of the graph
     * @param shape
     *          the specified shape to be moved
     */
    private void adjustHeight(Shape shape) {
        int height = shape.getHeight();
        int newY = 125 - height;
        shape.move(0, newY);
    }
}
