package recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] ar = new int[] {2,6,1,4,7,5,3,4};
        quickSort(ar, 0, ar.length-1);
        System.out.println(Arrays.toString(ar));
    }

    private static void quickSort(int[] ar, int low, int high) {

        if (low < high) {
            int partitionIndex = partition(ar, low, high);
            quickSort(ar, low, partitionIndex - 1);
            quickSort(ar, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] ar, int low, int high) {
        int pivot = ar[low];
        int i = low;
        int j = high;

        while(i < j) {
            while (ar[i] <= pivot && i < high) {
                ++i;
            }

            while (ar[j] > pivot && j > low) {
                --j;
            }

            if (i < j) {
                swap(ar, i, j);
            }
        }
        swap(ar, low, j);
        return j;
    }

    private static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
