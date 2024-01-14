package dynamicProgramming.longestCommonSubSequence;

/**
 * https://youtu.be/823Grn4_dCQ?si=SW56IRQlnksxMuLe
 * Shortest Common SuperSequence
 * Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
 * Examples:*
 * Input:   str1 = "geek",  str2 = "eke"
 * Output: "geeke"
 */
public class ShortestSuperSequenceLength {
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
        // find LCS and then subtract from the sum of the length of the strings
        System.out.println(m + n - longestCommonSubsequenceRecursive(x, y, m, n, matrix));
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

