package DataVisualization;
import java.util.Comparator;

/**
 * compares the names of races using the comparator class.
 * @author Van Taylor (van7)
 * @version 2021.04.19
 */
public class AlphaSortComparator implements Comparator<String> {

    /**
     * compares the two strings lexicographically
     * @param race1 is the current string 
     * @param race2 is the string to compare with the current string
     * @return the relationship, -1, 0, or 1 based on the alphabetical 
     * relationship race1 has with race2
     */
    @Override
    public int compare(String race1, String race2) {
        return(race1.compareToIgnoreCase(race2));
    }
}