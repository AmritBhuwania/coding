package dynamicProgramming.lcs;

/**
 * Link: https://youtu.be/4Urd0a0BNng?si=QmZKrmEKnCA0DnkJ
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.
 */
public class LongestCommonSubsequenceRecursive {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfh";
        int m = x.length();
        int n = y.length();
        System.out.println(longestCommonSubsequenceRecursive(x, y, m, n));
    }

    private static int longestCommonSubsequenceRecursive(String x, String y, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        // character matched
        if (x.charAt(m-1) == y.charAt(n-1)) {
            // since character matched, increment counter by 1 and decrease size of both string by 1
            return 1 + longestCommonSubsequenceRecursive(x, y, m-1, n-1);
        } else {
            // since character did not match, check by decreasing size of either string by 1
            return Math.max(longestCommonSubsequenceRecursive(x, y, m, n-1),
                    longestCommonSubsequenceRecursive(x, y, m-1, n));
        }
    }
}
