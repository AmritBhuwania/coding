package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author amrit
 * Linear search with recursion
 */

public class LinearSearchWithRecursion {

	public static void main(String[] args) {
		int[] ar = {1, 2, 1, 2, 4};
		System.out.println(linearSearch(ar, 3, 0));
		System.out.println(findIndex(ar, 2, 0));
		findAllIndex(ar, 2, 0);
		System.out.println(ans);
		System.out.println(findAllIndex2(ar, 2, 0));
	}

	private static boolean linearSearch(int[] ar, int target, int index) {
		// TODO Auto-generated method stub

		if (index == ar.length) {
			return false;
		}

		if (ar[index] == target) {
			return true;
		}

		return linearSearch(ar, target, ++index);
	}

	private static int findIndex(int[] ar, int target, int index) {
		// TODO Auto-generated method stub

		if (index == ar.length) {
			return -1;
		}

		if (ar[index] == target) {
			return index;
		} else {

			return findIndex(ar, target, ++index);
		}
	}

	static List<Integer> ans = new ArrayList<Integer>();
	private static void findAllIndex(int[] ar, int target, int index) {
		// TODO Auto-generated method stub

		if (index == ar.length) {
			return;
		}
		if (ar[index] == target) {
			ans.add(index);
		}
		findAllIndex(ar, target, ++index);
	}
	
	private static List<Integer> findAllIndex2(int[] ar, int target, int index) {
		// TODO Auto-generated method stub
		
		List<Integer> ans = new ArrayList<Integer>();

		if (index == ar.length) {
			return ans;
		}
		if (ar[index] == target) {
			ans.add(index);
		}
		
		List<Integer> ansFromBelowRecursionCalls = findAllIndex2(ar, target, ++index);
		ans.addAll(ansFromBelowRecursionCalls);
		
		return ans;
	}
	
	

}
