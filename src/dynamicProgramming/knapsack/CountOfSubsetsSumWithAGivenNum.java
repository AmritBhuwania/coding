package dynamicProgramming.knapsack;

/**
 * Link: https://youtu.be/F7wqWbqYn9g?si=ZQHm6f8EgbyTjZQF
 * Count of subsets sum with a Given sum
 * Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
 * Example:
 * Input: arr[] = {1, 2, 3, 3}, X = 6
 * Output: 3
 * All the possible subsets are {1, 2, 3},
 * {1, 2, 3} and {3, 3}
 */
public class CountOfSubsetsSumWithAGivenNum {

    public static void main(String[] args) {

        int []nums = new int[]{2, 3, 5, 6, 8, 10};
        int sum = 17;
        System.out.println(isEqualSumPartitionPossible(nums, sum));
    }

    private static int isEqualSumPartitionPossible(int[] nums, int sum) {

        int n = nums.length;
        int[][] matrix = new int[n + 1][sum + 1];

        // base condition is equivalent to filling the initialization steps
        for (int i = 0; i < n+1; ++i) {
            for (int j = 0; j < sum+1; ++j) {
                if (i == 0) {
                    matrix[i][j] = 0;
                }
                if (j == 0) {
                    matrix[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < sum + 1; ++j) {
                if (nums[i-1] <= j) {
                    matrix[i][j] = matrix[i - 1][j - nums[i - 1]] + matrix[i - 1][j];
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }

        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < sum + 1; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return matrix[n][sum];
    }
}
