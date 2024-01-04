package binarySearch;

import java.util.List;

public class CeilOfAnElementInSortedArray {

    public static void main(String[] args) {

        List<Integer> input = List.of(-3, -1, 1, 3, 4, 5, 6, 7, 9, 11);

        System.out.println(ceilOfAnElementInSortedArray(input, 9));
        System.out.println(ceilOfAnElementInSortedArray(input, 10));
        System.out.println(ceilOfAnElementInSortedArray(input, 2));
        System.out.println(ceilOfAnElementInSortedArray(input, 8));
        System.out.println(ceilOfAnElementInSortedArray(input, 12));
        System.out.println(ceilOfAnElementInSortedArray(input, 0));
        System.out.println(ceilOfAnElementInSortedArray(input, -2));
        System.out.println(ceilOfAnElementInSortedArray(input, -5));

    }

    private static int ceilOfAnElementInSortedArray(List<Integer> input, int target) {

        // return math.min if target less than the smallest
        if (target < input.getFirst()) {
            return input.getFirst();
        }

        // return last element if target more than the largest element in list
        if (target > input.getLast()) {
            return Integer.MAX_VALUE;
        }

        int start = 0, end = input.size() - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (input.get(mid) == target) {
                return input.get(mid);

            } else if (input.get(mid) > target) {
                result = mid; // this is a probable answer since we are looking for ceil value
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }

        return input.get(result);
    }
}
