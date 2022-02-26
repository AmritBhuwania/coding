package binarySearch;

import java.util.Arrays;

/**
 * @author amrit
 * Given the start and end time of meetings, find minimum number of rooms so that all meetings can happen
 * Note: We can reuse the room if start time of a meeting collides with endTime of a different meeting 
 *
 */

public class MinimumNumberOfMeetingRooms {

	public static void main(String[] args) {

		int startTime[] = {900, 945, 930, 1015};
		int endTime[] = {945, 1030, 1000, 1100};

		// sort the start and end time arrays individually if not sorted
		Arrays.sort(startTime);
		Arrays.sort(endTime);

		int numberOfRoomsReq = 1;
		int max = 1;
		int startIndex = 1;
		int endIndex = 0;
		int length = startTime.length;

		while (startIndex < length && endIndex < length) {

			if (startTime[startIndex] > endTime[endIndex]) {
				++endIndex;
				--numberOfRoomsReq;
			} else if (startTime[startIndex] < endTime[endIndex]){
				++startIndex;
				++numberOfRoomsReq;
			} else {
				++startIndex;
			}

			if (max < numberOfRoomsReq) {
				max = numberOfRoomsReq;
			}
		}
		System.out.println(max);
	}

}


