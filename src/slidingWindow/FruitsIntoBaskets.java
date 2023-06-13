package slidingWindow;

import java.util.HashMap;

/**
 * Fruits into Baskets
 * Given an array of characters where each character represents a fruit tree, you are given two baskets and
 * your goal is to put maximum number of fruits in each basket.
 * The only restriction is that each basket can have only one type of fruit.
 * You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from
 * each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 * Write a function to return the maximum number of fruits in both the baskets.
 *
 * Example 1:
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 */
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
