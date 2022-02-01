package heap;

import java.util.PriorityQueue;

/**
 * @author amrit
 * 
 * Link: https://youtu.be/J8yLD-x7fBI
 * Given an unsorted array and two numbers x and k, find k closest values/elements to x.
   Input : arr[] = {10, 2, 14, 4, 7, 6}, x = 5, k = 3
 * Output: 4, 7, 6 [in any order]
 */
public class KClosestNumbers {

	public static void main(String[] args) {

		int k = 3;
		int x = 5; // element to find the answers closest to
		int[] ar = {10, 2, 14, 4, 7, 6};

		kSorted(ar, k, x);
	}

	static void kSorted(int [] ar, int k, int x) {

		// Comparator override on key in descending order
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey());

		Pair p; // A utility Pair class in same package
		for (int i = 0; i < ar.length; i++) {

			/*
			 * Make a pair array. Key is absolute diff of current element and the input element.
			 * Value stores the original current element
			 */
			p = new Pair(Math.abs(ar[i]-x), ar[i]);

			maxHeap.add(p); // comparator functionality used here

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		// do not use minHeap.size() instead of k for condition check,
		// since dynamic size(since, poll is happening)
		for (int i = 0; i < k; i++) {
			System.out.println(maxHeap.poll().getValue());
		}
	}

}
