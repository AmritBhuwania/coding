package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.

 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 */

public class PrintAllSubsequences {
    public static void main(String[] args) {
        int[] ar = new int[] {1,2,3};
        List<Integer> temp = new ArrayList<>();
        int n = ar.length;

        printAllSubsequences(0, temp, ar, n);
    }

    private static void printAllSubsequences(int index, List<Integer> temp, int[] ar, int n) {
        if (index >= n) {
            System.out.println(Collections.singletonList(temp));
            return;
        }

        // take or pick the particular index into the subsequence
        temp.add(ar[index]);
        printAllSubsequences(index + 1, temp, ar, n);

        // do not pick the particular index into the subsequence,
        // this element is not added to the subsequence
        // (the index element which was previously added, will get removed)
        temp.removeLast();

        printAllSubsequences(index + 1, temp, ar, n);
    }
}
