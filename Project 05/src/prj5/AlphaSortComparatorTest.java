/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */

package prj5;
import student.TestCase;

/**
 * This class tests the AlphaSortComparator class 
 * it verifies the comparator sorts based on alphabetical order
 * 
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 04/22/2021
 */
public class AlphaSortComparatorTest extends TestCase {
    
    /**
     * Tests the compare method 
     */
    public void testCompare() {
        AlphaSortComparator alphaSortComparator = new AlphaSortComparator();
        Race black = new Race("Black", 7, 3);
        Race white = new Race("White", 7, 3);
        int number = alphaSortComparator.compare(black, white);
        assertTrue(number < 0);
        
        number = alphaSortComparator.compare(white, black);
        assertTrue(number > 0);
        
        assertEquals(0, alphaSortComparator.compare(white, white));
    }
}
