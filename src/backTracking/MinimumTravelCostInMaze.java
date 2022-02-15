package backTracking;

/**
 * @author amrit
 * Given a grid with each cell having some cost, find the minimum cost to travel from left top to right bottom of the grid
 */

public class MinimumTravelCostInMaze {

	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {

		int ar[][] = { 
				{2, 1, -6},
				{3, 1, -4},
				{1, 8, 3}
		};

		boolean vis [][] = new boolean[ar.length][ar[0].length];

		minimizeCost(ar, vis, 0, 0, 0);
		System.out.println(min);
	}

	private static void minimizeCost(int[][] ar, boolean [][] vis, int row, int col, int minValue) {

		if (row == ar.length -1 && col == ar[0].length -1) {
			minValue += ar[row][col];
			if (minValue < min) {
				min = minValue;
			}
			return;
		} 

		if (vis[row][col]) {
			return;
		}
		else {
			vis[row][col] = true;
		}

		if (row < ar.length -1) {
			minimizeCost(ar, vis, row + 1, col, minValue + ar[row][col]);
		}

		if (col < ar[0].length -1) {
			minimizeCost(ar, vis, row, col + 1, minValue + ar[row][col]);
		}

		if (row > 0) {
			minimizeCost(ar, vis, row - 1, col, minValue + ar[row][col]);
		}

		if (col > 0) {
			minimizeCost(ar, vis, row, col - 1 , minValue + ar[row][col]);
		}

		vis[row][col] = false;

		System.out.println(min);
	}
}
