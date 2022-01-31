package dynamicProgramming;

/*
 * Link: https://atcoder.jp/contests/dp/tasks/dp_a
 * https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
 */
public class Frog {

	public static void main(String[] args) {
		int [] ar = {10, 30, 50, 20, 40, 20, 60};

		minFromJump(ar);
	}

	private static void minFromJump(int[] ar) {

		int cost1 = 0;
		int cost2 = Integer.MAX_VALUE; // edge case to handle for i = 1
		int[] cost = new int[ar.length];
		cost[0] = 0;

		for (int i = 1; i < ar.length; ++i) {

			cost1 = cost[i-1] + Math.abs(ar[i] - ar[i-1]);

			// edge case for i = 1
			if (i > 1)
				cost2 = cost[i-2] + Math.abs(ar[i] - ar[i-2]);

			cost[i] = Math.min(cost1, cost2);
			
			System.out.println("cost1: " + cost1 + ", cost2: "
					+ cost2 +", cost[" + i + "]: " + cost[i]);
		}
		System.out.println(cost[ar.length-1]);
	}
}
