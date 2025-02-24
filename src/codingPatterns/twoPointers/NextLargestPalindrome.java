package codingPatterns.twoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a string num_str representing a palindrome, the string only contains digits.
 * Your task is to return the next possible palindrome using the same digits.
 * The returned palindrome would be the next largest palindrome,
 * meaning there can be more than one way to rearrange the digits to make a larger palindrome.
 * Return an empty string if no greater palindrome can be made.
 *
 * Consider the following example to understand the expected output for a given numeric string:
 * input string = "123321"
 * possible palindromes = "213312", "231132", "312213", "132231", "321123"
 * We should return the palindrome "132231" as it is greater than "123321"
 * yet the smallest palindrome excluding the original palindrome.
 */
public class NextLargestPalindrome  {

    public static boolean findNextPermutation(List<Character> digits) {
        // Step 1: Find the first digit that is smaller than the digit after it
        int i = digits.size() - 2;
        while (i >= 0 && digits.get(i) >= digits.get(i + 1)) {
            i--;
        }
        if (i == -1) {
            return false;
        }

        // Step 2: Find the next largest digit to swap with digits[i]
        int j = digits.size() - 1;
        while (digits.get(j) <= digits.get(i)) {
            j--;
        }

        // Step 3: Swap and reverse the rest to get the smallest next permutation
        Collections.swap(digits, i, j);
        // Reverse is done to get the smallest number from the remaining digits
        Collections.reverse(digits.subList(i + 1, digits.size()));
        return true;
    }

    public static String findNextPalindrome(String numStr) {
        int n = numStr.length();

        if (n == 1) {
            return "";
        }

        int halfLength = n / 2;
        List<Character> leftHalf = new ArrayList<>();
        for (int i = 0; i < halfLength; i++) {
            leftHalf.add(numStr.charAt(i));
        }

        // Step 1: Get the next permutation for the left half
        if (!findNextPermutation(leftHalf)) {
            return "";
        }

        // Step 2: Form the next palindrome by mirroring the left half
        StringBuilder nextPalindrome = new StringBuilder();
        for (char c : leftHalf) {
            nextPalindrome.append(c);
        }

        if (n % 2 == 0) {
            nextPalindrome.append(new StringBuilder(nextPalindrome).reverse());
        } else {
            nextPalindrome.append(numStr.charAt(halfLength));
            nextPalindrome.append(new StringBuilder(nextPalindrome.substring(0, halfLength)).reverse());
        }

        // Step 3: Ensure the result is larger than the original number
        if (nextPalindrome.toString().compareTo(numStr) > 0) {
            return nextPalindrome.toString();
        }
        return "";
    }

    public static void main(String[] args) {
        String[] testCases = {"1221", "54345", "999", "12321", "89798", "23143034132"};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println(i + 1 + ".\t Original palindrome: '" + testCases[i] + "'");
            String nextPalindrome = findNextPalindrome(testCases[i]);
            System.out.println("\t Next greater palindrome: '" + nextPalindrome + "'");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

