package binarySearch;

import java.util.List;

/**
 * Link: https://youtu.be/Id-DdcWb5AU?si=uMJJNYdmzsOclNpr
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * Example:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */
public class SearchElementInRotatedSortedArray {

    public static void main(String[] args) {

        List<Integer> input = List.of(5, 6, 7, 9, 11, 1, 3, 4);
        List<Integer> input2 = List.of(11,12,15,18,2,5,6,8);
        List<Integer> input3 = List.of(1, 3, 4, 5, 6, 7, 9, 11);
        System.out.println(searchElementInRotatedSortedArray(input, 9));
        System.out.println(searchElementInRotatedSortedArray(input2, 8));
        System.out.println(searchElementInRotatedSortedArray(input3, 5));
        System.out.println(searchElementInRotatedSortedArray(input3, 8));
    }

    public static int searchElementInRotatedSortedArray(List<Integer> input, int target) {

        int minElementIndex = findMinimumElementIndex(input);

        if (input.get(minElementIndex) == target) return minElementIndex;

        if (minElementIndex == 0 ) {
            // perfectly sorted array ie no rotation
            return  binarySearch(input, 0, input.size()-1, target);
        }

        if (target >= input.getFirst()) {
            return binarySearch(input, 0, minElementIndex-1, target);
        }

        return binarySearch(input, minElementIndex+1, input.size()-1, target);

    }

    private static int findMinimumElementIndex(List<Integer> input) {

        // handle edge case of already sorted array
        if (input.getFirst() < input.getLast()) {
            return 0;
        }

        int size = input.size();
        int start = 0, end = size - 1, mid = -1;

        while (start <= end) {
            mid = start + (end - start)/2;
            int nextEle = (mid + 1) % size;
            int prevEle = (mid - 1 + size) % size;

            // if we find the minimum element, return
            if (input.get(mid) <= nextEle && input.get(mid) <= prevEle) {
                return mid;

                // 1st half is sorted, answer lies in 2nd half
            } else if (input.get(start) < input.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return mid;
    }

    private static int binarySearch(List<Integer> input, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (input.get(mid) == target) {
                return mid;
            } else if (input.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
