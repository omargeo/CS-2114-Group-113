package DataVisualization;

public class State {
    private String name;
    private SinglyLinkedList<Race> raceList;
    
    public State(String name, SinglyLinkedList<Race> races) {
        this.name = name;
        this.raceList = races;
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
