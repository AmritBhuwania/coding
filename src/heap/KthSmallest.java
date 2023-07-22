package heap;

import java.util.PriorityQueue;

/**
 * @author amrit
 * Find the smallest kth element
 * Link : https://youtu.be/4BfL2Hjvh8g
 */
public class KthSmallest {

	public static void main(String[] args) {

		int k = 3;
		int[] ar = {6,8,9,-3,-5,0,-2,-1};
		System.out.println(kthSmallest(ar, k));

	}

	static int kthSmallest(int [] ar, int k) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		for (int i = 0; i < ar.length; i++) {

			maxHeap.add(ar[i]); // comparator functionality used here

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return maxHeap.peek();
	}

}
