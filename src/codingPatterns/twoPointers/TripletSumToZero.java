package codingPatterns.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

	public static void main(String[] args) {

		System.out.println(TripletSumToZero.findTriplets(new int[] {-3,-4, 0, 3,-6, 1, 5, -2,3, -3, 2, 0, 2,-6, 3, 5, 1,8}));
	}


	private static List<List<Integer>> findTriplets(int[] ar) {

		Arrays.sort(ar);
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < ar.length -2 ; i++) {
			if (ar[i] == ar[i+1]) {
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
