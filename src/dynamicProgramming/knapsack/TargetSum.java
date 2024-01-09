package dynamicProgramming.knapsack;

import java.util.Arrays;

/**
 * Link: https://youtu.be/aycn9KO8_Ls?si=yUw_SODgG8wglg_D
 * Given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 */
public class TargetSum {
    public static void main(String[] args) {

        int []nums = new int[]{2, 3, 5, 6, 8, 10};
        int sum = 2;
        System.out.println(targetSum(nums, sum));
        nums = new int[]{1, 1, 1, 1, 1};
        sum = 3;
        System.out.println(targetSum(nums, sum));
    }

    private static int targetSum(int[] nums, int sum) {
        int arraySum = Arrays.stream(nums).sum();
        int diff = (arraySum + sum)/2;

        return countOfSubSetsWithGivenNumber(nums, diff);
    }

    private static int countOfSubSetsWithGivenNumber(int[] nums, int diff) {
        int n = nums.length;
        int[][] matrix = new int[n+1][diff+1];

        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < diff + 1; ++j) {
                if (i==0) {
                    matrix[i][j] = 0;
                }
                if (j==0) {
                    matrix[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < diff + 1; ++j) {
                if (nums[i-1] <= j) {
                    matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-nums[i-1]];
                } else {
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }

        return matrix[n][diff];
    }
}
