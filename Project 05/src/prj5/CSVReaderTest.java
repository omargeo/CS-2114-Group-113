/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 *            and integrity at all times. I will not lie, cheat, or steal,
 *            nor will I accept the actions of those who do.
 */
package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

/**
 * This class tests the CSVReader class
 * 
 * @author Van Taylor (van7)
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 2021.04.19, 04/21/2021
 */
public class CSVReaderTest extends TestCase {
    // ~ Fields ------------------------------------------------------------
    private CSVReader reader;
    
    // ~ Methods -----------------------------------------------------------
    /**
     * tests the CSV for the default file
     */
    public void testReadCSV() {
        Exception thrown = null;
        try {
            reader = new CSVReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
        catch (Exception e) {
            thrown = e;
        }
        finally {
            if (thrown != null) {
                System.out.println(thrown.getMessage());
                thrown.printStackTrace();
            }
        }
        assertNotNull(reader);
        assertNull(thrown);
    }


    /**
     * tests the CSV reader for the alternative file
     */
    public void testReadCSV2() {
        Exception thrown = null;
        try {
            reader = new CSVReader(
                "Cases_and_Deaths_by_race_RANDOM_NUMBERS.csv");
        }
        catch (Exception e) {
            thrown = e;
        }
        finally {
            if (thrown != null) {
                System.out.println(thrown.getMessage());
                thrown.printStackTrace();
            }
        }
        assertNotNull(reader);
        assertNull(thrown);
    }
    /**
     * tests the CSV reader for the alternative file
     */
    public void testReadCSV3() {
        Exception thrown = null;
        try {
            reader = new CSVReader("fake.csv");
        }
        catch (FileNotFoundException e) {
            thrown = e;
        }
        assertNull(reader);
        assertNotNull(thrown);
    }
}
