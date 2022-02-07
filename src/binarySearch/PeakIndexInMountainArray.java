package binarySearch;
class PeakIndexInMountainArray {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,10,6,5,2};
		PeakIndexInMountainArray mountainArray = new PeakIndexInMountainArray();
		int index = mountainArray.peakIndexInMountainArray(arr);
		System.out.println(arr[index]);
	}

	private int peakIndexInMountainArray(int[] arr) {

		int start = 0;
		int end = arr.length - 1;
		
		while (start < end) {
			int mid = start + (end - start)/2;

			if (arr[mid] > arr [mid+1]){
				// in descending part of the array. This may be the ans, but look at the left too
				// this is why end is not equal to mid-1
				end = mid;

			} else {
				start = mid + 1;
			}
		}
		// start equals end
		return start;
	}
}


