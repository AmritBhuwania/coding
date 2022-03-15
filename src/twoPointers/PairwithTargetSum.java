package twoPointers;
public class PairwithTargetSum {


	public static void main(String[] args) {

		int[] result = pairwithTargetSum(10,new int[] {1,2,4,6,11});
		System.out.println(result[0] + " " + result[1]);
	}

	private static int[] pairwithTargetSum(int sum, int[] arr) {

		int startPointer = 0;
		int endPointer = arr.length -1;
		int result[] = new int[] {-1, -1};
		while (startPointer < endPointer) {
			int sumOfNumbers = arr[startPointer] + arr[endPointer];
			System.out.println("startPointer: " + startPointer + ", endPointer: " + endPointer + ", sum: " + sumOfNumbers);
			if (sumOfNumbers == sum) {
				result[0] = startPointer;
				result[1] = endPointer;
				System.out.println(result[0] + " " + result[1]);
				break;
			} else if (sumOfNumbers > sum) {
				endPointer--;
			} else {
				startPointer++;
			}
		}

		return result;
	}
}
