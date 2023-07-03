package codingPatterns.slidingWindow;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public String minWindow(String s, String t) {


		Map<Character, Integer> tMap = new HashMap<>();

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			tMap.put(c, tMap.getOrDefault(c, 0) + 1);
		}

		int start = 0, end = 0, counter = t.length(), len = Integer.MAX_VALUE;
		String ans = "";

		for(end = 0; end < s.length(); end++) {

			char endChar = s.charAt(end);
			if (tMap.containsKey(endChar)) {
				int count = tMap.get(endChar);
				tMap.put(endChar, count - 1);

				if (tMap.get(endChar) >= 0) counter--;
			}

			while(counter == 0) {

				if ((end - start + 1) < len) {
					ans = s.substring(start, end + 1);
					len = ans.length();
				}

				char startChar = s.charAt(start);

				if (tMap.containsKey(startChar)) {
					int count = tMap.get(startChar);
					if (tMap.get(startChar) >= 0) {
						counter++;
					}
					tMap.put(startChar, count + 1);
				}

				start++;
			}
		}
		return ans;

	}

}
