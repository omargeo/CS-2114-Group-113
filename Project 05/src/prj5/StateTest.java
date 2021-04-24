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
     * a variable that holds the race
     */
    private Race asian;
    
    /**
     * setUp method of the testing class
     */
    public void setUp() {
        black = new Race("Black", 10, 4);
        white = new Race("White", 10, 3);
        asian = new Race("Asian", 10, 2);
        
        races = new SinglyLinkedList<Race>();
        races.add(white);
        races.add(asian);
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
        races1.add(asian);
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
        races1.add(asian);
        state.sortByCFR();
        assertEquals(races1, state.getRaces());
        
        races1 = new SinglyLinkedList<Race>();
        black = new Race("Black", 10, 4);
        white = new Race("White", 10, 4);
        asian = new Race("Asian", 10, 4);
        races1.add(asian);
        races1.add(black);
        races1.add(white);
        races = new SinglyLinkedList<Race>();
        races.add(white);
        races.add(asian);
        races.add(black);
        state = new State("VA", races);
        state.sortByCFR();
        assertEquals(races1, state.getRaces());
    }
    
    /**
     * tests the toString method
     */
    public void testToString() {
        assertEquals("White: 10 cases, 30% CFR\n"
            + "Asian: 10 cases, 20% CFR\n"
            + "Black: 10 cases, 40% CFR", state.toString());
    }
    
    /**
     * tests the equals method and checkContent
     */
    public void testEquals() {
        Object obj = new Object();
        assertFalse(state.equals(obj));
        
        obj = null;
        assertFalse(state.equals(obj));
        
        assertTrue(state.equals(state));
        
        SinglyLinkedList<Race> races1 = new SinglyLinkedList<Race>();
        races1.add(white);
        State state1 = new State("VA", races1);
        SinglyLinkedList<Race> races2 = new SinglyLinkedList<Race>();
        Race other = new Race("Other", 10, 3);
        races2.add(other);
        State state2 = new State("VA", races2);
        assertFalse(state2.equals(state1));
        
        other = new Race("White", 9, 3);
        races2 = new SinglyLinkedList<Race>();
        races2.add(other);
        state2 = new State("VA", races2);
        assertFalse(state2.equals(state1));
        
        other = new Race("White", 10, 2);
        races2 = new SinglyLinkedList<Race>();
        races2.add(other);
        state2 = new State("VA", races2);
        assertFalse(state2.equals(state1));
        
        other = new Race("White", 10, 3);
        races2 = new SinglyLinkedList<Race>();
        races2.add(other);
        races2.add(other);
        state2 = new State("VA", races2);
        assertFalse(state2.equals(state1));
        
        other = new Race("White", 10, 3);
        races2 = new SinglyLinkedList<Race>();
        races2.add(other);
        races2.add(other);
        state2 = new State("V", races2);
        assertFalse(state2.equals(state1));
    }
}
