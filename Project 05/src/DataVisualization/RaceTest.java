/**
 * 
 */
package DataVisualization;

import student.TestCase;

/**
 * Tests the methods in the Race class
 * 
 * @author Ryan Clarke (ryanc01)
 * @version 04.21.2021
 *
 */
public class RaceTest extends TestCase {
    
    private Race white;
    
    /**
     * RaceTest constructor
     */
    public RaceTest() {
        white = new Race("White", 10, 2);
    }
    
    /**
     * Tests the getName, getCases, and getDeaths methods 
     */
    public void testGetters() {
        assertEquals("White", white.getName());
        assertEquals(10, white.getCases());
        assertEquals(2, white.getDeaths());
    }
    
    /**
     * Tests the toString method
     */
    public void testToString() {
        assertEquals("Race: White, Cases: 10, Deaths: 2", white.toString());
    }
    
    /**
     * Tests the equals method
     */
    public void testEquals() {
        assertTrue(white.equals(white));
        assertFalse(white.equals(null));
        Race black = new Race("Black", 8, 1);
        assertFalse(white.equals(black));
        Race same = new Race("White", 10, 2);
        assertTrue(white.equals(same));
    }
    
    /**
     * Tests the caseFatalityRatio method
     */
    public void testCaseFatalityRatio() {
        assertEquals(20.0, white.caseFatalityRatio(), 0.1);
    }

}
