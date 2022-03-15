package twoPointers;

public class SquaringSortedArray {
	
	public static void main(String[] args) {
		int [] result = SquaringSortedArray.makeSquares(new int[] {-3, -2, 0 , 1, 4});
		for (int num : result) {
			System.out.print(num + " ");
		}
	}

	private static int[] makeSquares(int[] arr) {
		
		int n = arr.length;
		int [] squares = new int[n];
		int left = 0, right = n-1;
		int lastIndex = n-1;
		
		while(left <= right) {
			int leftSquare = arr[left] * arr[left];
			int rightSquare = arr[right] * arr[right];
			
			if (leftSquare > rightSquare) {
				squares[lastIndex--] = leftSquare;
				left++;
			} else {
				squares[lastIndex--] = rightSquare;
				right--;
			}
		}
		
		return squares;
	}

}
