package recursion;

/**
 * Link: https://youtu.be/J2Er5XceU_I?si=Xp0S9bzPmjOM70g-
 */
public class PermutationWithCaseChange {

    public static void main(String[] args) {
        String input = "abc";
        permutationWithCaseChange(input, "");
    }

    private static void permutationWithCaseChange(String input, String output) {

        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }

        String c = String.valueOf(input.charAt(0));
        String output1 = output + c;
        String output2 = output + c.toUpperCase();

        permutationWithCaseChange(input.substring(1), output1);
        permutationWithCaseChange(input.substring(1), output2);
    }
}
