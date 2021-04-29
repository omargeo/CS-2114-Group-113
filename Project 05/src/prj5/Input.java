/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 *            and integrity at all times. I will not lie, cheat, or steal,
 *            nor will I accept the actions of those who do.
 */
package prj5;

import java.io.FileNotFoundException;

/**
 * The Input class passes the data file the user sent in to the CSVReader class
 * to be parsed.
 * 
 * @author Ryan Clarke (ryanc01)
 * @author Van Taylor (van7)
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 04.23.2020
 */
public class Input {

    /**
     * Passes the correct data file on to the CSVReader to be parsed
     * 
     * @param args
     *            the files being input by the user
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        CSVReader reader;
        if (args.length == 1) {
            reader = new CSVReader(args[0]);
            SinglyLinkedList<State> theStates = reader.getStates();
            GUIWindow window = new GUIWindow(theStates);
        }
        else {
            reader = new CSVReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            SinglyLinkedList<State> theStates = reader.getStates();
            GUIWindow window = new GUIWindow(theStates);
        }

    }
}
