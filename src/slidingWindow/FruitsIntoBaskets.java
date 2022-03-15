package slidingWindow;

import java.util.HashMap;

public class FruitsIntoBaskets {


	public static void main(String[] args) {

		int result = longestSubstringWithKDistinctCharacters(new char[] {'a', 'b', 'c', 'b', 'b', 'a'}, 2);
		System.out.println(result);
	}

	private static int longestSubstringWithKDistinctCharacters(char[] str, int num) {

		int windowStart = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int maxlength = 0;

		for (int windowEnd = 0; windowEnd < str.length; windowEnd++) {
			map.compute(str[windowEnd], (key,val) -> (val == null) ? 1 : val + 1);
			while (map.size() > num) {
				map.put(str[windowStart], map.get(str[windowStart])-1);
				if (map.get(str[windowStart]) == 0) {
					map.remove(str[windowStart]);
				}
				windowStart++;
			}
			maxlength = Math.max(maxlength, windowEnd - windowStart + 1);
		}
		return maxlength;
	}
}
