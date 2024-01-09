package dynamicProgramming.knapsack;

/**
 * Link: https://youtu.be/_gPcYovP7wc?si=rie7KMMh8Pu3pK0Z
 * Subset Sum Problem(Dynamic Programming)
 * Given a set of non-negative integers, and a value sum,
 * determine if there is a subset of the given set with sum equal to given sum.
 * Example:
 * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class SubsetSumProblem {

    public static void main(String[] args) {
        int [] nums = new int[]{3, 34, 4, 12, 5, 2};
        int target = 39;
        int n = nums.length;

        System.out.println(checkForSubsetSum(nums, target, n));
        System.out.println(checkForSubsetSum2(nums, target, n));
    }

    private static boolean checkForSubsetSum(int[] nums, int target, int n) {

        int[][] matrix = new int[n + 1][target + 1];
        boolean isTargetFound = false;

        // base condition is equivalent to filling the initialization steps
        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j <= target + 1; ++j) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // start a loop instead of recursive calls.
        // just replace n with i and W with j everywhere
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < target + 1; ++j) {

                if (nums[i - 1] <= j) {
                    matrix[i][j] = Math.max(nums[i - 1] + matrix[i - 1][j - nums[i - 1]],
                            matrix[i - 1][j]);

                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }

                if (matrix[i][j] == target) {
                    isTargetFound = true;
                    break;
                }
            }
        }

        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < target + 1; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(matrix[n][target]);
        return isTargetFound;
    }

    private static boolean checkForSubsetSum2(int[] nums, int target, int n) {

        boolean[][] matrix = new boolean[n + 1][target + 1];
        // base condition is equivalent to filling the initialization steps
        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < target + 1; ++j) {
                // i == 0  means nums array does not have any element
                if (i == 0) {
                    matrix[i][j] = false;
                }
                // j == 0 means max target is zero. So, an empty set will always be an answer
                if (j == 0) {
                    matrix[i][j] = true;
                }
            }
        }

        // consider the target as max weight in knapsack
        // consider the nums array as weight array in knapsack
        // since, value array is not present, directly ignore its usage.
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < target + 1; ++j) {

                if (nums[i - 1] <= j) {
                    matrix[i][j] = matrix[i - 1][j - nums[i - 1]] || matrix[i - 1][j];

                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
        return matrix[n][target];
    }
}
