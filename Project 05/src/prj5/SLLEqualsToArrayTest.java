package prj5;

import java.util.Arrays;
import java.util.Comparator;
import student.TestCase;

/**
 * 
 * Tests the equals and toArray methods of a singly linked list.
 * 
 * @author Margaret Ellis (maellis1)
 * @author Jeff Robertson (thejar)
 * @author Omar Elgeoushy (omarelgeoushy)
 * 
 * @version 04/22/2021
 *
 */
public class SLLEqualsToArrayTest extends TestCase {

    private SinglyLinkedList<String> emptyListA;
    private SinglyLinkedList<String> emptyListB;
    private SinglyLinkedList<String> smallListA;
    private SinglyLinkedList<String> smallListB;
    private SinglyLinkedList<String> bigListA;
    private SinglyLinkedList<String> bigListB;
    private String nullObject;
    
    /**
     * the exception that is being used for testing
     */
    private Exception thrown = new Exception();


    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        emptyListA = new SinglyLinkedList<String>();
        emptyListB = new SinglyLinkedList<String>();

        smallListA = new SinglyLinkedList<String>();
        smallListB = new SinglyLinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new SinglyLinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }

        bigListB = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        
        // to be explicit
        nullObject = null;
    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        // Same content, same size, but reversed
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // one a subset of the other but with dups
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // make them equal again
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));

    }
    
    /**
     * tests the add method
     */
    public void testAdd() {
        SinglyLinkedList<String> stringL = new SinglyLinkedList<String>();
        stringL.add("1" + 1);
        assertEquals("{11}", stringL.toString());
    }
    
    /**
     * tests the add method
     */
    public void testAdd1() {
        try {
            emptyListA.add(nullObject);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        // checks whether an Exception was actually thrown
        assertNotNull(thrown);
        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalArgumentException);
    }
    
    /**
     * tests the add method
     */
    public void testsAdd2() {
        try {
            emptyListA.add(0, nullObject);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        // checks whether an Exception was actually thrown
        assertNotNull(thrown);
        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalArgumentException);
    }
    
    /**
     * tests the add method
     */
    public void testsAdd3() {
        try {
            emptyListA.add(-1, "input");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        // checks whether an Exception was actually thrown
        assertNotNull(thrown);
        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * tests the add method
     */
    public void testsAdd4() {
        try {
            emptyListA.add(200, "input");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        // checks whether an Exception was actually thrown
        assertNotNull(thrown);
        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * tests the add method
     */
    public void testsAdd5() {
        emptyListA.add(0, "input");
        assertTrue(emptyListA.toString().equals("{input}"));
    }
    
    /**
     * tests the add method
     */
    public void testsAdd6() {
        emptyListA.add(0, "input");
        assertTrue(emptyListA.toString().equals("{input}"));
        
        emptyListA.add(1, "input1");
        assertTrue(emptyListA.toString().equals("{input, input1}"));
    }
    
    /**
     * tests the add method
     */
    public void testsAdd7() {
        emptyListA.add(0, "input");
        assertTrue(emptyListA.toString().equals("{input}"));
        
        emptyListA.add(1, "input1");
        assertTrue(emptyListA.toString().equals("{input, input1}"));
        
        emptyListA.add(0, "input0");
        assertTrue(emptyListA.toString().equals("{input0, input, input1}"));
        
        emptyListA.add(2, "input2");
        assertTrue(emptyListA.toString().equals(
            "{input0, input, input2, input1}"));
    }
    
    /**
     * tests the add method
     */
    public void testsAdd8() {
        emptyListA.add(0, "input");
        assertTrue(emptyListA.toString().equals("{input}"));
    }
    
    /**
     * tests the add method
     */
    public void testsRemove() {
        emptyListA.clear();
        emptyListA.add(0, "input");
        emptyListA.remove(0);
        assertTrue(emptyListA.toString().equals("{}"));
        
        emptyListA.add(0, "input");
        emptyListA.add(1, "input1");
        emptyListA.remove(1);
        assertTrue(emptyListA.toString().equals("{input}"));
        
        emptyListA.add(1, "input1");
        emptyListA.remove(0);
        assertTrue(emptyListA.toString().equals("{input1}"));
        //assertTrue(emptyListA.toString().equals("{input, input1}"));
        
        emptyListA.add(0, "input0");
        emptyListA.remove(1);
        //assertTrue(emptyListA.toString().equals("{input0, input, input1}"));
    }
    
    /**
     * tests clear
     */
    public void testClear() {
        emptyListA.add("input");
        emptyListA.add("input1");
        emptyListA.clear();
        assertEquals("{}", emptyListA.toString());
        assertEquals(0, emptyListA.size());
        
        emptyListA.add("input");
        emptyListA.clear();
        assertEquals("{}", emptyListA.toString());
        assertEquals(0, emptyListA.size());
    }
    
    /**
     * tests lastIndexOf
     */
    public void testLastIndexOf() {
        emptyListA.add("input");
        emptyListA.add("input1");
        assertEquals(1, emptyListA.lastIndexOf("input1"));
        assertEquals(0, emptyListA.lastIndexOf("input"));
        assertEquals(-1, emptyListA.lastIndexOf("i"));
        emptyListA.clear();
        assertEquals(-1, emptyListA.lastIndexOf("i"));
    }
    
    /**
     * tests contains
     */
    public void testContains() {
        emptyListA.add("input");
        emptyListA.add("input1");
        assertTrue(emptyListA.contains("input"));
        assertTrue(emptyListA.contains("input1"));
        assertFalse(emptyListA.contains("i"));
    }
    
    /**
     * tests get
     */
    public void testGet() {
        emptyListA.add("input");
        emptyListA.add("input1");
        assertEquals("input", emptyListA.get(0));
        assertEquals("input1", emptyListA.get(1));
    }
    
    /**
     * tests get
     */
    public void testGet1() {
        emptyListA.add("input");
        emptyListA.add("input1");
        
        try {
            emptyListA.get(2);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        // checks whether an Exception was actually thrown
        assertNotNull(thrown);
        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * test remove
     */
    public void testRemove() {
        emptyListA.add("input");
        emptyListA.add("input1");
        
        try {
            emptyListA.remove(2);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        // checks whether an Exception was actually thrown
        assertNotNull(thrown);
        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * test remove
     */
    public void testRemove1() {
        emptyListA.add("input");
        emptyListA.add("input1");
        
        try {
            emptyListA.remove(-1);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        // checks whether an Exception was actually thrown
        assertNotNull(thrown);
        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * test remove
     */
    public void testRemove2() {
        emptyListA.add("input");
        emptyListA.add("input1");
        assertTrue(emptyListA.remove(1));
        assertTrue(emptyListA.remove(0));
    }
    
    /**
     * test remove
     */
    public void testRemove3() {
        emptyListA.add("input");
        emptyListA.add("input1");
        assertTrue(emptyListA.remove("input1"));
        assertTrue(emptyListA.remove("input"));
        assertFalse(emptyListA.remove("input"));
        
        emptyListA.add("input");
        emptyListA.add("input1");
        assertFalse(emptyListA.remove("input2"));
        
        emptyListA.clear();
        emptyListA.add("input");
        assertTrue(emptyListA.remove("input"));
    }
    
    /**
     * test remove
     */
    public void testRemove4() {
        emptyListA.add("input");
        emptyListA.add("input1");
        assertTrue(emptyListA.remove(0));
    }
    
    /**
     * test remove
     */
    public void testRemove5() {
        try {
            emptyListA.remove(0);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        // checks whether an Exception was actually thrown
        assertNotNull(thrown);
        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * test remove
     */
    public void testRemove6() {
        emptyListA.add("input");
        emptyListA.add("input1");
        assertTrue(emptyListA.remove("input1"));
    }
    
    /**
     * tests sort method
     */
    public void testSort() {
        Race race1 = new Race("White", 10, 1);
        Race race2 = new Race("Black", 8, 0);
        Race race3 = new Race("Asian", 14, 2);
        SinglyLinkedList<Race> list = new SinglyLinkedList<Race>();
        list.add(race1);
        list.add(race2);
        list.add(race3);
        assertEquals("{White: 10 cases, 10.0% CFR, Black: 8 cases, 0.0% CFR, Asian: 14 cases, 14.3% CFR}", list.toString());
        Comparator<Race> alpha = new AlphaSortComparator();
        Comparator<Race> cfr = new CFRSortComparator();
        list.sort(list, alpha);
        assertEquals("{Asian: 14 cases, 14.3% CFR, Black: 8 cases, 0.0% CFR, White: 10 cases, 10.0% CFR}", list.toString());
        //list.sort(list, cfr);
        //assertEquals("{Asian: 14 cases, 14.3% CFR, White: 10 cases, 10.0% CFR, Black: 8 cases, 0.0% CFR}", list.toString());
    }
}
