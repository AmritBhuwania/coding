package codingPatterns.twoPointers;

import java.util.Map;

/**
 * Given a string word and an abbreviation abbr, return TRUE if the abbreviation matches the given string.
 * Otherwise, return FALSE.
 * A certain word "calendar" can be abbreviated as follows:
 * "cal3ar" ("cal end ar" skipping three characters "end" from the word "calendar"
 * still matches the provided abbreviation)
 * "c6r" ("c alenda r" skipping six characters "alenda" from the word "calendar"
 * still matches the provided abbreviation)
 * The word "internationalization" can also be abbreviated as "i18n" (the abbreviation comes from skipping
 * 18 characters in "internationalization", leaving the first and last letters "i" and "n").
 *
 * The following are not valid abbreviations:
 * "c06r" (has leading zeroes)
 * "cale0ndar" (replaces an empty string)
 * "c24r" ("c al enda r" the replaced substrings are adjacent)
 */

public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0, abbrIndex = 0;

        while (abbrIndex < abbr.length()) {
            // Check if the current character is a digit.
            if (Character.isDigit(abbr.charAt(abbrIndex))) {
                // Check if there's a leading zero. If there is, return False.
                if (abbr.charAt(abbrIndex) == '0') {
                    return false;
                }
                int num = 0;

                while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    num = num * 10 + (abbr.charAt(abbrIndex) - '0');
                    abbrIndex++;
                }
                // Skip the number of characters in word as found in abbreviation.
                wordIndex += num;
            } else {
                // Check if characters the match, then increment the pointers. Otherwise return False.
                if (wordIndex >= word.length() || word.charAt(wordIndex)!= abbr.charAt(abbrIndex)) {
                    return false;
                }
                wordIndex++;
                abbrIndex++;
            }
        }

        // Check if both indices have reached the end of their respective strings.
        return wordIndex == word.length() && abbrIndex == abbr.length();
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = Map.of(0,0, 8,8, 6,9,9,6);
        String[] words = {
                //"a", "a", "abcdefghijklmnopqrst", "abcdefghijklmnopqrst", "word", "internationalization","localization",
                "abcdeabcdef"};
        String[] abbreviations = {
                //"a", "b", "a18t", "a19t", "w0rd", "i18n", "l12n",
                "10f"};

        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ".\t word: '" + words[i] + "'");
            System.out.println("\t abbr: '" + abbreviations[i] + "'");
            System.out.println("\n\t Is '" + abbreviations[i] + "' a valid abbreviation for the word '" + words[i] + "'? " + (validWordAbbreviation(words[i], abbreviations[i])? "Yes" : "No"));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
