package heap;

import java.util.PriorityQueue;

/**
 * @author amrit
 * There are given n ropes of different lengths, we need to connect these ropes into one rope.
 * The cost to connect two ropes is equal to sum of their lengths.
 * We need to connect the ropes with minimum cost.

ex. If we are given 4 ropes of lengths 4,3,2 and 6. We can connect ropes in following ways.
1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
3) Finally connect the two ropes and all ropes have connected.

Total cost for connecting all ropes is 5 + 9 + 15 = 29.
This is the optimized cost for connecting ropes. Other ways of connecting ropes would always
have same or more cost. For example, if we connect 4 and 6 first
(we get three strings of 3, 2 and 10), then connect 10 and 3
(we get two strings of 13 and 2). Finally we connect 13 and 2.
Total cost in this way is 10 + 13 + 15 = 38.
 */
public class ConnectRopesToMinimiseCost {

	public static void main(String[] args) {

		int k = 3;
		int[] ar = {2,4,1,3,5};

		minimiseRopeCost(ar, k);

	}

	static void minimiseRopeCost(int[] ar, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < ar.length; i++) {
			minHeap.add(ar[i]);
		}

		int totalCost = 0, newRopeLength = 0;
		int smallestRope, secondSmallestRope;

		// check until size >= 2 since polling is happening twice inside
		while (minHeap.size() >= 2) {
			smallestRope = minHeap.poll();
			secondSmallestRope = minHeap.poll();

			newRopeLength = smallestRope + secondSmallestRope;
			totalCost += newRopeLength;

			// add again the new rope
			minHeap.add(newRopeLength);
		}

		System.out.println(totalCost);
	}
}
