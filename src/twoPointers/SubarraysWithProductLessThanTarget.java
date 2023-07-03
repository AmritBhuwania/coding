package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement #
 * Given an array with positive numbers and a target number, find all of its contiguous subarrays whose product is less than the target number.
 *
 * Example 1:
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 */
public class SubarraysWithProductLessThanTarget {

    public static void main(String[] args) {

        System.out.println(SubarraysWithProductLessThanTarget.searchSubArrays(new int[]{2, 5, 3, 10}, 30));
        System.out.println(SubarraysWithProductLessThanTarget.searchSubArrays(new int[]{8, 2, 6, 5}, 50));
    }

    private static List<List<Integer>> searchSubArrays(int[] arr, int targetNum) {

        int start = 0;
        int end;
        int currProduct = 1;
        List<List<Integer>> list = new ArrayList<>();

        for (end = 0; end < arr.length; ++end) {
            currProduct *= arr[end];

            while (currProduct >= targetNum && start < arr.length) {
                currProduct /= arr[start++];
            }
            List<Integer> tempList = new ArrayList<>();
            for (int i = end; i >= start; i--) {
                tempList.add(0, arr[i]); // insert new element at index 0 ie at front
                list.add(new ArrayList<>(tempList));
            }
        }
        return list;

    }
}
