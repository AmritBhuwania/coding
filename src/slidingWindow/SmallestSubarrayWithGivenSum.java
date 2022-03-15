package slidingWindow;
public class SmallestSubarrayWithGivenSum {

	public static void main(String[] args) {

		int result = minSubArray(10,new int[] {6,4,1,3,12});
		System.out.println(result);
	}

	private static int minSubArray(int max, int[] arr) {

		int windowStart = 0;
		int windowSum = 0;
		int len = Integer.MAX_VALUE;
		int length = Integer.MAX_VALUE;;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			System.out.println(windowSum);
			while(windowSum >= max) {
				System.out.println("here: " + windowSum);
				windowSum -= arr[windowStart];
				len = windowEnd - windowStart + 1;
				windowStart++;
				System.out.println("here: " + windowSum + ", len: " + len);
				length = Math.min(len, length);

			}

		}
		return length;
	}
}
