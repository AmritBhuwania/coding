package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.

 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 *  Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 */

public class Subsets_II {

    public static void main(String[] args) {
        int[] ar = {1,2,2};
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(ar);
        subsetsWithDup(0, ar, ans, new ArrayList<>());
        System.out.println(List.of(ans));
    }


    public static void subsetsWithDup(int index, int [] ar, List<List<Integer>> ans, List<Integer> ds ) {

        if (index <= ar.length) {
            ans.add(new ArrayList<>(ds));
            if (index == ar.length) {
                return;
            }
        }
        for (int i = index; i < ar.length; i++) {
            if (i > index && ar[i] == ar[i-1]) continue;
            ds.add(ar[i]);
            subsetsWithDup(i + 1, ar, ans, ds);
            ds.removeLast();
        }
    }
}
