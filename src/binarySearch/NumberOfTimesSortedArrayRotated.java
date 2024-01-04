package binarySearch;

import java.util.List;

/**
 * Link: https://youtu.be/4WmTRFZilj8?si=JRsYATTwRL1h6su5
 *
 * Find the Rotation Count in Rotated Sorted array
 * Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.
 * Examples:
 * Input : arr[] = {15, 18, 2, 3, 6, 12}
 * Output: 2
 * Explanation : Initial array must be {2, 3,
 * 6, 12, 15, 18}. We get the given array after
 * rotating the initial array twice.
 *
 * Input : arr[] = {7, 9, 11, 12, 5}
 * Output: 4
 *
 * Input: arr[] = {7, 9, 11, 12, 15};
 * Output: 0
 */
public class NumberOfTimesSortedArrayRotated {

    public static void main(String[] args) {

        List<Integer> input = List.of(5, 6, 7, 9, 11, 1, 3, 4);
        List<Integer> input2 = List.of(11,12,15,18,2,5,6,8);
        List<Integer> input3 = List.of(1, 3, 4, 5, 6, 7, 9, 11);
        System.out.println(numberOfTimesSortedArrayRotated(input));
        System.out.println(numberOfTimesSortedArrayRotated(input2));
        System.out.println(numberOfTimesSortedArrayRotated(input3));

    }

    private static int numberOfTimesSortedArrayRotated(List<Integer> input) {

        if (input.get(0) < input.get(input.size() - 1)) {
            return 0;
        }

        int size = input.size();
        int start = 0, end = size - 1, mid = -1;

        while (start < end) {
            mid = start + (end - start)/2;
            int nextEle = (mid + 1) % size;
            int prevEle = (mid - 1 + size) % size;

            // if we find the minimum element, return
            if (input.get(mid) <= nextEle && input.get(mid) <= prevEle) {
                return Math.min(mid, size - mid);

                // 1st half is sorted, answer lies in 2nd half
            } else if (input.get(start) < input.get(mid)) {
                start = mid - 1;
            } else {
                end = mid + 1;
            }
        }
        return mid;
    }
}
