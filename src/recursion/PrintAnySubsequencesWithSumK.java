package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAnySubsequencesWithSumK {
    public static void main(String[] args) {
        int[] ar = new int[] {1,2,1};
        int n = ar.length;
        int k = 2;
        List<Integer> ds = new ArrayList<>(); // holding/working data structure(ds)
        int sum = 0;

        printAnySubsequencesWithSumK(0, ar, ds, n, k, sum);
    }

    private static boolean printAnySubsequencesWithSumK(int index, int[] ar, List<Integer> ds, int n, int k, int sum) {

        if (index == n) {
            if (sum == k) {
                System.out.println(Collections.singletonList(ds));
                return true;
            }
            return false;
        }

        // take or pick the particular index into the subsequence
        ds.add(ar[index]);
        sum += ar[index];
        if (printAnySubsequencesWithSumK(index+1, ar, ds, n, k, sum)) return true;

        // do not pick the particular index into the subsequence,
        // this element is not added to the subsequence
        // (the index element which was previously added, will get removed)
        sum -= ar[index];
        ds.removeLast();
        if (printAnySubsequencesWithSumK(index+1, ar, ds, n, k, sum)) return true;

        return false;

    }
}
