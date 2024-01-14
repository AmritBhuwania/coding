package dynamicProgramming.longestCommonSubSequence;

/**
 * Link: https://youtu.be/hR3s9rGlMTU?si=QN2yN4fmF1CxEj3M
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.
 */
public class PrintingLongestCommonSubsequence {
    public static void main(String[] args) {
        String x = "BQPQBPQ";
        String y = "QPPBQ";
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
        System.out.println(printingLongestCommonSubsequence(x, y, m, n, matrix));

        String [][]dp = new String[m+1][n+1];
        for (int i = 0; i < m+1; ++i) {
            for (int j = 0; j < n+1; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j]="";
                }
            }
        }
        System.out.println(printingLongestCommonSubsequence2(x, y, m, n, dp));
    }

    private static int printingLongestCommonSubsequence(String x, String y, int m, int n, int[][]matrix) {

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

        StringBuilder stringBuilder = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (x.charAt(i-1) == y.charAt(j-1)) {
                stringBuilder.append(x.charAt(i-1));
                --i;
                --j;
            } else {
                if (matrix[i-1][j] > matrix[i][j-1]) {
                    --i;
                } else {
                    --j;
                }
            }
        }

        for (i = 0; i < m+1; ++i) {
            for (j = 0; j < n+1; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(stringBuilder.reverse().toString());
        return matrix[m][n];
    }

    private static String printingLongestCommonSubsequence2(String x, String y, int m, int n, String[][]matrix) {

        for (int i = 1; i < m+1; ++i) {
            for (int j = 1; j < n + 1; ++j) {

                // character matched, directly add the character in matrix
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + x.charAt(i - 1);
                } else {
                    if (matrix[i][j - 1].length() >= matrix[i - 1][j].length()) {
                        matrix[i][j] = matrix[i][j - 1];
                    } else {
                        matrix[i][j] = matrix[i-1][j];
                    }
                }
            }
        }
        return matrix[m][n];
    }
}
