package slidingWindow;

import java.util.HashMap;

public class LongestSubstringWithKDistinctCharacters {

	public static void main(String[] args) {

		int result = longestSubstringWithKDistinctCharacters("dhfggjggggjkjd", 2);
		System.out.println(result);
	}

	private static int longestSubstringWithKDistinctCharacters(String str, int num) {

		int windowStart = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int maxlength = 0;

		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			map.compute(str.charAt(windowEnd), (key,val) -> (val == null) ? 1 : val + 1);
			while (map.size() > num) {
				map.put(str.charAt(windowStart), map.get(str.charAt(windowStart))-1);
				if (map.get(str.charAt(windowStart)) == 0) {
					map.remove(str.charAt(windowStart));
				}
				windowStart++;
			}
			maxlength = Math.max(maxlength, windowEnd - windowStart + 1);
		}
		return maxlength;
	}
}
