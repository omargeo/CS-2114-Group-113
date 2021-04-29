/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 *            and integrity at all times. I will not lie, cheat, or steal,
 *            nor will I accept the actions of those who do.
 */
package prj5;

import java.io.FileNotFoundException;

/**
 * The Input class passes the data file the user sent in to the CSVReader class
 * to be parsed. Once the file is parsed, input gets the created list of states
 * and puts them into the GUIWindow for expected data visualization
 * 
 * @author Ryan Clarke (ryanc01)
 * @author Van Taylor (van7)
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 04.23.2020
 */
public class Input {
    /**
     * Passes the correct data file on to the CSVReader to be parsed
     * if args contains more than one file, input will use the default file
     * 
     * @param args
     *            the files being input by the user
     * @throws FileNotFoundException
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) throws FileNotFoundException {
        //declarations
        CSVReader reader;
        SinglyLinkedList<State> theStates;
        GUIWindow window;
        //if-else which determines what CSV to parse based on args
        if (args.length == 1) {
            reader = new CSVReader(args[0]);
            theStates = reader.getStates();
            window = new GUIWindow(theStates);
        }
        else {
            reader = new CSVReader("Cases_and_Deaths_CRDT_NEW.csv");
            theStates = reader.getStates();
            window = new GUIWindow(theStates);
        }
    }
}
