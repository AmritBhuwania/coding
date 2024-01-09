package dynamicProgramming.unboundedKnapsack;

public class CoinChangeMinimumNumberOfCoins {
    public static void main(String[] args) {
        int []coins = new int[]{1,2,3};
        int n = 8;
        System.out.println(minimumNumberOfCoins(coins, n));
        coins = new int[]{1,2,3};
        n = 19;
        System.out.println(minimumNumberOfCoins(coins, n));
    }

    private static int minimumNumberOfCoins(int[] coins, int n) {
        int [][]matrix = new int[coins.length+1][n+1];
        for (int i = 0; i < coins.length + 1; ++i) {
            for (int j = 0; j < n + 1; ++j) {
                if (i == 0) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
                if (j == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < coins.length + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (coins[i-1] <= j) {
                    // Math.Min since we want to find minimum coins
                    // +1 since we have included/selected a coin
                    matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-coins[i-1]] + 1);
                }
                else {
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }
        return matrix[coins.length][n];
    }
}
