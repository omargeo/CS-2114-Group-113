package DataVisualization;

import java.awt.Button;
import java.awt.Window;

public class GUIWindow {
    private Window window;
    private SinglyLinkedList<State> list;
    private Button quit;
    private Button sortByAlpha;
    private Button sortByCFR;
    
    public GUIWindow(SinglyLinkedList<State> newList) {
        list = newList;
    }
    
    public void clickedAlpha(Button button) {
        //TODO 
    }
    
    public void clickedCFR(Button button) {
        //TODO
    }
    
    public void clickedState(Button button, SinglyLinkedList<State> list) {
        //TODO
    }
    
    private void displayState(State state) {
        //TODO
    }
}
