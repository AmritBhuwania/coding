package dynamicProgramming.longestCommonSubSequence;

/**
 * Link: https://youtu.be/4Urd0a0BNng?si=QmZKrmEKnCA0DnkJ
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.
 */
public class LongestCommonSubsequenceMemoization {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfh";
        int m = x.length();
        int n = y.length();

        int [][]matrix = new int[m+1][n+1];
        for (int i = 0; i < m+1; ++i) {
            for (int j = 0; j < n+1; ++j) {
                matrix[i][j]=-1;
            }

        }
        System.out.println(longestCommonSubsequenceRecursive(x, y, m, n, matrix));
    }

    private static int longestCommonSubsequenceRecursive(String x, String y, int m, int n, int[][]matrix) {

        if (m == 0 || n == 0) {
            return 0;
        }

        // if previously calculated value found in matrix, return directly from matrix
        if (matrix[m][n] != -1) {
            return matrix[m][n];
        }

        // character matched
        if (x.charAt(m-1) == y.charAt(n-1)) {
            // since character matched, increment counter by 1 and decrease size of both string by 1
            matrix[m][n] =  1 + longestCommonSubsequenceRecursive(x, y, m-1, n-1, matrix);
        } else {
            // since character did not match, check by decreasing size of either string by 1
            matrix[m][n] =  Math.max(longestCommonSubsequenceRecursive(x, y, m, n-1, matrix),
                    longestCommonSubsequenceRecursive(x, y, m-1, n, matrix));
        }
        return matrix[m][n];
    }
}
