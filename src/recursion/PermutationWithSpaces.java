package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://youtu.be/1cspuQ6qHW0?si=nWTqowsf1VYIunhZ
 */
public class PermutationWithSpaces {

    public static void main(String[] args) {
        String input = "abc";
        String output  = String.valueOf(input.charAt(0));
        input = input.substring(1);

        permutationWithSpaces(input, output);
        System.out.println(permutationWithSpaces(input, output, new ArrayList<>()));

    }

    private static void permutationWithSpaces(String input, String output) {

        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }

        String c = String.valueOf(input.charAt(0));

        String output1 = output;
        String output2 = output + "_" + c;

        permutationWithSpaces(input.substring(1), output1);
        permutationWithSpaces(input.substring(1), output2);
    }


    private static List<String> permutationWithSpaces(String input, String output, List<String> ans) {

        if (input.isEmpty()) {
            ans.add(output);
            return ans;
        }

        String c = String.valueOf(input.charAt(0));

        String output1 = output;
        String output2 = output + "_" + c;

        permutationWithSpaces(input.substring(1), output1, ans);
        permutationWithSpaces(input.substring(1), output2, ans);

        return ans;
    }

}
