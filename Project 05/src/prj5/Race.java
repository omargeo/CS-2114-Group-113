/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */

package prj5;
import java.text.DecimalFormat;

/**
 * This class represents the collaborative Race/Ethnic Group that consists of
 * the name of the race, the number of COVID-19 cases that group has, and the 
 * number of COVID-19 deaths that group has.
 * 
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 04/21/2021
 */
public class Race {    
    // ~ Fields ------------------------------------------------------------
    private String name;
    private int cases;
    private int deaths;
    // ~ Constructors ------------------------------------------------------
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
    // ~ Methods -----------------------------------------------------------
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
     * To String Output: "RaceName: int cases, Percent% CFR"
     * @return the string output of this race's attributes
     */
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.#");
        String string = name + ": " + cases + " cases, " + 
            df.format(caseFatalityRatio()) + "% CFR";
        return string;
    }
    
    /**
     * Two races are equal if their names, cases, and deaths are equal
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
     * @return double value representing the CFR
     */
    public double caseFatalityRatio() {  
        if ((getDeaths() < 0) || (getCases() < 0)) {
            return -1;            
        }
        else {
            double cfr = ((double)getDeaths() / getCases()) * 100;
            return (cfr);
        }
    }
}
