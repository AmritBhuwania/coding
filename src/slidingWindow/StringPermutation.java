package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Permutation in a String
 *
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * Example 1:
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 */

public class StringPermutation {
    public static void main(String[] args) {

        System.out.println(findPermutation("iodbcaf", "dc"));
        System.out.println(findPermutation("iodbcaf", "abc"));
        System.out.println(findPermutation("bcdxabcdy", "bcdyabcdx"));
    }

    private static boolean findPermutation(String str, String pattern) {

        int windowStart = 0, windowEnd, matched = 0;
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            patternMap.compute(ch, (k, v)-> v == null ? 1 : v +1);
        }

        for (windowEnd = 0; windowEnd < str.length(); ++windowEnd) {
            char rightChar = str.charAt(windowEnd);
            if (patternMap.containsKey(rightChar)) {
                patternMap.put(rightChar, patternMap.get(rightChar) - 1); // decrement the freq of matched char
                if (patternMap.get(rightChar) == 0) { // char is completely matched
                    ++matched;
                }
            }

            if (matched == patternMap.size()) {
                return true;
            }

            if (windowEnd + 1 >= pattern.length()) { // shrink window size
                char leftChar = str.charAt(windowStart++);
                if (patternMap.containsKey(leftChar)) {
                    if (patternMap.get(leftChar) == 0) {
                        matched--;
                    }
                    patternMap.put(leftChar, patternMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }
}