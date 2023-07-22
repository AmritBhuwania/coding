package codingPatterns.slidingWindow;

/**
 * Maximum Sum Subarray of Size K
 *
 * Given an array of positive numbers and a positive number ‘k’,
 * find the maximum sum of any contiguous subarray of size ‘k’.
 * Example 1:
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */
public class MaximumSumSubarrayOfSizeK {

	public static void main(String[] args) {

		int result = maxSubArray(3, new int[] {4,6,1,3,6});
		System.out.println(result);
	}

	private static int maxSubArray(int l, int[] js) {

		int windowStart = -1;
		int maxSum = 0;
		int currSum = 0;

		for (int i = 0; i < js.length; i++) {
			currSum += js[i];
			System.out.print(i + ": " + currSum + " ");

			if (i >= l-1) {
				if (currSum > maxSum) {
					maxSum = currSum;
				}
				System.out.print(" maxsum: " + maxSum);
				windowStart++;
				currSum -= js[windowStart];
			}
			System.out.println();

		}
		return maxSum;
	}
}
