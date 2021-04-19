/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */
package DataVisualization;
import student.TestCase;
import java.text.ParseException;
import java.io.FileNotFoundException;

/**
 * @author Van Taylor (van7)
 * @version 2021.04.19
 */
public class CSVReaderTest extends TestCase {
    private String[] races = {"White", "Black", "LatinX", "Asian", "Other"};
    private CSVReader reader;
    public void setUp() {
        
    }
    
    public void testReadCSV() {
        Exception thrown = null;
        try {
            reader = new CSVReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
        catch (ParseException e) {
            thrown = e;
        }
        catch (FileNotFoundException e) {
            thrown = e;
        }
        finally {
            if (thrown != null) {
                System.out.println(thrown.getMessage());
                thrown.printStackTrace();
            }
        }
    }
    public void testReadFirstLine() {
        
    }
}
