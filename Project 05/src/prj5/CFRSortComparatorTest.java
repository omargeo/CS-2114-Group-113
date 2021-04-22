/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */

package prj5;

/**
 * This class tests the CFRSortComparator class
 * 
 * @author Omar Elgeoushy omarelgeoushy
 * @version 04/22/2021
 *
 */
public class CFRSortComparatorTest extends student.TestCase {
    
    /**
     * Tests the compare method 
     */
    public void testCompare() {
        CFRSortComparator cfrSortComparator = new CFRSortComparator();
        Race black = new Race("Black", 7, 3);
        Race white = new Race("White", 7, 3);
        assertEquals(0, cfrSortComparator.compare(black, white));
        
        black = new Race("Black", 7, 7);
        white = new Race("White", 7, 3);
        assertEquals(-1, cfrSortComparator.compare(black, white));
        
        black = new Race("Black", 7, 3);
        white = new Race("White", 7, 7);
        assertEquals(1, cfrSortComparator.compare(black, white));
    }
    
    
}
