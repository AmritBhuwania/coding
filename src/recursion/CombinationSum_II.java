package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/description/

 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.

 * Note: The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [ [1,1,6], [1,2,5], [1,7], [2,6] ]

 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [ [1,2,2], [5] ]
 */

public class CombinationSum_II {

    public static void main(String[] args) {
        CombinationSum_II combinationSum = new CombinationSum_II();
        int[] ar = new int[]{1,2,1,1,2};

        List<List<Integer>> ans = combinationSum.combinationSum(ar, 4);
        System.out.println(Collections.singletonList(ans));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;

    }

    public void findCombination(int index, int[] ar, int target, List<List<Integer>> ans,  List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < ar.length; ++i) {
            if (i > index && ar[i] == ar[i-1]) continue;
            if (ar[i] > target) break;

            ds.add(ar[i]);

            // important to do i+1 and not index+1
            findCombination(i + 1, ar, target - ar[i], ans, ds);
            ds.removeLast();
        }
    }
}
