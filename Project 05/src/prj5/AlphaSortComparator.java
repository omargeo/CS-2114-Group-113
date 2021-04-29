/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */

package prj5;
import java.util.Comparator;

/**
 * This class compares the names of races using compareTo from the string class
 * the compareTo method completes the complex behavior of comparing strings
 * lexicographically
 * @author Van Taylor (van7)
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 2021.04.19, 04/22/2021
 */
public class AlphaSortComparator implements Comparator<Race> {

    /**
     * compares two race's names lexicographically
     * @param race1 is the current string 
     * @param race2 is the string to compare with the current string
     * @return the relationship, -1, 0, or 1 based on the alphabetical 
     * relationship race1 has with race2
     */
    @Override
    public int compare(Race race1, Race race2) {
        return (race1.getName().compareToIgnoreCase(race2.getName()));
    }
}