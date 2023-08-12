package codingPatterns.mergeIntervals;

import java.util.Arrays;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] arr = {{1,3}, {3,6}, {7,9}, {10, 14}, {12, 14}, {2,3},};
        int[][] ans = new MergeIntervals().merge(arr);
        for (int i = 0; i < ans.length; ++i) {
            System.out.println("[" + ans[i][0] + ","  + ans[i][1] + "]");
        }
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] mergedIntervals = new int[intervals.length][2];

        int start = intervals[0][0];
        int end = intervals[0][1];
        int k = 0;
        int len = 0;

        for (int i = 1; i < intervals.length; ++i) {
            if (end >= intervals[i][0]) {
                end = Math.max(intervals[i][1], end);
            } else {
                mergedIntervals[k][0] = start;
                mergedIntervals[k++][1] = end;
                start = intervals[i][0];
                end = intervals[i][1];
                len++;
            }
        }

        mergedIntervals[k][0] = start;
        mergedIntervals[k++][1] = end;

        // creating subarray till length of the mergedInterval array
        return Arrays.copyOfRange(mergedIntervals,0,len+1);
    }
}

