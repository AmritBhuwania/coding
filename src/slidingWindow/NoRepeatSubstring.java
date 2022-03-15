package slidingWindow;

import java.util.HashMap;
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
				windowStart = map.get(rightChar) + 1;
			}
			map.put(rightChar, windowEnd);
			maxlength = Math.max(maxlength, windowEnd - windowStart + 1);
		}
		return maxlength;
	}
}
