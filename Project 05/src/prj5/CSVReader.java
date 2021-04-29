/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class reads the CSV file and parses it into a
 * LinkedList of state objects
 * Each state object consumes a LinkedList of races
 * The parsing approach is an array-based setup that separates the CSV file
 * into arrays and uses various helper methods to complete the readCSV method.
 * This class implements the extended behavior and is capable of parsing
 * both the first line of the CSV file and accommodate various amounts of
 * races and states.
 * 
 * @author Van Taylor (van7)
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 2021.04.19
 */
public class CSVReader {
    // ~ Fields ------------------------------------------------------------
    private SinglyLinkedList<State> states;
    private static final int NA_Parse = -1;
    private String[] raceNames;
    // ~ Constructors ------------------------------------------------------
    /**
     * CSVReader calls the methods used to read the file.
     * 
     * @param fileName
     *            is the CSV file to parse
     * @throws FileNotFoundException
     *             if the file link is bad
     */
    public CSVReader(String fileName) throws FileNotFoundException {
        states = readCSV(fileName);
    }


    // ~ Methods ------------------------------------------------------
    /**
     * reads through the CSV file and creates a SinglyLinkedList<State>
     * representing the data stored
     * 
     * @precondition the file has an even number of case and death data
     * @precondition the value in each cell is either an integer or NA
     * @param fileName
     *            is the CSV file to parse
     * @return SinglyLinkedList<State> representing the states
     * @throws FileNotFoundException
     *             if the file link is bad
     */
    private SinglyLinkedList<State> readCSV(String fileName)
        throws FileNotFoundException {
        File theFile = new File(fileName);
        Scanner file = new Scanner(theFile);
        file.useDelimiter(",");
        // instantiate state list
        SinglyLinkedList<State> stateList = new SinglyLinkedList<State>();
        // create first line behavior
        String firstLine = file.nextLine();
        String[] firstLineData = firstLine.split(",");
        raceNames = readFirstLine(firstLineData);
        // create behavior for remaining lines
        while (file.hasNextLine()) {
            // instantiate race list for each state
            SinglyLinkedList<Race> theRace = new SinglyLinkedList<Race>();
            String nextLine = file.nextLine();
            String[] stateData = nextLine.split(",");
            // we know the first value in the array must be the state name
            String stateName = stateData[0];
            // create new array excluding first value of original
            String[] caseAndDeathData = Arrays.copyOfRange(stateData, 1,
                stateData.length);
            // halfway point of new array, also is count of races
            int halfway = caseAndDeathData.length / 2;
            // split the cases & deaths into two arrays
            Integer[] caseVals = readInts(caseAndDeathData, 0, halfway);
            Integer[] deathVals = readInts(caseAndDeathData, halfway,
                caseAndDeathData.length);
            // create races and add them to the LinkedList
            for (int i = 0; i < halfway; i++) {
                theRace.add(new Race(raceNames[i], caseVals[i], deathVals[i]));
            }
            // create the state and add it to the LinkedList
            State nextState = new State(stateName, theRace);
            stateList.add(nextState);
        }
        file.close();
        // once all lines have been read, return the list of states
        return stateList;
    }


    /**
     * helper method to read integers from array of strings
     * 
     * @param stringArray
     *            is array to read integers from
     * @param startPoint
     *            is the start point on array to read
     * @param endPoint
     *            is the end point on array to read
     * @return array of integers read. value is -1 if NA is parsed
     */
    private Integer[] readInts(
        String[] stringArray,
        int startPoint,
        int endPoint) {
        Integer[] intArray = new Integer[endPoint - startPoint];
        for (int i = startPoint; i < endPoint; i++) {
            if (isInt(stringArray[i])) {
                intArray[i - startPoint] = Integer.valueOf(stringArray[i]);
            }
            else {
                // check for NA
                if (stringArray[i].equals("NA")) {
                    intArray[i - startPoint] = NA_Parse;
                }
                else {
                    return null;
                }
            }
        }
        return intArray;
    }


    /**
     * Parses the first line in the CSV file to read the race name
     * example: Cases_White becomes White
     * 
     * @param firstLine
     *            is the first line in the CSV file
     * @return the race names as an array
     */
    private String[] readFirstLine(String[] firstLine) {
        String[] raceNames = new String[firstLine.length - 1];
        int raceCount = (firstLine.length - 1) / 2;
        for (int i = 1; i < raceCount + 1; i++) {
            // makes substring beginning after the underscore
            String name = firstLine[i].substring(firstLine[i].indexOf('_') + 1);
            raceNames[i - 1] = name;
        }
        return raceNames;
    }


    /**
     * Checks if the string value is an integer.
     * If an exception is thrown, the method will return false
     * rather than throwing the exception up the chain
     * 
     * @param str
     *            is the string to check if an integer
     * @return whether the string is an integer
     */
    private boolean isInt(String str) {
        try {
            Integer.parseInt(str);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }


    /**
     * allows access to the created list in the CSV reader for other classes
     * 
     * @return the LinkedList of states parsed from the CSV file
     */
    public SinglyLinkedList<State> getStates() {
        return states;
    }
}
