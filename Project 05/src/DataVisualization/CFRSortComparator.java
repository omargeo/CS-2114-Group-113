package DataVisualization;
import java.util.Comparator;

/**
 * Creates comparator to compare based on a race's Case Fatality Ratio
 * @author Van Taylor (van7)
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
            return 0;
            //you can then compare by alphabetical if they're equal
            //I'd like to do it that way but I will leave it up to you all
        }
        else if (r1 > r2) {
            return -1;
        }        
        else {
            return 1;
        }
    }
}