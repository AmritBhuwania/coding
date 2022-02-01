package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author amrit
 * Print the elements of an array in the increasing frequency if 2 numbers have same
 * frequency then print the one which came first.
	Example:
	Input : arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
	Output : arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
 */

public class FrequencySort {

	public static void main(String[] args) {

		int[] ar = {2, 5, 2, 8, 5, 6, 8, 8};
			//{6, 4, 7, 6, 6, 2, 1, 4, 1, 4, 4};

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		// Frequency map
		for (int i = 0; i < ar.length; i++) {
			map.compute(ar[i], (key,val) -> val == null ? 1 : val + 1);
		}

		int k = map.size();
		topKFrequent(map, k);

	}

	static void topKFrequent(Map<Integer, Integer> map, int k) {

		PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

		Pair p; // A utility Pair class in same package
		List<Integer> answer = new ArrayList<Integer>();

		for (Integer key : map.keySet()) {

			/*
			 * Make a pair array. Key is frequency of current element in the map.
			 * Value stores the original current element(ie key) of the map
			 */
			p = new Pair(map.get(key), key);

			maxHeap.add(p);
		}

		for (int i = 0; i < k; i++) {
			p = maxHeap.poll();
			for (int j = 0; j < p.getKey(); j++) {
				answer.add(p.getValue());
			}
		}

		System.out.println(answer);
	}
}