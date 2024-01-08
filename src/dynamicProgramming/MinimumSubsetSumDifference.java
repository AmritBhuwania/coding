package dynamicProgramming;

/**
 * Link: https://youtu.be/-GtpxG6l_Mc?si=_D7rJZ0z4w9FgCpJ
 * Sum of subset differences
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between
 * their sums is minimum. If there is a set S with n elements, then if we assume Subset1 has m elements,
 * Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 * Example:
 * Input:  arr[] = {1, 6, 11, 5}
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * Subset2 = {11}, sum of Subset2 = 11
 */
public class MinimumSubsetSumDifference {

    public static void main(String[] args) {

        int []nums = new int[]{1, 2, 7};
        System.out.println(minimumSubsetSumDifference(nums));
        nums = new int[]{1, 6, 11, 5};
        System.out.println(minimumSubsetSumDifference(nums));
    }

    private static int minimumSubsetSumDifference(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int num: nums) {
            sum += num;
        }

        boolean[] lastRow = findSubSetSum(nums, sum, nums.length);

        for (int i = 0; i <= lastRow.length/2; ++i) {
            if (lastRow[i]) {
                min = Math.min(min, sum - (2*i));
            }
        }
        return Math.abs(min);

    }

    private static boolean [] findSubSetSum(int[] nums, int sum, int n) {
        boolean [][] matrix = new boolean[n+1][sum+1];

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

        for (int i = 1; i < n+1; ++i) {
            for (int j = 1; j < sum + 1; ++j) {
                if (nums[i-1] <= j) {
                    matrix[i][j] = matrix[i-1][j] || matrix[i-1][j-nums[i-1]];
                } else {
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }

        return matrix[n];
    }
}
