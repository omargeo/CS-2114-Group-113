/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */

package prj5;

/**
 * This class tests the Race class
 * 
 * @author Omar Elgeoushy omarelgeoushy
 * @version 04/21/2021
 *
 */
public class RaceTest extends student.TestCase {
    
    /**
     * a variable that holds the race
     */
    private Race black;
    
    /**
     * a variable that holds the race
     */
    private Race white;
    
    /**
     * setUp method of the testing class
     */
    public void setUp() {
        black = new Race("Black", 7, 3);
        white = new Race("White", 10, 4);
    }

    /**
     * tests getName method
     */
    public void testGetName() {
        assertEquals("Black", black.getName());
    }
    
    /**
     * tests getCases method
     */
    public void testGetCases() {
        assertEquals(7, black.getCases());
    }
    
    /**
     * tests getDeaths method
     */
    public void testGetDeaths() {
        assertEquals(3, black.getDeaths());
    }
    
    /**
     * tests caseFatalityRatio method
     */
    public void testCaseFatalityRatio() {
        assertEquals(42.8, black.caseFatalityRatio(), 3);
    }
    
    /**
     * tests toString method
     */
    public void testToString() {
        //is wrong for now until we fix CFR
        assertEquals("Black: 7 cases, 3 deaths, 42.8% CFR", black.toString());
    }
    
    /**
     * tests equals method
     */
    public void testEquals() {
        Object obj = new Object();
        assertFalse(black.equals(obj));
        
        assertFalse(black.equals(null));
        
        assertFalse(black.equals(white));
        
        assertTrue(black.equals(black));
        
        Race race1 = new Race("Black", 8, 3);
        assertFalse(black.equals(race1));
        
        race1 = new Race("Black", 7, 2);
        assertFalse(black.equals(race1));
        
        race1 = new Race("other", 7, 2);
        assertFalse(black.equals(race1));
        
    }
}
