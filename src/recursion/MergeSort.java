package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] ar = new int[] {2,6,1,7,5,3,4};
        mergeSort(ar, 0, ar.length-1);
        System.out.println(Arrays.toString(ar));

    }

    private static void mergeSort(int[] ar, int low, int high) {

        if (low == high)  return;
        
        int mid = (low + (high - low)/2);
        mergeSort(ar, low, mid);
        mergeSort(ar, mid + 1, high);

        merge(ar, low, mid, high);
    }

    private static void merge(int[] ar, int low, int mid, int high) {

        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (ar[left] <= ar[right]) {
                temp.add(ar[left++]);
            } else {
                temp.add(ar[right++]);
            }
        }

        while (left <= mid) {
          temp.add(ar[left++]);
        }

        while (right <= high) {
           temp.add(ar[right++]);
        }

        /*
          why temp[i-low]. Here's the explanation.

          Because temp array always starts from index 0. Since it is always created in every call,
          we use i-low. Low and high can be any index because it is recursive.
          Let's say merge is called for 3rd to 6th index So we will have to replace arr 3rd to 6th index
          with sorted values and sorted values are in temp but are from 0 index.
          So we start from low to high, and we subtract (i) with low to make 0.
          Take above example the copy loop will start from 3 and will go till 6.
          So, (i) will be 3 and low will be 3 as well so subtracting both will be 0.
          And we are extracting 0th value from temp and adding it at the 3rd index of arr.
         */
        for (int i = low; i <= high; i++) {
            ar[i] = temp.get(i - low);
        }
    }
}
