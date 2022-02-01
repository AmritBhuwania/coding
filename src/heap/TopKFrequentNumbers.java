package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {

	public static void main(String[] args) {

		int k = 3;
		int[] ar = {6, 4, 10, 2, 14, 4, 4, 7, 6, 2, 14, 14};

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		// Frequency map
		for (int i = 0; i < ar.length; i++) {
			map.compute(ar[i], (key,val) -> val == null ? 1 : val + 1);
		}

		topKFrequent(map, k);

	}

	static void topKFrequent(Map<Integer, Integer> map, int k) {

		PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());

		Pair p; // A utility Pair class in same package
		for (Integer key : map.keySet()) {

			/*
			 * Make a pair array. Key is frequency of current element in the map.
			 * Value stores the original current element(ie key) of the map
			 */
			p = new Pair(map.get(key), key);

			minHeap.add(p);

			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		// do not use minHeap.size() instead of k for condition check,
		// since dynamic size(since, poll is happening)
		for (int i = 0; i < k; i++) {
			System.out.println(minHeap.poll().getValue());
		}
	}
}