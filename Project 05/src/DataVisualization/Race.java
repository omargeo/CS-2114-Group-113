/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */

package DataVisualization;

import java.text.DecimalFormat;

/**
 * This class is associated with the Race and forms 
 * how it behaves
 * 
 * @author Omar Elgeoushy omarelgeoushy
 * @version 04/21/2021
 *
 */
public class Race {
    
    /**
     * A variable that holds the name
     */
    private String name;
    
    /**
     * A variable that holds the cases
     */
    private int cases;
    
    /**
     * A variable that holds the deaths
     */
    private int deaths;
    
    /**
     * Constructor of the class
     * @param name the name of the race
     * @param cases the number of cases
     * @param deaths the number of deaths
     */
    public Race(String name, int cases, int deaths) {
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
    }
    
    /**
     * A getter method for the name
     * @return String of the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * A getter method for the cases
     * @return int of the cases
     */
    public int getCases() {
        return cases;
    }
    
    /**
     * A getter method of the death cases
     * @return int of the death cases
     */
    public int getDeaths() {
        return deaths;
    }
    
    /**
     * To String Output: "Race: int cases, int deaths, Percent% CFR"
     * @return the string output of this race's attributes
     */
    public String toString() {
        String string = name + ": " + cases + " cases, " + 
            deaths + " deaths, " + caseFatalityRatio() + "% CFR";
        return string;
    }
    
    /**
     * two races are equal if their names are equal
     * @param obj is the object to compare to current race
     * @return whether the object is a race equal to the current race
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (obj.getClass() != this.getClass()) {
            return false;
        }
        Race casted = (Race)obj;
        return (this.getName().equals(casted.getName()) && 
            this.getCases() == casted.getCases() && 
            this.getDeaths() == casted.getDeaths());
    }
    
    /**
     * Calculates the CFR 
     * @return double of the CFR
     */
    public double caseFatalityRatio() {
        //TODO 0.0 is returned instead of the right value
        //TODO work on the tenths decimal place of the returned value 
        return (getDeaths() / getCases()) * 100;
    }
}
