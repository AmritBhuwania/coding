package binarySearch;

import java.util.List;

/**
 * Link: https://youtu.be/W3-KgsCVH1U?si=rNG-TdxF-VQjw0xs
 * Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array. Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
 *
 * For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.
 *
 * Example :
 * Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
 * Output: 2
 * Output is index of 40 in given array
 */
public class SearchElementInNearlySortedArray {

    public static void main(String[] args) {

        List<Integer> input = List.of(5, 6, 9, 7, 11, 1, 3, 4);
        List<Integer> input2 = List.of(11,12,15,18,16,5,6,8);
        List<Integer> input3 = List.of(1, 3, 4, 5, 6, 10, 9, 11);
        System.out.println(binarySearch(input, 7));
        System.out.println(binarySearch(input2, 15));
        System.out.println(binarySearch(input3, 9));
        System.out.println(binarySearch(input3, 0));
    }

    private static int binarySearch(List<Integer> input, int target) {

        int start = 0, end = input.size() - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (input.get(mid) == target) {
                return mid;

                // check for array bound and the left side element as the element can be at (i-1) index
            } else if (mid - 1 >= start && input.get(mid - 1) == target) {
                return mid-1;

                // // check for array bound and the right side element as the element can be at (i+1) index
            } else if (mid + 1 <= end && input.get(mid + 1) == target) {
                return mid+1;

            } else if (input.get(mid) > target) {
                end = mid - 2; // since we already have checked for (mid - 1)

            } else {
                start = mid + 2; // since we already have checked for (mid + 1)
            }
        }

        return -1;
    }
}
