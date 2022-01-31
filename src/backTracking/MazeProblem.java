package backTracking;

/**
 * 
 * @author amrit
 * Get all paths of a maze
 */

public class MazeProblem {
	public static void main(String[] args) {
		System.out.println(countMaze(3, 3));
		pathMaze("", 3, 3);
		System.out.println("--------------------------------------");
		pathMazeDiagonal("", 3, 3);
		System.out.println("--------------------------------------");

		int[][] ar = {
				{0,0,0},
				{0,1,0},
				{0,0,0}
		};

		pathRestrictions("", ar, 0, 0);
	}

	static int countMaze(int r, int c) {

		if (r == 1 || c == 1) {
			return 1;
		}

		int count = 0;
		count += countMaze(r-1, c);
		count += countMaze(r, c-1);

		return count;
	}

	static void pathMaze(String p, int r, int c) {

		if (r == 1 && c == 1) {
			System.out.println(p);
			return;
		}

		if (r > 1)
			pathMaze(p + "D", r-1, c);
		if (c > 1)
			pathMaze(p + "R", r, c-1);
	}

	static void pathMazeDiagonal(String p, int r, int c) {

		if (r == 1 && c == 1) {
			System.out.println(p);
			return;
		}

		if (r > 1)
			pathMazeDiagonal(p + "D", r-1, c);
		if (c > 1)
			pathMazeDiagonal(p + "R", r, c-1);
		if (r > 1 && c >1)
			pathMazeDiagonal(p + "X" , r-1, c-1);
	}

	static void pathRestrictions(String p, int[][] ar, int r, int c) {

		if (r == ar.length-1 && c == ar[r].length-1) {
			System.out.println(p);
			return;
		}
		if (ar[r][c] == 1) {
			return;
		}

		if (r < ar.length-1)
			pathRestrictions(p + "D", ar, r+1, c);
		if (c < ar[r].length-1)
			pathRestrictions(p + "R", ar, r, c+1);
	}
	
	

}
