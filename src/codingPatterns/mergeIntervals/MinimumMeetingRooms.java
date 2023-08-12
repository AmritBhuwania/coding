package codingPatterns.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of intervals representing the start and end time of ‘N’ meetings,
 * find the minimum number of rooms required to hold all the meetings.
 * Example 1:
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
 * occur in any of the two rooms later.
 *
 * Example 2:
 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
 */

public class MinimumMeetingRooms {
    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(6, 7));
        intervalList.add(new Interval(2, 4));
        intervalList.add(new Interval(8, 9));
        intervalList.add(new Interval(3, 5));

        System.out.println(new MinimumMeetingRooms().calMinMeetRoom(intervalList));
    }

    private int calMinMeetRoom(List<Interval> intervalList) {

        List<Integer> startTime = new ArrayList<>();
        List<Integer> endTime = new ArrayList<>();
        int i = 0;
        for (; i < intervalList.size(); ++i) {
            startTime.add(intervalList.get(i).start);
            endTime.add(intervalList.get(i).end);
        }

        Collections.sort(startTime);
        Collections.sort(endTime);
        int j = 0;
        int maxRooms = Integer.MIN_VALUE;
        int currRooms = 1;

        for (i = 1; i < startTime.size(); ++i) {
            if (startTime.get(i) >= endTime.get(j)) {
                ++j;
            } else if (startTime.get(i) <= endTime.get(j)) {
                ++currRooms;
            }
            maxRooms = Math.max(currRooms, maxRooms);
        }
        return maxRooms;
    }
}
