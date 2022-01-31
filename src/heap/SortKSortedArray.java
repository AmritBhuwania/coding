package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author amrit
 * 
 * Given an array of n elements, where each element is at most k away from its 
 * target position, devise an algorithm that sorts in O(n log k) time.
 * For example, let us consider k is 2, an element at index 7(i) in the sorted array,
 * can be at indexes 5,6,7,8,9 in the given array. ie at (index 7 +- 2) or in range[i-k, i+k]
	Example:
	Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
	k = 3 
	Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
 */
public class SortKSortedArray {

	public static void main(String[] args) {

		int k = 3;
		int[] ar = {6, 5, 3, 2, 8, 10, 9};
		kSorted(ar, k);
		System.out.println(Arrays.toString(ar));

	}

	static void kSorted(int [] ar, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		int j = 0;
		for (int i = 0; i < ar.length; i++) {

			minHeap.add(ar[i]);
			if (minHeap.size() > k) {
				ar[j++] = minHeap.poll();
			}
		}

		// do not use minHeap.size() instead of k for condition check,
		// since dynamic size(since, poll is happening)
		for (int i = 0; i < k; i++) {
			ar[j++] = minHeap.poll();
		}
	}
}

