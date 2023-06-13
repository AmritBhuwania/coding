package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/** Longest Substring with Same Letters after Replacement
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 *
 * Example 1:
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 */

public class CharacterReplacement {

    public static void main(String[] args) {

        int result = findLength("dhfggjggggjkjd", 2);
        System.out.println(result);
    }

    private static int findLength(String input, int k) {

        int start = 0, end, maxLength = 0;
        int maxRepeatLetterCount = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (end = 0; end < input.length(); ++end) {

            char current = input.charAt(end);
            map.compute(current, (key, val) -> val == null ? 1 : val + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, map.get(current));

            /*
             * In current window (start to end, we have a letter occurring 'maxRepeatLetterCount' no. of times)
             * We have to replace other letters in this window with the constraint that we can replace k letters
             * shrink the window if remaining letters > k, i.e. (window size - maxRepeatLetterCount > k)
             */

            if (end - start + 1 - maxRepeatLetterCount > k) {
                char leftChar = input.charAt(start);
                map.put(leftChar, map.get(leftChar) - 1);
                ++start;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
