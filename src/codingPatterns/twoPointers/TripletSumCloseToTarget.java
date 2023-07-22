package codingPatterns.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumCloseToTarget {

	static int minimumDiff = Integer.MAX_VALUE;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) {

		System.out.println("Final ans: " + TripletSumCloseToTarget.findTriplets(new int[] {-3, -1, 1, 2}, 1));
	}

	private static int findTriplets(int[] ar, int diff) {

		Arrays.sort(ar);
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < ar.length -2 ; i++) {
			if (ar[i] == ar[i+1]) {
				continue;
			}
			findPair (ar, ar[i], i + 1, ans, diff);
		}

		return answer;	
	}


	private static void findPair(int[] ar, int ele, int left, List<Integer> ans, int diff) {

		int windowStart = left;
		int windowEnd = ar.length-1;
		int targetDiff = 0;

		while (windowStart < windowEnd) {

			targetDiff = diff - (ar[windowEnd] + ar[windowStart] + ele);

			if (targetDiff == 0) {
				System.out.println(diff - targetDiff);
			}

			if (Math.abs(targetDiff) < Math.abs(minimumDiff)) {
				minimumDiff = targetDiff;
			}

			if (targetDiff > 0) {
				windowStart++;
			} else {
				windowEnd--;
			}
		}
		System.out.println(diff - minimumDiff);
	}
}
