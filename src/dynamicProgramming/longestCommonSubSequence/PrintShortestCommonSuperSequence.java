package dynamicProgramming.longestCommonSubSequence;

/**
 * https://youtu.be/VDhRg-ZJTuc?si=uzLB4jfBPF_AO12A
 * Given two strings X and Y, print the shortest string that has both X and Y as subsequences. If multiple shortest supersequence exists, print any one of them.
 * Examples:
 * Input: X = "AGGTAB",  Y = "GXTXAYB"
 * Output: "AGXGTXAYB" OR "AGGXTXAYB"
 * OR Any string that represents shortest
 * supersequence of X and Y
 *
 * Input: X = "HELLO",  Y = "GEEK"
 * Output: "GEHEKLLO" OR "GHEEKLLO"
 * OR Any string that represents shortest
 * supersequence of X and Y
 */
public class PrintShortestCommonSuperSequence {
    public static void main(String[] args) {

        String x = "AGGTAB";
        String y = "GXTXAYB";
        int m = x.length();
        int n = y.length();
        String [][]matrix = new String[m+1][n+1];
        int [][]matrix2 = new int[m+1][n+1];

        for (int i = 0; i < m+1; ++i) {
            for (int j = 0; j < n+1; ++j) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = "";
                    matrix2[i][j] = 0;
                }
            }
        }
        System.out.println(printShortestCommonSuperSequence(x, y, m, n, matrix));
        System.out.println(printShortestCommonSuperSequence2(x, y, m, n, matrix2));
    }

    private static String printShortestCommonSuperSequence(String x, String y, int m, int n, String[][] matrix) {

        // find longest subsequence string
        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1] + x.charAt(i-1);
                } else {
                    if (matrix[i-1][j].length() > matrix[i][j-1].length()) {
                        matrix[i][j] = matrix[i-1][j];
                    } else {
                        matrix[i][j] = matrix[i][j-1];
                    }
                }
            }
        }

        for (int i = 0; i < m+1; ++i) {
            for (int j = 0; j < n + 1; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(matrix[m][n]);

        // remove longest subsequence after combining both strings
        StringBuilder s = new StringBuilder(x).append(y);
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (j < matrix[m][n].length() && s.charAt(i) == matrix[m][n].charAt(j)) {
                ++j;
            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();

    }

    private static String printShortestCommonSuperSequence2(String x, String y, int m, int n, int[][] matrix) {

        int i, j;
        for ( i = 1; i < m + 1; ++i) {
            for (j = 1; j < n + 1; ++j) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                } else {
                    if (matrix[i-1][j] > matrix[i][j-1]) {
                        matrix[i][j] = matrix[i-1][j];
                    } else {
                        matrix[i][j] = matrix[i][j-1];
                    }
                }
            }
        }

        i = m;
        j = n;
        StringBuilder ans = new StringBuilder();
        while (i > 0 && j > 0) {
            if (x.charAt(i-1) == y.charAt(j-1)) {
                ans.append(x.charAt(i-1));
                --i;
                --j;
            } else {
                if (matrix[i][j-1] >= matrix[i-1][j]) {
                    ans.append(y.charAt(j-1));
                    --j;
                } else {
                    ans.append(x.charAt(i-1));
                    --i;
                }
            }
        }
        while (i > 0) {
            ans.append(x.charAt(i-1));
            --i;
        }

        while (j > 0) {
            ans.append(y.charAt(j-1));
            --j;
        }
        return ans.reverse().toString();
    }
}
