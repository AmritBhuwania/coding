package twoPointers;

import java.util.Arrays;

/**
 * Problem Statement #
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.
 *
 * Example 1:
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 */
public class TripletsWithSmallerSum {

    public static void main(String[] args) {

        System.out.println(TripletsWithSmallerSum.searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(TripletsWithSmallerSum.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }

    private static int searchTriplets(int[] arr, int target) {

        Arrays.sort(arr);
        int i, count = 0;
        for (i = 0; i <arr.length; ++i) {
            count += searchPairs(arr, i, target - arr[i]);
        }

        return count;
    }

    private static int searchPairs(int[] arr, int first, int targetSum) {

        int start = first + 1;
        int end = arr.length - 1;
        int count = 0;

        while (start < end) {
            if (arr[start] + arr[end] < targetSum) {
                count += end - start;
                ++start;
            } else {
                --end;
            }
        }
        return count;
    }
}
