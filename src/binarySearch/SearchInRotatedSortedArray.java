package binarySearch;

/**
 * @author amrit
 * Search a target in a sorted rotated array 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
   Output: 4
 */

class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] arr = {4,5,6,7,0,1,2};
		SearchInRotatedSortedArray inRotatedSortedArray = new SearchInRotatedSortedArray();
		int index = inRotatedSortedArray.search(arr, 0);
		System.out.println(index);
	}

	public int search(int[] ar, int target) {

		int pivot = peakIndex(ar);

		if (pivot == -1 ) {
			// sorted array or no ratation
			return  binarySearch(ar, 0, ar.length-1, target);
		}

		if (ar[pivot] == target) return pivot;

		if (target >= ar[0]) {
			return  binarySearch(ar, 0, pivot-1, target);
		}

		return binarySearch(ar, pivot+1, ar.length-1, target);

	}

	private int peakIndex(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start)/2;

			// 4 conditions
			if (mid < end && arr[mid] > arr [mid+1]) {
				return mid;
			}

			if (mid > start && arr[mid] < arr [mid-1]) {
				return mid - 1;
			}

			if (arr[mid] <= arr [start]) {
				end = mid -1;
			}
			else {
				start = mid + 1;
			}
		}
		return -1;
	}

	private int binarySearch(int[] ar, int start, int end, int target) {

		while (start <= end) {
			int mid = start + (end - start)/2;

			if (ar[mid] == target) {
				return mid;
			} else if (ar[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}
}
