package codingPatterns.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
 * Example 1:
 * Appointments: [[1,4], [2,5], [7,9]]
 * Output: false
 * Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
 *
 * Example 2:
 * Appointments: [[6,7], [2,4], [8,12]]
 * Output: true
 * Explanation: None of the appointments overlap, therefore a person can attend all of them.
 */
public class ConflictingAppointments {
    public static void main(String[] args) {

        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(1, 4));
        intervalList.add(new Interval(4, 5));
        intervalList.add(new Interval(7, 9));

        System.out.println(new ConflictingAppointments().canAttendAllMeets(intervalList));
    }

    private boolean canAttendAllMeets(List<Interval> intervalList) {
        Collections.sort(intervalList, (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < intervalList.size(); ++i) {
            if (intervalList.get(i).start < intervalList.get(i-1).end) {
                return false;
            }
        }
        return true;
    }
}


