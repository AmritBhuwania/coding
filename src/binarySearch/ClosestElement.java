package binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * @author amrit
 * Find the closest element to the target element in a sorted array
 */
public class ClosestElement {

	public static void main(String[] args) {

		List<Integer> input = Arrays.asList(1,2,4,5,8,9);
		int index = closest(input, 0, input.size(), 9);
		System.out.println(input.get(index));
	}

	private static Integer closest(List<Integer> input, int start, int end, int target) {

		int mid = start + (end - start)/2;
		
		while (start < end) {

			if (input.get(mid) == target) {
				return mid;
			}

			else if (input.get(mid) > target) {
				// element closest can be between these 2 elements only
				if (input.get(mid - 1) < target) {
					if (Math.abs(input.get(mid) - target) >= Math.abs(input.get(mid) - target)) {
						return mid - 1;
					} else
						return mid;
				}
				return closest(input, start, mid - 1, target);
			}

			else {
				// element closest can be between these 2 elements only
				if (input.get(mid + 1) > target) {
					if (Math.abs(input.get(mid) - target) >= Math.abs(input.get(mid + 1) - target)) {
						return mid + 1;
					} else
						return mid;
				}
				return closest(input, mid + 1, end, target);
			}
		}

		return start;

	}
}
