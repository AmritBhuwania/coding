package dynamicProgramming.knapsack;

/**
 * https://youtu.be/fJbIuhs24zQ?si=CJ0L7HhbYVU8qPye
 *
 * Example:
 *  Given weights and values of n items, put these items in a knapsack of capacity W
 *  to get the maximum total value in the knapsack.
 *  In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights
 *  associated with n items respectively. Also given an integer W which represents knapsack capacity,
 *  find out the maximum value subset of val[] such that sum  of the weights of this subset is smaller than or equal to W.
 *  You cannot break an item, either pick the complete item, or don’t pick  it (0-1 property).
 */
public class KnapSackMemoization {

    public static void main(String[] args) {
        int profit[] = new int[] { 60, 100, 120, 80, 200, 5 };
        int weight[] = new int[] { 10, 20, 30, 10, 25, 5 };
        int W = 50;
        int n = profit.length;
        int [][] matrix = new int [n+1][W+1];
        for (int i = 0; i < n+1; ++i) {
            for (int j = 0; j< W+1; ++j) {
                matrix[i][j] = -1;
            }
        }
        System.out.println(knapsack(weight, profit, W, n, matrix));
        for (int i = 0; i < n+1; ++i) {
            for (int j = 0; j< W+1; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int knapsack(int[] weight, int[] profit, int w, int n, int[][] matrix) {

        if (n == 0 || w == 0) {
            return 0;
        }

        if (matrix[n][w] != -1) {
            return matrix[n][w];
        }

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        if (weight[n-1] <= w) {
            matrix[n][w] = Math.max(profit[n-1] + knapsack(weight, profit, w - weight[n-1], n-1, matrix),
                    knapsack(weight, profit, w , n-1, matrix));

        } else {
            // If weight of the nth item is more than Knapsack capacity W,
            // then this item cannot be included in the optimal solution
            matrix[n][w] = knapsack(weight, profit, w , n-1, matrix);
        }
        return matrix[n][w];
    }
}
