/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */

package prj5;

/**
 * This class tests the State class
 * 
 * @author Omar Elgeoushy omarelgeoushy
 * @version 04/21/2021
 *
 */
public class StateTest extends student.TestCase {
    
    /**
     * A variable that holds the state
     */
    private State state;
    
    /**
     * a variable that holds the races
     */
    private SinglyLinkedList<Race> races;
    
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
        black = new Race("Black", 10, 4);
        white = new Race("White", 10, 3);
        
        races = new SinglyLinkedList<Race>();
        races.add(white);
        races.add(black);
        
        state = new State("VA", races);
    }
    
    /**
     * tests the getName method
     */
    public void testGetName() {
        assertEquals("VA", state.getName());
    }
    
    /**
     * tests the getRaces method
     */
    public void testGetRaces() {
        assertEquals(races, state.getRaces());
    }
    
    /**
     * tests the sortByApha method
     */
    public void testSortByAlpha() {
        SinglyLinkedList<Race> races1 = new SinglyLinkedList<Race>();
        races1.add(black);
        races1.add(white);
        
        state.sortByAlpha();
        assertEquals(races1, state.getRaces());
    }
    
    /**
     * tests the sortByCFR method
     */
    public void testSortByCFR() {
        SinglyLinkedList<Race> races1 = new SinglyLinkedList<Race>();
        races1.add(black);
        races1.add(white);
        state.sortByCFR();
        assertEquals(races1, state.getRaces());
        
        races1 = new SinglyLinkedList<Race>();
        black = new Race("Black", 10, 4);
        white = new Race("White", 10, 4);
        races1.add(black);
        races1.add(white);
        state.sortByCFR();
        assertEquals(races1, state.getRaces());
    }
    
    /**
     * tests the toString method
     */
    public void testToString() {
        //Needs to be changed when we fix the CFR method
        assertEquals("VA\nWhite: 10 cases, 3 deaths, 30.0% CFR\n"
            + "Black: 10 cases, 4 deaths, 40.0% CFR", state.toString());
    }
    
    /**
     * tests the equals method and checkContent
     */
    public void testEquals() {
        assertFalse(state.equals(null));
        
        Object obj = new Object();
        assertFalse(state.equals(obj));
        
        assertTrue(state.equals(state));
        
        SinglyLinkedList<Race> races1 = new SinglyLinkedList<Race>();
        races1.add(white);
        State state1 = new State("VA", races1);
        //races1.add(black);
        assertFalse(state.equals(state1));
        
        black = new Race("b", 10, 3);
        races1.add(black);
        state1 = new State("VA", races1);
        assertFalse(state.equals(state1));
        
        races1.remove(1);
        black = new Race("black", 11, 3);
        races1.add(black);
        state1 = new State("VA", races1);
        assertFalse(state.equals(state1));
        
        races1.remove(1);
        black = new Race("black", 10, 4);
        races1.add(black);
        state1 = new State("VA", races1);
        assertFalse(state.equals(state1));
    }
}
