package dynamicProgramming.unboundedKnapsack;

/**
 * Link: https://youtu.be/I4UR2T6Ro3w?si=u3-zvHL30p2xPl43
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of
 * S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * Example:
 * for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 */
public class CoinChangeMaximumNumberOfWays {
    public static void main(String[] args) {
        int []coins = new int[]{1,2,3};
        int n = 4;
        System.out.println(maximumNumberOfWays(coins, n));
        coins = new int[]{1,2,3};
        n = 5;
        System.out.println(maximumNumberOfWays(coins, n));
    }

    private static int maximumNumberOfWays(int[] coins, int n) {
        int [][]matrix = new int[coins.length+1][n+1];
        for (int i = 0; i < coins.length + 1; ++i) {
            for (int j = 0; j < n + 1; ++j) {
                if (i == 0) {
                    matrix[i][j] = 0;
                }
                if (j == 0) {
                    matrix[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < coins.length + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (coins[i-1] <= j) {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-coins[i-1]];
                }
                else {
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }
        return matrix[coins.length][n];
    }
}
