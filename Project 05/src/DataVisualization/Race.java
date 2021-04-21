package DataVisualization;

/**
 * This class represents the collaborative Race/Ethnic Group that consists of
 * the name of the race, the number of COVID-19 cases that group has, and the 
 * number of COVID-19 deaths that group has.
 * 
 * @author Ryan Clarke (ryanc01), Van Taylor (van7)
 * @version 04.21.2021
 *
 */
public class Race {
    private String name;
    private int cases;
    private int deaths;
    
    /**
     * Creates a new Race object
     * @param name the name of the race
     * @param cases the amount of cases that race has
     * @param deaths the amount of deaths that race has
     */
    public Race(String name, int cases, int deaths) {
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
    }
    
    /**
     * Getter method for the name of the race
     * @return the name of the race
     */
    public String getName() {
        return name;
    }
    
    /**
     * Getter method for the number of cases
     * @return the number of cases
     */
    public int getCases() {
        return cases;
    }
    
    /**
     * Getter method for the number of deaths
     * @return the number of deaths
     */
    public int getDeaths() {
        return deaths;
    }
    
    /**
     * To String Output: "Race: name, Cases: cases, Deaths: deaths"
     * @return the string output of this race's attributes
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Race: ");
        builder.append(name);
        builder.append(", ");
        builder.append("Cases: ");
        builder.append(cases);
        builder.append(", ");
        builder.append("Deaths: ");
        builder.append(deaths);
        return builder.toString();
    }
    
    /**
     * Two races are equal if their names are equal
     * @param obj is the object to compare to current race
     * @return whether the object is a race equal to the current race
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Race casted = (Race)obj;
            if(this.getName().equals(casted.getName())) {
                return true;
            }
            /* We might also need to check for equal cases and deaths, not sure
               what you guys think so just leaving this here -RC
             */            
        }
        return false;
    }
    
    /**
     * Calculates the Case-to-Fatality Ratio (CFR) that will be used to present
     * data to the user on the GUIWindow
     * @return the calculated CFR
     */
    public double caseFatalityRatio() {
        return (deaths / cases) * 100; // returning 0.0 on small decimals? -RC
    }
}
