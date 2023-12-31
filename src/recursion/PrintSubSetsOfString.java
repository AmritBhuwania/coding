package recursion;

/**
 * Link: https://youtu.be/Yg5a2FxU4Fo?si=p_l1tWyUbM_tv7X2
 */
public class PrintSubSetsOfString {

    public static void main(String[] args) {
        String input = "abc";
        printSubSets(input, "");
    }

    private static void printSubSets(String input, String output) {

        if (input.isEmpty()) {
            System.out.print(output + " ");
            return;
        }

        String c = String.valueOf(input.charAt(0));

        String output1 = output; // recursion excluding the output
        String output2 = output.concat(c); // recursion including the output

        printSubSets(input.substring(1), output1);
        printSubSets(input.substring(1), output2);

    }
}
