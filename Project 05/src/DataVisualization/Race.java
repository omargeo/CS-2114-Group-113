package DataVisualization;

public class Race {
    private String type;
    private int cases;
    private int deaths;
    
    public Race(String type, int cases, int deaths) {
        this.type = type;
        this.cases = cases;
        this.deaths = deaths;
    }
    
    public String getType() {
        return type;
    }
    
    public int getCases() {
        return cases;
    }
    
    public int getDeaths() {
        return deaths;
    }
    
    public String toString() {
        //TODO
    }
    
    public boolean equals(Object obj) {
        //TODO
    }
    
    public double caseFatalityRatio() {
        return (getDeaths() / getCases()) * 100;
    }
}
