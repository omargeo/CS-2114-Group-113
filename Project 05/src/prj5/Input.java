/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */
package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * The Input class passes the data file the user sent in to the CSVReader class
 * to be parsed.
 * 
 * @author Ryan Clarke (ryanc01)
 * @author Van Taylor (van7)
 * @version 04.23.2021
 *
 */
public class Input {
    
    /**
     * Passes the correct data file on to the CSVReader to be parsed
     * @param args the files being input by the user
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        CSVReader reader;
        if (args.length == 1) {
            reader = new CSVReader(args[0]);
        }
        else {
            reader = new CSVReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            //Output
            for (State state : reader.getStates()) {
                System.out.println(state.getName());
                SinglyLinkedList<Race> list = state.getRaces();
                AlphaSortComparator alpha = new AlphaSortComparator();
                CFRSortComparator cfr = new CFRSortComparator();
                list.sort(list, alpha);
                System.out.println(list.toString());
                System.out.println("=====");
                list.sort(list, cfr);
                System.out.println(list.toString());
                System.out.println("=====");
                
                //I think is code will work better
                state.sortByAlpha();
                System.out.println(state.toString());
                System.out.println("=====");
                state.sortByCFR();
                System.out.println(state.toString());
                System.out.println("=====");
            }
        }

    }
}
