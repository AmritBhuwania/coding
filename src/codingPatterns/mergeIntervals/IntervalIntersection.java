package codingPatterns.mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    /**
     * Given two lists of intervals, find the intersection of these two lists.
     * Each list consists of disjoint intervals sorted on their start time.
     *
     * Example 1:
     * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
     * Output: [2, 3], [5, 6], [7, 7]
     * Explanation: The output list contains the common intervals between the two lists.
     *
     * Example 2:
     * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
     * Output: [5, 7], [9, 10]
     * Explanation: The output list contains the common intervals between the two lists.
     */


    public static void main(String[] args) {
        List<Interval> intervalList1 = new ArrayList<>();
        intervalList1.add(new Interval(1, 3));
        intervalList1.add(new Interval(4, 6));
        intervalList1.add(new Interval(7, 9));

        List<Interval> intervalList2 = new ArrayList<>();
        intervalList2.add(new Interval(2, 3));
        intervalList2.add(new Interval(5, 7));

        List<Interval> ans = IntervalIntersection.intervalIntersection(intervalList1, intervalList2);
        ans.forEach(System.out::print);
    }

    private static List<Interval> intervalIntersection(List<Interval> intervalList1, List<Interval> intervalList2) {

        int i = 0, j = 0;
        List<Interval> ans = new ArrayList<>();

        while (i < intervalList1.size() && j < intervalList2.size()) {
            if ((intervalList1.get(i).start >= intervalList2.get(j).start &&
                    intervalList1.get(i).start <= intervalList2.get(j).end) ||
                    (intervalList2.get(j).start >= intervalList1.get(i).start &&
                            intervalList2.get(j).start <= intervalList1.get(i).end)) {

                ans.add(new Interval(Math.max(intervalList1.get(i).start, intervalList2.get(j).start),
                        Math.min(intervalList1.get(i).end, intervalList2.get(j).end)));
            }

            if (intervalList1.get(i).end < intervalList2.get(j).end) {
                i++;
            } else if (intervalList1.get(i).end > intervalList2.get(j).end) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return ans;
    }
}
