package binarySearch;

import java.util.List;

/**
 * Link: https://youtu.be/zr_AoTxzn0Y?si=2hn0yQKZRMPn9Ees
 *
 * Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.
 * Example:
 * Input : arr[] = {1, 3, 5, 5, 5, 5 ,67, 123, 125}
 *         x = 5
 * Output : First Occurrence = 2
 *          Last Occurrence = 5
 */
public class FirstLastOccurenceOfAnElement {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 3, 5, 7, 7, 7, 9, 11);
        int searchEle = 7;

        int size = input.size();
        int start = 0, end = size - 1;

        System.out.println(firstOccurenceOfAnElement(input, start, end, searchEle));
        System.out.println(lastOccurenceOfAnElement(input, start, end, searchEle));
    }

    private static int firstOccurenceOfAnElement(List<Integer> input, int start, int end, int searchEle) {

        int result = -1;
        while (start <= end) {

            int mid = start + (end - start)/2;

            // if we find the element, keep the index stored in a result as this can be a probable solution
            if (input.get(mid) == searchEle) {
                result = mid;
                end = mid - 1;
            } else if (input.get(mid) > searchEle) {
                end = mid - 1;;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private static int lastOccurenceOfAnElement(List<Integer> input, int start, int end, int searchEle) {

        int result = -1;
        while (start <= end) {

            int mid = start + (end - start)/2;

            if (input.get(mid) == searchEle) {
                result = mid;
                start = mid + 1; // only this line changes
            } else if (input.get(mid) > searchEle) {
                end = mid - 1;;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}
