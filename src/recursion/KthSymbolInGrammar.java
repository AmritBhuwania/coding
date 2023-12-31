package recursion;

/**
 * Link: https://youtu.be/5P84A0YCo_Y?si=MFAhhql-35qZ6quB
 * Leetcode: https://leetcode.com/problems/k-th-symbol-in-grammar/
 */
public class KthSymbolInGrammar {

    public static void main(String[] args) {
        System.out.println(solve(4,1));
    }

    private static int solve(int n, int k) {

        if (n == 1 && k == 1) {
            return 0;
        }

        int length = (int) Math.pow(2, n-1);
        int mid = length/2;

        if (k <= mid) {
            return solve(n-1, k);
        } else {
            int ans = solve(n-1, k-mid);
            return 1 - ans;
        }




    }
}
