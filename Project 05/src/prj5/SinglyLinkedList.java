/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */

package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * The SinglyLinkedList implements Linked-List arithmetic in order
 * to sort the different Races.
 * 
 * @author Ryan Clarke (ryanc01)
 * @version 04.22.2021
 *
 * @param <E> the generic element
 */
public class SinglyLinkedList<E> implements Iterable<E> {

    private class SLListIterator<A> implements Iterator<E> {
        
        public Node<E> curr;
        private SinglyLinkedList<E> list;
        
        /**
         * Creates a new SLListIterator
         */
        public SLListIterator(SinglyLinkedList<E> sLList) {
            list = sLList;
            curr = list.head;
        }
        
        /**
         * Gets the current node in the list
         * @return the current node
         */
        private Node<E> current() {
            return curr;
        }
        
        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            boolean next = true;
            if (curr.next.data == null) {
                next = false;
            }
            return next;
        }
        
        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = curr.getData();
            curr = curr.next();
            return data;
        }
        
        // Not sure we need a remove method since our list is only
        // singly-linked and there is no previous node -RC
        
        
    }
    
    @Override
    public Iterator<E> iterator() {
        return new SLListIterator<E>(this);
    }
    
    public static class Node<D> {

        // The data element stored in the node.
        private D data;

        // The next node in the sequence.
        private Node<D> next;


        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(D d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<D> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<D> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData() {
            return data;
        }
    }

    private Node<E> head;

    // the size of the linked list
    private int size;
    
    private Iterator<E> iter;


    /**
     * Creates a new LinkedList object
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
        iter = iterator();
    }

    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }


    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, E obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<E> current = head;

        // empty stack case
        if (isEmpty()) {
            head = new Node<E>(obj);
        }

        // all other cases
        else {
            if (index == 0) {
                Node<E> newNode = new Node<E>(obj);
                newNode.setNext(head);
                head = newNode;
            }
            else {
                int currentIndex = 0;
                while (current != null) {
                    if ((currentIndex + 1) == index) {
                        Node<E> nextNext = current.next;
                        Node<E> newNode = new Node<E>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);
                        //current = null;
                        //break;

                    }
                    currentIndex++;
                    current = current.next();
                }
            }
        }
        size++;
    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(E obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<E> current = head;

        // empty stack case
        if (isEmpty()) {
            head = new Node<E>(obj);
        }

        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public boolean remove(E obj) {
        Node<E> current = head;

        // account for matching head
        if ((null != head) && (obj.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }

        // account for 2+ size
        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                //if (current.next.next != null) {
                //    current.setNext(current.next.next);
                //}
                current.setNext(current.next.next);
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public boolean remove(int index) {
        // if the index is invalid
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else if (index == 0) {
            head = head.next;
            size--;
            return true;
        }
        else {
            Node<E> current = head;
            int currentIndex = 0;

            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<E> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }

            // if the element was never found, this also handles empty case
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    public E get(int index) {
        Node<E> current = head;
        int currentIndex = 0;
        E data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        // make sure we don't call clear on an empty list
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }

    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(E obj) {
        int lastIndex = -1;
        Node<E> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "{";

        Node<E> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list
     * contains A, B, C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<E> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<E> other = ((SinglyLinkedList<E>)obj);
            if (other.size() == this.size()) {
                Node<E> current = head;
                Node<E> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }
        return false;
    }
    
    /**
     * Sorts the races list based on alphabet or CFR value
     * @param comp is the comparator used to compare nodes in the list
     * @param node is the node to be inserted into the sorted list
     */
    private void sort(Comparator<E> comp, Node<E> node) {
        E data = node.getData();
        Node<E> current = head;
        Node<E> beforeCurrent = null;
        //head -> 1
        //head -> 1
        //head.next -> 4
        //Node<E> beforeCurrent = head;
        //node data is it greater than node we're currently on?
        //keep going until it is not greater than anymore
        //insertion happens at 1 node prior to the node at which current > data
        while (current != null && (comp.compare(node.getData(), current.getData()) > 0)) {
            beforeCurrent = current;
            current = current.next();
        }
        node.setNext(current);
        //we need node before current
        if (beforeCurrent != null) {
            beforeCurrent.setNext(node);
        }
        else {
            //if the head is greater than what we're trying to insert
            //we need to insert that node before the head
            head = node;
        }
    }
    
    /**
     * uses insertion sort to loop through and insert a node into the sorted section of the list
     * @param races is the races list
     * @param comp is the comparator being used
     */
    public void insertionSort(Comparator<E> comp) {
        Node <E> firstNode = head;
        if (this.size() > 1) {
            Node<E> unsortedNode = firstNode.next();
            firstNode.setNext(null);
            while (unsortedNode != null) {
                Node<E> input = unsortedNode;
                unsortedNode = unsortedNode.next();
                sort(comp, input);
            }
        }
    }               
}