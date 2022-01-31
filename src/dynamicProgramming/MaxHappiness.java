package dynamicProgramming;

import java.util.Arrays;

/**
 * @author amrit
 * Link: https://atcoder.jp/contests/dp/tasks/dp_c
 * https://youtu.be/jQjnQJ9NPOY
 * 
 * Space complexity: O(nk) n: number of activity, k: number of days
 * Time complexity: O(n * k^2)
 */
public class MaxHappiness {

	public static void main(String[] args) {
		
		int [][] ar = {
				{6, 7, 8},
				{8, 8, 3},
				{2, 5, 2},
				{7, 8, 6},
				{4, 6, 8},
				{2, 3, 4},
				{7, 5, 1},
		};
		
		int[][] happy = new int[ar.length][3];
		
		happy[0][0] = ar[0][0];
		happy[0][1] = ar[0][1];
		happy[0][2] = ar[0][2];
		
		System.out.println(findMaxHappiness(ar, happy));
		for (int i = 0; i < happy.length; i++) {
			System.out.println(Arrays.toString(happy[i]));
		}
	}

	private static int findMaxHappiness(int[][] ar, int[][] happy) {
		
		for (int day = 1; day < ar.length; ++day) {
			happy[day][0] = ar[day][0] + Math.max(happy[day-1][1], happy[day-1][2]);
			happy[day][1] = ar[day][1] + Math.max(happy[day-1][0], happy[day-1][2]);
			happy[day][2] = ar[day][2] + Math.max(happy[day-1][0], happy[day-1][1]);
		}
		
		int maxHappy = Math.max(happy[ar.length-1][0], 
				Math.max(happy[ar.length-1][1], happy[ar.length-1][2]));
		
		return maxHappy;
		
	}
}
