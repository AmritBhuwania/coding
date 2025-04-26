package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] ar = new int[] {1,3,2};
        int n = ar.length;
        List<Integer> ans = new ArrayList<>(); // holding/working data structure(ds)
        int sum = 0;

        subsetSum(0, ar, ans, n, sum);
        System.out.println(Arrays.asList(ans));
    }

    private static void subsetSum(int index, int[] ar, List<Integer> ans, int n, int sum) {

        if (index == n) {
            ans.add(sum);
            return;
        }

        sum += ar[index];
        subsetSum(index + 1, ar, ans, n, sum);
        sum -= ar[index];
        subsetSum(index + 1, ar, ans, n, sum);
    }
}
