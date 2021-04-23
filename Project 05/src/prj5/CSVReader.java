package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * reads the CSV file and parses it into a LinkedList of state objects
 * 
 * @author Van Taylor (van7)
 * @version 2021.04.19
 */
public class CSVReader {
    private SinglyLinkedList<State> states;
    private static final int NA_Parse = -1;
    private String[] raceNames;

    /**
     * csv reader calls the methods used to read the file & creates
     * a new GUI window to visualize the data
     * 
     * @param file
     *            is the CSV file to parse
     * @throws ParseException
     * @throws FileNotFoundException
     */
    public CSVReader(String fileName)
        throws FileNotFoundException {
        states = readCSV(fileName);
        GUIWindow window = new GUIWindow(states);
    }

    /**
     * reads through the CSV file and creates a SinglyLinkedList<State> 
     * representing the data stored
     * @param fileName is the file to parse
     * @return
     *         SinglyLinkedList<State> representing the states in the dataset
     * @throws ParseException if the data is not formatted correctly
     * @throws FileNotFoundException if the file link is bad
     */
    private SinglyLinkedList<State> readCSV(String fileName) throws
        FileNotFoundException {
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
            //instantiate race list for each state
            SinglyLinkedList<Race> theRace = new SinglyLinkedList<Race>();
            String nextLine = file.nextLine();
            String[] stateData = nextLine.split(",");
            // we know the first value in the array must be the state name
            String stateName = stateData[0];
            // verify adjusted length is divisible by 2
            // length - 1 because you're removing the first value
            if ((stateData.length - 1) % 2 != 0) {
                file.close();                
                //throw new ParseException("cases and deaths are uneven", 0);
            }
            // create new array excluding first value of original
            String[] caseAndDeathData = Arrays.copyOfRange(stateData, 1,
                stateData.length);
            // halfway point of new array, also is count of races
            int halfway = caseAndDeathData.length / 2;
            // split the cases & deaths into two arrays
            Integer[] caseVals = readInts(caseAndDeathData, 0, halfway);
            if (caseVals == null) {
                file.close();
                //throw new ParseException("Data is not Integer or NA", 0);
            }
            Integer[] deathVals = readInts(caseAndDeathData, halfway - 1,
                caseAndDeathData.length);
            if (deathVals == null) {
                file.close();
                //throw new ParseException("Data is not Integer or NA", 0);
            }
            // create races and add them to the LinkedList
            for (int i = 0; i < halfway; i++) {
                theRace.add(new Race(raceNames[i], caseVals[i], deathVals[i]));
            }
            //create the state and add it to the LinkedList
            State nextState = new State(stateName, theRace);
            stateList.add(nextState);            
        }
        file.close();
        //once all lines have been read, return the list of states
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
     * example: Cases_White becomes White
     * 
     * @param firstLine
     * @return the race names as an array
     */
    private String[] readFirstLine(String[] firstLine) {
        String[] raceNames = new String[firstLine.length - 1];
        int raceCount = (firstLine.length - 1) / 2;
        for (int i = 1; i < raceCount + 1; i++) {
            // makes substring beginning after the underscore
            String name = firstLine[i].substring(firstLine[i].indexOf('_') + 1);
            raceNames[i - 1] = name;
            //System.out.print(name + " ");
        }
        return raceNames;
    }

    /**
     * got idea from stack overflow
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
    
    public SinglyLinkedList<State> getStates() {
        return states;
    }
}
