package dynamicProgramming.longestCommonSubSequence;

/**
 * https://youtu.be/HrybPYpOvz0?si=IGvQkBnEC2qX7r5J
 *
 * Longest Common Substring(Dynamic Programming)
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 * Examples:
 * Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
 * Output : 5
 * The longest common substring is “Geeks” and is of length 5.
 */
public class LargestCommonSubString {

    public static void main(String[] args) {

        String x = "gbcdefg";
        String y = "abcdefg";
        int m = x.length(), n = y.length();
        int [][]matrix = new int[m + 1][n + 1];

        for (int i = 0; i < m+1; ++i) {
            for (int j = 0; j < n+1; ++j) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println(largestCommonSubString(x, y, m, n, matrix));
        for (int i = 0; i < m+1; ++i) {
            for (int j = 0; j < n+1; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int largestCommonSubString(String x, String y, int m, int n, int[][] matrix) {

        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    matrix[i][j] = 1 + matrix[i-1][j-1];
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix[m][n];
    }
}
