package slidingWindow
;
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
				currSum-=js[windowStart];
			}
			System.out.println();
			
		}
		return maxSum;
	}
}
