package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/
 *
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 */
public class ArrayPermutation {
    public static void main(String[] args) {

        int[] nums = {1,2,3};

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        // optimised way with less space complexity
        permute(0, n, nums, ans);
        System.out.println(List.of(ans));

        // 2nd way
        ans = new ArrayList<>();
        permute(n, nums, new ArrayList<>(), ans, new boolean[n]);
        System.out.println(List.of(ans));
    }


    public static void permute(int index, int n, int[] ar, List<List<Integer>> ans) {

        if (index == n) {
            List<Integer> ds = new ArrayList<>();

            // copy the current situation of array as list to the answer since the array keep swapping elements
            for (int i = 0; i < n; ++i) {
                ds.add(ar[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        // start i from index and not 0
        for (int i = index; i < n; ++i) {
            swap(i, index, ar);

            // not using (i) in loop since it was swapped with index.
            // So, basically index has become temporary variable in the loop.
            permute(index + 1, n, ar, ans);
            swap(i, index, ar);
        }
    }

    public static void swap(int i, int j, int[] ar) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void permute(int n, int[] ar, List<Integer> ds, List<List<Integer>> ans, boolean[] map) {

        if (ds.size() == n) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (!map[i]) {
                //map.put(i, true);
                map[i] = true;
                ds.add(ar[i]);
                permute(n, ar, ds, ans, map);
                //map.remove(i);
                map[i] = false;
                ds.removeLast();
            }
        }
    }
}
