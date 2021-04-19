package DataVisualization;
import java.util.Comparator;
/**
 * tried to pass double as param but you can't pass primatives into generics
 * @author Van Taylor (van7)
 * @version 2021.04.19
 * @param <A>
 */
public class CFRSortComparator<A> implements Comparator<A> {

    private final double THRESHOLD = 0.0001;
    /**
     * we must override the comparator class as double & not generic
     * this is different from the generic values we wanted via the UML
     * compare based on expectation the first double is higher than the second
     * threshold is used for comparison
     * @param race1
     * @param race2
     * @return the relationship between the two CFR values from the race class
     * @precondition A is a double value
     */
    @Override
    public int compare(A race1CFR, A race2CFR) {
        double r1 = (double)race1CFR;
        double r2 = (double)race2CFR;
        if (r1 == r2) {
            return 0;
        }
        boolean flag = true;
        flag = (Math.abs(r1 - r2) < THRESHOLD);
        if (flag) {
            return 1;
        }
        else {
            return -1;
        }
    }
}