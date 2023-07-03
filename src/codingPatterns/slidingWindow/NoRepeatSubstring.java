package codingPatterns.slidingWindow;

import java.util.HashMap;

/**
 * No-repeat Substring
 *
 * Given a string, find the length of the longest substring which has no repeating characters.
 * Example 1:
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 */
public class NoRepeatSubstring {

	public static void main(String[] args) {

		int result = longestSubstringWithKDistinctCharacters("abcadefga");
		System.out.println(result);
	}

	private static int longestSubstringWithKDistinctCharacters(String str) {

		int windowStart = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int maxlength = 0;

		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);

			if (map.containsKey(rightChar)) {
				/*
				  This is tricky; in the current window, we will not have any 'rightChar' after its previous index
				  and if 'windowStart' is already ahead of the last index of 'rightChar', we will keep 'windowStart'
				 */
				windowStart = Math.max(windowStart, map.get(rightChar) + 1);
			}
			map.put(rightChar, windowEnd);
			maxlength = Math.max(maxlength, windowEnd - windowStart + 1);
		}
		return maxlength;
	}
}
