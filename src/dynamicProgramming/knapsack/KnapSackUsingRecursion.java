package dynamicProgramming.knapsack;

public class KnapSackUsingRecursion {

    public static void main(String[] args) {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = profit.length;

        System.out.println(knapsack(weight, profit, W, n));
    }

    private static int knapsack(int[] weight, int[] profit, int w, int n) {

        if (n == 0 || w == 0) {
            return 0;
        }

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        if (weight[n-1] <= w) {
            return Math.max(profit[n-1] + knapsack(weight, profit, w - weight[n-1], n-1),
                    knapsack(weight, profit, w , n-1));

        } else {
            // If weight of the nth item is more than Knapsack capacity W,
            // then this item cannot be included in the optimal solution
            return knapsack(weight, profit, w , n-1);
        }
    }
}
