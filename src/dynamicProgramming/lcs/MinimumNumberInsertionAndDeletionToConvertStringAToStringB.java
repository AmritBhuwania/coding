package dynamicProgramming.lcs;

/**
 * https://youtu.be/-fx6aDxcWyg?si=44tEDgIRRLPcVqEc
 * Minimum number of deletions and insertions to transform one string into another
 * Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
 * Example:
 * Input : str1 = "geeksforgeeks", str2 = "geeks"
 * Output : Minimum Deletion = 8
 *          Minimum Insertion = 0
 */
public class MinimumNumberInsertionAndDeletionToConvertStringAToStringB {

    public static void main(String[] args) {
        String x = "heap";
        String y = "pea";
        int m = x.length();
        int n = y.length();

        int[][] matrix = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; ++i) {
            for (int j = 0; j < n + 1; ++j) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        int longestCommonSubsequenceLength = longestCommonSubsequenceRecursive(x, y, m, n, matrix);
        int removalCount = m - longestCommonSubsequenceLength;
        int additionCount = n - longestCommonSubsequenceLength;
        System.out.println("removalCount: " + removalCount + ", additionCount: " + additionCount);

        x = "geeksforgeeks";
        y = "geeksb";
        m = x.length();
        n = y.length();

        matrix = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; ++i) {
            for (int j = 0; j < n + 1; ++j) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        longestCommonSubsequenceLength = longestCommonSubsequenceRecursive(x, y, m, n, matrix);
        removalCount = m - longestCommonSubsequenceLength;
        additionCount = n - longestCommonSubsequenceLength;
        System.out.println("removalCount: " + removalCount + ", additionCount: " + additionCount);


    }

    private static int longestCommonSubsequenceRecursive(String x, String y, int m, int n, int[][] matrix) {

        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {

                if (x.charAt(i-1) == y.charAt(j-1)) {
                    matrix[i][j] = 1 + matrix[i-1][j-1];
                } else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        for (int i = 0; i < m + 1; ++i) {
            for (int j = 0; j < n + 1; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix[m][n];
    }
}
