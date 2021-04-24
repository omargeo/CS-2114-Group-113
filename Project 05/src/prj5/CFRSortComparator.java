/**
 * @HonorCode As a Hokie, I will conduct myself with honor
 * and integrity at all times. I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 */

package prj5;
import java.util.Comparator;

/**
 * Creates comparator to compare based on a race's Case Fatality Ratio
 * @author Van Taylor (van7)
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 2021.04.19
 */
public class CFRSortComparator implements Comparator<Race> {
    /**
     * We compare two races by their case fatality ratio
     * Note: sort ranks smallest to largest
     * @param race1 is the current race
     * @param race2 is the race to compare to
     * @return the relationship between the two CFR values from the race class
     */
    @Override
    public int compare(Race race1, Race race2) {
        double r1 = race1.caseFatalityRatio();
        double r2 = race2.caseFatalityRatio();
        if (r1 == r2) {
            AlphaSortComparator alpha = new AlphaSortComparator();
            return (alpha.compare(race1, race2));
        }
        else if (r1 > r2) {
            return -1;
        }
        else {
            return 1;
        }
    }
}