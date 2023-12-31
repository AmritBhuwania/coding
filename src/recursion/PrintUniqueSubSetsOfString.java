package recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Link: https://youtu.be/lfFqW1DTsqM?si=BFyxV_apTzGx-Hwj
 */
public class PrintUniqueSubSetsOfString {

    public static void main(String[] args) {
        String input = "abac";
        System.out.println(printUniqueSubSets(input, "", new HashSet<>()));
    }

    private static Set<String> printUniqueSubSets(String input, String output, Set<String> ans) {

        if (input.isEmpty()) {
            ans.add(output);
            return ans;
        }

        String c = String.valueOf(input.charAt(0));

        String output1 = output; // recursion excluding the output
        String output2 = output.concat(c); // recursion including the output

        printUniqueSubSets(input.substring(1), output1, ans);
        printUniqueSubSets(input.substring(1), output2, ans);

        return ans;

    }
}
