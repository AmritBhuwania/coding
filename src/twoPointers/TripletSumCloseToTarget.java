package twoPointers;

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


	private static void findPair(int[] ar, int sum, int left, List<Integer> ans, int diff) {

		int windowStart = left;
		int windowEnd = ar.length-1;
		int sumNow = 0;

		while (windowStart < windowEnd) {
			
			sumNow = Math.abs(Math.abs(ar[windowEnd] + ar[windowStart] + sum) - diff);

			if (sumNow < answer) {
				answer = Math.abs(ar[windowEnd] + ar[windowStart] + sum);
				minimumDiff = Math.abs(ar[windowEnd] + ar[windowStart] + sum);
				ans = (Arrays.asList(sum, ar[windowStart], ar[windowEnd]));
				System.out.println("Root element : " + sum + ", array: " + ans);
				windowEnd--;
				windowStart++;
			} else if (ar[windowEnd] + ar[windowStart] > sum) {
				windowEnd--;
			} else {
				windowStart++;
			}
			//System.out.println("windowEnd: " + windowEnd + ", windowStart: " + windowStart);
		}
		System.out.println(answer);
	}
}
