package codingPatterns.slidingWindow;

/**
 * Smallest Subarray with a given sum
 *
 * Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 * Example 1:
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
 */
public class SmallestSubarrayWithGivenSum {

	public static void main(String[] args) {

		int result = minSubArray(17,new int[] {16,4,1,3,12});
		System.out.println("Ans:" + result);
	}

	/**
	 * The time complexity of the above algorithm will be O(N). The outer for loop runs for all elements and
	 * the inner while loop processes each element only once, therefore the time complexity of the algorithm
	 * will be O(N+N) which is asymptotically equivalent to O(N).
	 * The algorithm runs in constant space O(1)
	 */

	private static int minSubArray(int max, int[] arr) {

		int windowStart = 0;
		int windowSum = 0;
		int length = Integer.MAX_VALUE;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			System.out.println(windowSum);

			// shrink window until windowSum is smaller than max
			while(windowSum >= max) {
				length = Math.min(windowEnd - windowStart + 1, length);
				windowSum -= arr[windowStart];
				windowStart++;
			}

		}
		return length;
	}
}
