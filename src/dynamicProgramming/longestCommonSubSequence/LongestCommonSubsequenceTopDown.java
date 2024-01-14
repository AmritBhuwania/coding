package dynamicProgramming.longestCommonSubSequence;

/**
 * Link: https://youtu.be/hR3s9rGlMTU?si=QN2yN4fmF1CxEj3M
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.
 */
public class LongestCommonSubsequenceTopDown {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfh";
        int m = x.length();
        int n = y.length();

        int [][]matrix = new int[m+1][n+1];
        for (int i = 0; i < m+1; ++i) {
            for (int j = 0; j < n+1; ++j) {
               if (i == 0 || j == 0) {
                   matrix[i][j]=0;
               }
            }
        }
        System.out.println(longestCommonSubsequenceRecursive(x, y, m, n, matrix));
    }

    private static int longestCommonSubsequenceRecursive(String x, String y, int m, int n, int[][]matrix) {

        for (int i = 1; i < m+1; ++i) {
            for (int j = 1; j < n + 1; ++j) {

                // character matched
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                }
            }
        }
        for (int i = 0; i < m+1; ++i) {
            for (int j = 0; j < n+1; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return matrix[m][n];
    }
}
