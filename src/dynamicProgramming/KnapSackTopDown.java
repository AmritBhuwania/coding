package dynamicProgramming;

public class KnapSackTopDown {

    public static void main(String[] args) {
        int profit[] = new int[]{60, 100, 120, 80, 200, 5};
        int weight[] = new int[]{10, 20, 30, 10, 25, 5};
        int W = 50;
        int n = profit.length;
        int[][] matrix = new int[n + 1][W + 1];

        // base condition is equivalent to filling the initialization steps
        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < W + 1; ++j) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // start a loop instead of recursive calls.
        // just replace n with i and W with j everywhere
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < W + 1; ++j) {

                if (weight[i - 1] <= j) {
                    matrix[i][j] = Math.max(profit[i - 1] + matrix[i - 1][j - weight[i - 1]],
                            matrix[i - 1][j]);

                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }

        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < W + 1; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(matrix[n][W]);

    }
}
