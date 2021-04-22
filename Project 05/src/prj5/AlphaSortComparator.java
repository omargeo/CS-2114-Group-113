package prj5;
import java.util.Comparator;

/**
 * compares the names of races using the comparator class.
 * @author Van Taylor (van7)
 * @version 2021.04.19
 */
public class AlphaSortComparator implements Comparator<Race> {

    /**
     * compares the two strings lexicographically
     * @param race1 is the current string 
     * @param race2 is the string to compare with the current string
     * @return the relationship, -1, 0, or 1 based on the alphabetical 
     * relationship race1 has with race2
     */
    @Override
    public int compare(Race race1, Race race2) {
        return(race1.getName().compareToIgnoreCase(race2.getName()));
    }
}