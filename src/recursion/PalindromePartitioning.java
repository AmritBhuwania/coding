package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 *  Example 2:
 * Input: s = "a"
 * Output: [["a"]]

 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        System.out.println(Arrays.asList(palindromePartitioning.partition("aab")));
        System.out.println(Arrays.asList(palindromePartitioning.partition("aabb")));
    }

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        findPartions(0, s, path, result);
        return result;
    }

    public void findPartions(int index, String s, List<String> path, List<List<String>> result) {

        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i+1));
                findPartions(i+1, s, path, result);
                path.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
