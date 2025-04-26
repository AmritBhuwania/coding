package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountNumberOfSubsequencesWithSumK {
    public static void main(String[] args) {
        int[] ar = new int[] {1,2,1};
        int n = ar.length;
        int k = 2;
        int sum = 0;

        System.out.println("Number of subsequences: " + countNumberOfSubsequencesWithSumK(0, ar, n, k, sum));
    }

    private static int countNumberOfSubsequencesWithSumK(int index, int[] ar, int n, int k, int sum) {

        if (index == n) {
            if (sum == k) {
                //System.out.println(Collections.singletonList(ds));
                return 1;
            }
            return 0;
        }

        // take or pick the particular index into the subsequence
        //ds.add(ar[index]);
        sum += ar[index];
        int left = countNumberOfSubsequencesWithSumK(index+1, ar, n, k, sum);

        // do not pick the particular index into the subsequence,
        // this element is not added to the subsequence
        // (the index element which was previously added, will get removed)
        //ds.removeLast();
        sum -= ar[index];
        int right = countNumberOfSubsequencesWithSumK(index+1, ar, n, k, sum);

        return left + right;

    }
}
