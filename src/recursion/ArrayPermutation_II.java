package recursion;

/**
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * Given a collection of numbers, nums, that might contain duplicates,
 * return all possible unique permutations in any order.
 *
 * Example 1:
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2], [1,2,1], [2,1,1]]
 *
 * Example 2:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation_II {
    public static void main(String[] args) {

        int[] nums = {1,1,2};

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
            for (int i = 0; i < n; ++i) {
                ds.add(ar[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        // start i from index and not 0
        for (int i = index; i < n; ++i) {
            if(isDuplicate(ar, index, i)) continue;
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

    public static boolean isDuplicate(int[] ar,int start,int end){
        for(int i=start;i<end;i++){
            if (ar[i] == ar[end]) return true;
        }
        return false;
    }

    public static void permute(int n, int[] ar, List<Integer> ds, List<List<Integer>> ans, boolean[] map) {

        if (ds.size() == n) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < n; ++i) {
            // Skip duplicate elements to prevent redundant work
            if(i > 0 && ar[i] == ar[i-1] && !map[i - 1]) continue;

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
