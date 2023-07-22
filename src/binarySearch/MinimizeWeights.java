package binarySearch;

/*
 * Given weights in an array and maximum num of days for work,
 * minimize the maximum weight to be carried each day
 * so that the complete weight can be loaded within required number of days.
 */

public class MinimizeWeights {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,5,5,6,7,8,9,10};
		int maxNumOfDays = 5;
		int ans = findMinWeight(nums, maxNumOfDays);
		System.out.println(ans);
	}

	static int findMinWeight(int[] nums, int maxDaysAllowed) {

		int days = 1;
		int start = 0;
		int end = 0;

		for (int i = 0; i < nums.length; i++) {
			start = Math.max(start, nums[i]);
			end += nums[i];
		}

		while (start < end) {

			/*
			 * Start with a weight which is half of the minimum and total weights
			 */
			int mid = start + (end-start)/2;

			int sum = 0;
			days = 1;

			for (int num : nums) {
				if (sum + num <= mid) {
					sum += num;
				} else {
					sum = num;
					days++;
				}
			}

			if (days > maxDaysAllowed) {
				start = mid + 1; 
			} else {
				end = mid;
			}
		}

		System.out.println(days);
		return end;
	}
}
