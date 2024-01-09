package dynamicProgramming.knapsack;

/**
 * https://youtu.be/UmMh7xp07kY?si=TE9WaXRT8Gwzgkz3
 * Equal Sum Partition Problem:
 * Partition problem is to determine whether a given set can be partitioned into two subsets
 * such that the sum of elements in both subsets is same.
 * Examples:
 * arr[] = {1, 5, 11, 5}
 * Output: true
 * The array can be partitioned as {1, 5, 5} and {11}
 */
public class EqualSumPartitionProblem {

    public static void main(String[] args) {

        int []nums = new int[]{1,5, 11, 5};
        System.out.println(isEqualSumPartitionPossible(nums));

    }

    private static boolean isEqualSumPartitionPossible(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum = sum/2;

        boolean[][] matrix = new boolean[n + 1][sum + 1];

        // base condition is equivalent to filling the initialization steps
        for (int i = 0; i < n+1; ++i) {
            for (int j = 0; j < sum+1; ++j) {
                if (i == 0) {
                    matrix[i][j] = false;
                }
                if (j == 0) {
                    matrix[i][j] = true;
                }
            }
        }

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < sum + 1; ++j) {
                if (nums[i-1] <= j) {
                    matrix[i][j] = matrix[i - 1][j - nums[i - 1]] || matrix[i - 1][j];
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
