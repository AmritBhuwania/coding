package codingPatterns.slidingWindow;

import java.util.List;

/**
 * Longest Subarray with Ones after Replacement
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.
 * Example 1:
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 */
public class ReplacingOnes {

    public static void main(String[] args) {
        System.out.println(findMaxLength(List.of(0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1), 2));
    }

    private static int findMaxLength(List<Integer> list, int x) {

        int start = 0, end, maxLen = 0, maxCurrOnes = 0;

        for (end = 0; end < list.size(); ++end) {
            if (list.get(end) == 1) {
                ++maxCurrOnes;
            }

            if (end - start + 1 - maxCurrOnes > x) {
                if (list.get(start) == 1) {
                    --maxCurrOnes;
                }
                ++start;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }


}
