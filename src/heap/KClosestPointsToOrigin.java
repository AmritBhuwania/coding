package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author amrit
 * Given a list of points on the 2-D plane and an integer K.
 * The task is to find K closest points to the origin and print them.
	Example:
	Input : point = [[3, 3], [5, -1], [-2, 4]], K = 2
 *
 */

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		int ar [][] = {
				{3,3},
				{5,-1},
				{-2,4}
		};
		//			{
		//				{1,3},
		//				{-2,2},
		//				{5,8},
		//				{0,1},
		//				{1,1}};

		int k = 2;
		kclosestPoints(ar, k);
	}

	private static void kclosestPoints(int[][] ar, int k) {

		// custom class and comparator used
		PriorityQueue<MyCustom> maxHeap = 
				new PriorityQueue<>((a, b) -> b.getDistance() - a.getDistance());

		MyCustom obj;
		int x,y, distance;
		for (int i = 0; i < ar.length; i++) {

			x = ar[i][0];
			y = ar[i][1];
			distance = (int) (Math.pow(x, 2) + Math.pow(y, 2));

			// taking square root wont make a difference while calculating distance
			obj = new MyCustom(ar[i], distance);
			maxHeap.add(obj);

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		while(maxHeap.size() > 0) {
			System.out.println(Arrays.toString(maxHeap.poll().getAr()));
		}
	}
}

class MyCustom {
	int [] ar = new int[2];
	int distance;

	public MyCustom(int[] ar, int distance) {
		super();
		this.ar = ar;
		this.distance = distance;
	}

	public int[] getAr() {
		return ar;
	}
	public int getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return "MyCustom [ar=" + Arrays.toString(ar) + ", distance=" + distance + "]";
	}
}
