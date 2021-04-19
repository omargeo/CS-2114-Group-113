package DataVisualization;

public class Race {
    private String name;
    private int cases;
    private int deaths;
    
    public Race(String name, int cases, int deaths) {
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCases() {
        return cases;
    }
    
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
    
    public boolean equals(Object obj) {
        //TODO
    }
    
    public double caseFatalityRatio() {
        return (getDeaths() / getCases()) * 100;
    }
}
