package backTracking;

import java.util.Arrays;

/**
 * 
 * @author amrit
 * Ways to visit a maze if we can move in all directions 
 */
public class MazeBackTracking {
	public static void main(String[] args) {

		int[][] ar = {
				{0,0,0},
				{0,0,0},
				{0,0,0}
		};

		mazeAllPaths("", ar, 0, 0);

		int [][]path = new int[ar.length][ar[0].length];

		mazePrintAllPaths("", ar, 0, 0, path, 0);
	}

	static void mazeAllPaths(String p, int[][] ar, int r, int c) {

		if (r == ar.length-1 && c == ar[r].length-1) {
			System.out.println(p);
			return;
		}

		if (ar[r][c] == 1) {
			return;
		} else {
			// mark as visited
			ar[r][c] = 1;
		}

		if (r < ar.length-1 )
			mazeAllPaths(p + "D", ar, r+1, c);
		if (c < ar[r].length-1)
			mazeAllPaths(p + "R", ar, r, c+1);
		if (r > 0)
			mazeAllPaths(p + "U", ar, r-1, c);
		if (c > 0)
			mazeAllPaths(p + "L", ar, r, c-1);

		/*
		 *  remove the trace when moving back. This line is where the function will be over
		 *  so before the function gets removed, also remove the change that were made
		 *  by that function
		 */
		ar[r][c] = 0;

	}

	static void mazePrintAllPaths(String p, int[][] ar, int r, int c,
			int[][] path, int step) {

		if (r == ar.length-1 && c == ar[r].length-1) {
			path[r][c] = step;
			for(int[] arr: path) {
				System.out.println(Arrays.toString(arr));
			}
			System.out.println(p);
			System.out.println();
			return;
		}

		if (ar[r][c] == 1) {
			return;
		} else {
			// mark as visited
			ar[r][c] = 1;
			path[r][c] = step;
		}

		if (r < ar.length-1 )
			mazePrintAllPaths(p + "D", ar, r+1, c, path, step + 1);
		if (c < ar[r].length-1)
			mazePrintAllPaths(p + "R", ar, r, c+1, path, step + 1);
		if (r > 0)
			mazePrintAllPaths(p + "U", ar, r-1, c, path, step + 1);
		if (c > 0)
			mazePrintAllPaths(p + "L", ar, r, c-1, path, step + 1);

		ar[r][c] = 0;
		path[r][c] = 0;

	}
}
