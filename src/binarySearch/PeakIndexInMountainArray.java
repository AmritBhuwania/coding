package binarySearch;
class PeakIndexInMountainArray {

	public static void main(String[] args) {
		int[] arr = {0,1,2,10,5,2};
		PeakIndexInMountainArray mountainArray = new PeakIndexInMountainArray();
		int index = mountainArray.peakIndexInMountainArray(arr);
		System.out.println(arr[index]);
	}

	public int peakIndexInMountainArray(int[] arr) {

		int start = 0;
		int end = arr.length - 1;
		return search(arr, start, end);
	}

	private int search(int[] arr, int start, int end) {

		while (start < end) {

			int mid = start + (end - start)/2;

			System.out.println("mid: " + mid + ", start: " + start + ", end: " + end);
			if (arr[mid] > arr [mid-1] && (mid -1) >= 0  && arr[mid] > arr [mid+1] && (mid + 1) <= end) {
				return mid;
			} else if (arr[mid] > arr [mid-1]){
				start = mid;
			} else {
				end = mid;
			}
		}

		return -1;

	}
}


