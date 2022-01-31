package binarySearch;

import java.util.Arrays;

/**
 * 
 * @author amrit
 * Question: Here, row and column are individually sorted. 
 * Find index of the target given.
 *
 */

public class RowColMartix {
	
	public static void main(String[] args) {
		int [][]arr = {
				{10, 20, 30, 40},
				{15, 25, 35, 45},
				{25, 35, 37, 39},
				{33, 39, 56, 67}
				};
		
		System.out.println(Arrays.toString(search(arr, 37)));
		
	}
	
	static int[] search(int[][] arr, int target) {
		
		int row = 0;
		int col = arr.length - 1;
		
		while(row < arr.length && col > 0) {
			if (arr[row][col] == target) {
				return new int[] {row, col};
			} else if (arr[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}
		return new int[] {-1, -1};
	}
}
