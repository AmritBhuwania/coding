package binarySearch;

import java.util.List;

/**
 * Given a sorted array, find the element in the array which has minimum difference with the given number. .
 * Link: https://youtu.be/3RhGdmoF_ac?si=oAhCwjvPR_SsYsDL
 */
public class MinimumDifferenceElementInSortedArray {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 3, 5, 8, 12, 18);
        int ele = 7;
        int ele2 = 16;
        int ele3 = 0;
        int ele4 = 20;

        System.out.println(minimumDifferenceElementInSortedArray(input, ele));
        System.out.println(minimumDifferenceElementInSortedArray(input, ele2));
        System.out.println(minimumDifferenceElementInSortedArray(input, ele3));
        System.out.println(minimumDifferenceElementInSortedArray(input, ele4));
    }

    private static int minimumDifferenceElementInSortedArray(List<Integer> input, int target) {

        // return 1st element if target less than the smallest
        if (target < input.getFirst()) {
            return input.getFirst();
        }

        // return last element if target more than the largest element in list
        if (target > input.getLast()) {
            return input.getLast();
        }

        int start = 0, end = input.size() - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (input.get(mid) == target) {
                return input.get(mid);

            } else if (input.get(mid) > target) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }

        if (Math.abs(input.get(start) - target) < Math.abs(input.get(end) - target)) {
            return input.get(start);
        } else {
            return input.get(end);
        }
    }
}
