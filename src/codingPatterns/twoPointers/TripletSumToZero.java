package codingPatterns.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

	public static void main(String[] args) {

		System.out.println(TripletSumToZero.findTriplets(new int[] {-1, 0, 1, 2, -1, -4}));
	}


	private static List<List<Integer>> findTriplets(int[] ar) {

		Arrays.sort(ar);
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < ar.length -2 ; i++) {
			if (i > 0 && ar[i] == ar[i-1]) {
				continue;
		}
			findPair (ar, -ar[i], i + 1, ans);
		}

		return ans;
	}


	private static void findPair(int[] ar, int sum, int left, List<List<Integer>> ans) {

		int windowStart = left;
		int windowEnd = ar.length-1;

		while (windowStart < windowEnd) {

			if (ar[windowEnd] + ar[windowStart] == sum) {
				ans.add(Arrays.asList(-sum, ar[windowEnd], ar[windowStart]));
				windowEnd--;
				windowStart++;
				while (windowStart < windowEnd && ar[windowStart] == ar[windowStart-1]) {
					windowStart++;
				}
				while (windowStart < windowEnd && ar[windowEnd] == ar[windowEnd + 1]) {
					windowEnd--;
				}
			} else if (ar[windowEnd] + ar[windowStart] > sum) {
				windowEnd--;
			} else {
				windowStart++;
			}
			//System.out.println("windowEnd: " + windowEnd + ", windowStart: " + windowStart);
		}
	}

}
