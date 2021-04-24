/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */

package prj5;

/**
 * This class is associated with the State and forms 
 * how it behaves
 * 
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 04/21/2021
 *
 */
public class State {
    /**
     * A variable that holds the name
     */
    private String name;
    
    /**
     * A variable that holds the raceList
     */
    private SinglyLinkedList<Race> raceList;
    
    /**
     * Constructor of the class
     * @param name the name of the state
     * @param races is the list of races
     */
    public State(String name, SinglyLinkedList<Race> races) {
        this.name = name;
        this.raceList = races;
    }
    
    /**
     * A getter method for the name
     * @return a string 
     */
    public String getName() {
        return name;
    }
    
    /**
     * A getter method for the race list
     * @return raceList of the state
     */
    public SinglyLinkedList<Race> getRaces() {
        return raceList;
    }
    
    /**
     * Sorts the races based on the alpha
     */
    public void sortByAlpha() {
        raceList.insertionSort(new AlphaSortComparator());
    }
    
    /**
     * Sorts the races based on the CFR
     */
    public void sortByCFR() {
        raceList.insertionSort(new CFRSortComparator());
    }
    
    /**
     * ToString method that shows the data of the state
     * format: "State
     *          Race: int cases, percent% CFR"
     * @return String of data
     */
    public String toString() {
        String string =  "";
        for (int i = 0; i < raceList.size(); i++) {
            string += raceList.get(i);
                //+ ": " + raceList.get(i).getCases() + 
                //"cases, " + raceList.get(i).caseFatalityRatio() + "CFR");
            //string += String.format("s%: %d cases, %.2f CFR", 
            //    raceList.get(i), raceList.get(i).getCases(), 
            //    raceList.get(i).caseFatalityRatio());
            if (i < raceList.size() - 1) {
                string += "\n";
            }
        }
        
        return string;
    }
    
    /**
     * A method that checks if both the objects matches
     * @param obj is the state we are comparing it to
     * 
     * @return true if they match, false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (obj.getClass() != this.getClass()) {
            return false;
        }
        State state = (State)obj;
        return (this.getName().equals(state.getName()) &&
            this.checkContent(obj));
    }
    
    /**
     * Helper method that checks the content of the states
     * @param obj that is being compared to
     * @return true if the content matches, false otherwise
     */
    private boolean checkContent(Object obj) {
        State state = (State)obj;
        SinglyLinkedList<Race> races = state.getRaces();
        if (races.size() != raceList.size()) {
            return false;
        }
        for (int i = 0; i < getRaces().size(); i++) {
            if (!getRaces().get(i).getName().equals(races.get(i).getName())) {
                return false;
            }
            else if (getRaces().get(i).getCases() != races.get(i).getCases()) {
                return false;
            }
            else if (getRaces().get(i).getDeaths() != 
                races.get(i).getDeaths()) {
                return false;
            }
        }
        return true;
    }
}
