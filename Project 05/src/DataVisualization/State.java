package DataVisualization;

public class State {
    private String name;
    private SinglyLinkedList<Race> races;
    
    public State(String name, Race whiteRace, Race blackRace, Race latinXRace, Race asianRace, Race otherRace) {
        this.name = name;
        //TODO
    }
    
    public String getName() {
        return name;
    }
    
    public SinglyLinkedList<Race> getRaces() {
        return races;
    }
    
    public void sortByAlpha() {
        //TODO
    }
    
    public void sortByCFR() {
        //TODO
    }
    
    public String toString() {
        //TODO
    }
    
    public boolean equals(Object obj) {
        //TODO
    }
}
