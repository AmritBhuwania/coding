package codingPatterns.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the
 * correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
 * Example 1:
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 * Example 2:
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
 * Output: [[1,3], [4,12]]
 * Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
 */
public class InsertIntervals {

    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(1, 3));
        intervalList.add(new Interval(5, 7));
        intervalList.add(new Interval(8, 12));
        Interval interval = new Interval(4,6);

        List<Interval> ans = InsertIntervals.insertInterval(intervalList, interval);
        ans.forEach(System.out::print);
    }

    private static List<Interval> insertInterval(List<Interval> intervalList, Interval interval) {

        List<Interval> ans = new ArrayList<>();
        int i = 0;
        int start = interval.start, end = interval.end;

        for (i = 0; i < intervalList.size(); ++i) {
            if (intervalList.get(i).end < interval.start) {
                ans.add(intervalList.get(i));
            } else if (intervalList.get(i).start <= interval.end) {
                start = Math.min(intervalList.get(i).start, interval.start);
                end = Math.max(intervalList.get(i).end, interval.end);
            } else {
                break;
            }
        }

        ans.add(new Interval(start, end));

        for (; i < intervalList.size(); ++i) {
            ans.add(intervalList.get(i));
        }
        return ans;
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString(){
        return "[" + start + "," + end + "]";
    }
}
