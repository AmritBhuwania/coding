package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://youtu.be/4eOPYDOiwFo?si=c0HOzsZc7iEZp8Vs
 */
public class LetterCaseRecursion {

    public static void main(String[] args) {
        String input = "a1B2";
        String output = "";
        letterCaseRecursion(input, output);
        System.out.println(letterCaseRecursion(input, output, new ArrayList<>()));
    }

    private static void letterCaseRecursion(String input, String output) {

        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }

        char c = input.charAt(0);

        // if c is alphabetic character, we have 2 options, either lower case or upper case
        if (Character.isAlphabetic(c)) {
            String output1 = output + String.valueOf(c).toLowerCase();
            String output2 = output + String.valueOf(c).toUpperCase();

            letterCaseRecursion(input.substring(1), output1);
            letterCaseRecursion(input.substring(1), output2);

        } else {
            // if c is number, just include it. There is no option, so no decision to be made
            letterCaseRecursion(input.substring(1), output + c);
        }
    }

    private static List<String> letterCaseRecursion(String input, String output, List<String> ans) {
        if (input.isEmpty()) {
            ans.add(output);
            return ans;
        }

        char c = input.charAt(0);

        // if c is alphabetic character, we have 2 options, either lower case or upper case
        if (Character.isAlphabetic(c)) {
            String output1 = output + String.valueOf(c).toLowerCase();
            String output2 = output + String.valueOf(c).toUpperCase();

            letterCaseRecursion(input.substring(1), output1, ans);
            letterCaseRecursion(input.substring(1), output2, ans);

        } else {
            // if c is number, just include it. There is no option, so no decision to be made
            letterCaseRecursion(input.substring(1), output + c, ans);
        }
        return ans;
    }

}
