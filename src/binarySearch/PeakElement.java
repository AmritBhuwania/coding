package binarySearch;

import java.util.List;

public class PeakElement {

    public static void main(String[] args) {

        List<Integer> input = List.of(1, 2, 4, 9, 8, 7, 6, 4);
        List<Integer> input2 = List.of(1,2,5,6,7,8,9,10);
        List<Integer> input3 = List.of(10, 8, 7, 6, 5, 4, 3);
        System.out.println(binarySearch(input));
        System.out.println(binarySearch(input2));
        System.out.println(binarySearch(input3));
    }

    private static int binarySearch(List<Integer> input) {

        int start = 0, end = input.size() - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (mid - 1 >= 0 && input.get(mid) > input.get(mid - 1) &&
                    mid + 1 < input.size() && input.get(mid) > input.get(mid + 1)) {
                return mid;

                // check for array bound and the left side element as the element can be at (i-1) index
            } else if (mid == 0 && input.get(mid) > input.get(mid + 1)) {
                return mid;

                // check for array bound and the right side element as the element can be at (i+1) index
            } else if (mid == input.size() - 1 && input.get(mid) > input.get(mid - 1) ) {
                return mid;

            } else if (input.get(mid) > input.get(mid - 1)) {
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
