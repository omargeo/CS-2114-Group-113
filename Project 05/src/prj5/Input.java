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
 * @version 04.22.2021
 *
 */
public class Input {
    
    /**
     * Passes the correct data file on to the CSVReader to be parsed
     * @param args the files being input by the user
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) throws FileNotFoundException, 
    ParseException {
        if (args.length == 1) {
            CSVReader reader = new CSVReader(args[0]);
        }
    }
}
