package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author amrit
 * Return K largest elements
 * Link: https://youtu.be/3DdP6Ef8YZM
 */

public class ReturnKLargestElements {

	public static void main(String[] args) {

		int k = 3;
		int[] ar = {6,8,9,-3,-5,0,-2,-1};
		System.out.println(kLargest(ar, k));

	}

	static List<Integer> kLargest(int [] ar, int k) {
		
		List<Integer> ans = new ArrayList<Integer>();

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < ar.length; i++) {

			minHeap.add(ar[i]);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		System.out.println(minHeap.size());
		
		// do not use minHeap.size() instead of k for condition check,
		// since dynamic size(since, poll is happening)
		for (int i = 0; i < k; i++) {
			ans.add(minHeap.poll());
		}
		
		return ans;
	}

}
