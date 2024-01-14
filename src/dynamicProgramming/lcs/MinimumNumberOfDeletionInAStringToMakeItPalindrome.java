package dynamicProgramming.lcs;

/**
 * https://youtu.be/CFwCCNbRuLY?si=JCvRbky9_knTr2y6
 * Minimum number of deletions to make a string palindrome
 * Given a string of size ‘n’. The task is to remove or delete minimum number of characters from the string so that the resultant string is palindrome.
 * Examples :
 * Input : aebcbda
 * Output : 2
 * Remove characters 'e' and 'd'
 * Resultant string will be 'abcba'
 * which is a palindromic string
 */
public class MinimumNumberOfDeletionInAStringToMakeItPalindrome {
    public static void main(String[] args) {

        String x = "aebcbda";
        String y = new StringBuilder(x).reverse().toString();
        int m = x.length(), n = y.length();
        int [][]matrix = new int[m + 1][n + 1];

        for (int i = 0; i < m+1; ++i) {
            for (int j = 0; j < n+1; ++j) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println(m - largestCommonSubString(x, y, m, n, matrix));
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
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        return matrix[m][n];
    }
}

