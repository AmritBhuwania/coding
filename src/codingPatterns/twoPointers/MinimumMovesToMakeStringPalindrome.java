package codingPatterns.twoPointers;

import arrays.Solution;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string s, return the minimum number of moves required to transform s into a palindrome.
 * In each move, you can swap any two adjacent characters in s.
 *
 * Note: The input string is guaranteed to be convertible into a palindrome.
 */
public class MinimumMovesToMakeStringPalindrome {

    public static int minMovesToMakePalindrome(String s) {
        // Convert string to list for easier manipulation
        char[] chars = s.toCharArray();

        // Counter to keep track of the total number of swaps
        int moves = 0;

        // Loop to find a character from the right (s[j]) that
        // matches with a character from the left (s[i])
        for (int i = 0, j = chars.length - 1; i < j; ++i) {
            int k = j;
            for (; k > i; --k) {
                // If a matching character is found
                if (chars[i] == chars[k]) {
                    // Move the matching character to the correct position on the right
                    for (; k < j; ++k) {
                        // Swap characters
                        char temp = chars[k];
                        chars[k] = chars[k + 1];
                        chars[k + 1] = temp;
                        // Increment count of swaps
                        ++moves;
                    }
                    // Move the right pointer inwards
                    --j;
                    break;
                }
            }
            // If no matching character is found, it must be moved to the center of palindrome
            if (k == i) {
                moves += chars.length / 2 - i;
            }
        }
        return moves;
    }

    // Driver code
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ccxx", "arcacer", "w", "ooooooo", "eggeekgbbeg");

        for (int i = 0; i < strings.size(); ++i) {
            System.out.println((i + 1) + ".\ts: " + strings.get(i));
            System.out.println("\tMoves: " + MinimumMovesToMakeStringPalindrome.minMovesToMakePalindrome(strings.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
