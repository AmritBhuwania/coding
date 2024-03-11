package binarySearch;

/**
 * Link: https://youtu.be/2JSQIhPcHQg?si=5CLSae1LBjzUSdEz
 *
 * Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.
 *
 * Example :
 * Input : pages[] = {12, 34, 67, 90}
 *         m = 2
 * Output : 113
 * Explanation:
 * There are 2 number of students. Books can be distributed
 * in following fashion :
 *   1) [12] and [34, 67, 90]
 *       Max number of pages is allocated to student
 *       2 with 34 + 67 + 90 = 191 pages
 *   2) [12, 34] and [67, 90]
 *       Max number of pages is allocated to student
 *       2 with 67 + 90 = 157 pages
 *   3) [12, 34, 67] and [90]
 *       Max number of pages is allocated to student
 *       1 with 12 + 34 + 67 = 113 pages
 *
 * Of the 3 cases, Option 3 has the minimum pages = 113
 *
 * Similar questions:
 *
 * 1482 Minimum Number of Days to Make m Bouquets
 * 1283 Find the Smallest Divisor Given a Threshold
 * 1231 Divide Chocolate
 * 1011 Capacity To Ship Packages In N Days
 * 875 Koko Eating Bananas
 * Minimize
 * 774 Max Distance to Gas Station
 * 410 Split Array Largest Sum
 */
public class AllocateMinimumNumberOfPages {

    public static void main(String[] args) {
        int[] nums = {10, 20, 10, 40, 20};
        int maxNumOfStudents = 3;
        int ans = findMinNumberOfPages(nums, maxNumOfStudents);
        System.out.println(ans);

    }

    private static int findMinNumberOfPages(int[] nums, int maxNumOfStudents) {

        int sum = 0, maxEle = 0, result = -1, mid, start, end;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            maxEle = Math.max(maxEle, nums[i]);
        }

        start = maxEle;
        end = sum;

        while (start <= end) {
            mid = (start + end)/2;
            if (isValidNumberOfPagesAndStudents(nums, maxNumOfStudents, mid)) {
                result = mid;
                end = end - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean isValidNumberOfPagesAndStudents(int[] nums, int maxNumOfStudents, int mid) {

        int student = 1;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            if (sum > mid) {
                ++student;
                sum = num;
            }

            if (student > maxNumOfStudents) {
                return false;
            }
        }
        return true;
    }

}
