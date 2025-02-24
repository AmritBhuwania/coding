package codingPatterns.fastSlowPointers;

import java.util.Arrays;

/**
 * Given an array of positive numbers, nums, such that the values lie in the range
 * [1,n], inclusive, and that there are n+1 numbers in the array, find and return the
 * duplicate number present in nums. There is only one repeated number in nums,
 * but it may appear more than once in the array.
 *
 * Note: You cannot modify the given array nums.
 * You have to solve the problem using only constant extra space.
 */
public class DuplicateNumber {
    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast)
                break;
        }

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // Replace this placeholder return statement with your code

        return fast;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 3, 2, 3, 5, 4},
                {2, 4, 5, 4, 1, 3},
                {1, 6, 3, 5, 1, 2, 7, 4},
                {1, 2, 2, 4, 3},
                {3, 1, 3, 5, 6, 4, 2}
        };
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tnums = "+ Arrays.toString(nums[i]));
            System.out.println("\tDuplicate number = "+ findDuplicate(nums[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
