package interviews2024;

import leetcode.arrays.PascalsTriangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Please search Anagram Substring and Indices of Anagrams from below mentioned string and pattern ,*
 * radomString  = "cbaebca bacd";
 * pattern            = "cab";
 */
public class AngelOne {
    public static void main(String[] args) {
        String input = "abcabac";
        String pattern = "abc";

        Map<Character, Integer> patterMap = new HashMap<>();
        //Map<Character, Integer> patterMap = new HashMap<>();
        List<Integer> outputIndexes = new ArrayList<>();
        List<String> outputAnagrams =  new ArrayList<>();

        patterMap = computePatternMap(pattern);
        Map<Character, Integer> tempPatterMap = computePatternMap(pattern);

        int keyCount, start = 0, end = 0;

        while(start <= end && end < input.length()) {
            if (patterMap.containsKey(input.charAt(end))) {
                keyCount = patterMap.get(input.charAt(end));
                --keyCount;
                if (keyCount == 0) {
                    patterMap.remove(input.charAt(end));
                } else {
                    patterMap.put(input.charAt(end), keyCount);
                }
                ++end;
            } else {
                ++start;
                end = start;
                patterMap = computePatternMap(pattern);
            }

            if (patterMap.isEmpty()) {
                outputAnagrams.add(input.substring(start, start + pattern.length()));
                outputIndexes.add(start);
                patterMap = computePatternMap(pattern);
                ++start;
                end = start;
            }
        }

        System.out.println(outputAnagrams);
        System.out.println(outputIndexes);
    }

    private static Map<Character, Integer> computePatternMap(String pattern) {
        Map<Character, Integer> patterMap = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            patterMap.compute(ch, (k, v) -> v == null ? 1: v +1);
        }

        return patterMap;
    }
}
