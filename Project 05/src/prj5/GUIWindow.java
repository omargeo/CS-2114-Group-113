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
        for (int i = 0; i < list.size(); i++) {
            State state = list.get(i);
            Button repState = new Button("Represent " + state.getName());
            window.addButton(repState, WindowSide.SOUTH);
            repState.onClick(this, "clickedState");
        }
        current = list.get(0);
        displayState(current);
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
    public void clickedState(Button button, SinglyLinkedList<State> list) {
        String name = button.getTitle();
        Scanner scanner = new Scanner(name);
        String line = scanner.nextLine();
        String[] lineData = line.split(" ");
        //We know the name of the state will be the second item in the list
        String stateName = lineData[1];
        State target = null;
        for (int i = 0; i < list.size(); i++) {
            if ((target == null) && (list.get(i).getName() == stateName)) {
                target = list.get(i);
            }
        }
        scanner.close();
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
                notAvail.moveTo((100 + (i * 150)), 300);
                TextShape name = new TextShape(15, 5, race.getName());
                window.addShape(name);
                name.moveTo((100 + (i * 150)), 320);
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
