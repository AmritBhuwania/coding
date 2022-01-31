package recursion;

/**
 * 
 * @author amrit
 * Check if array is sorted or not using recursion
 */

public class CheckArraySorted {
	
	public static void main(String[] args) {
		int[] ar = {1, 2, 3, 4, 2};
		System.out.println(checkSorted(ar, 0));
		
		int[] ar2 = {1, 2, 3, 4};
		System.out.println(checkSorted(ar2, 0));
	}

	private static boolean checkSorted(int[] ar, int index) {
		
		// base condition
		if (index == ar.length -1) {
			return true;
		}
		
		return (ar[index] < ar [index+1] && checkSorted(ar, ++index));
		
		//return false;
	}

}
