package recursion;

/**
 * Given a positive integer N, print all N bit binary numbers having more or equal 1’s than 0’s for any prefix of the number.
 * Link: https://youtu.be/U81n0UYtk98?si=i-mVBMaazRryO5cu
 */
public class PrintNBinaryNumbers {

    public static void main(String[] args) {
        int k = 3, ones = 0, zeroes = 0;
        printNBinaryNumbers(k, ones, zeroes, "");
        printNBinaryNumbers2(k, ones, zeroes, "");
    }

    private static void printNBinaryNumbers(int k, int ones, int zeroes, String output) {

        if (ones + zeroes == k) {
            System.out.println(output);
            return;
        }

        printNBinaryNumbers(k, ones + 1,  zeroes, output + "1");

        if (ones > zeroes) {
            printNBinaryNumbers(k, ones, zeroes + 1, output + "0");
        }

    }

    private static void printNBinaryNumbers2(int k, int ones, int zeroes, String output) {

        if (k == 0) {
            System.out.println(output);
            return;
        }

        printNBinaryNumbers2(k-1, ones + 1,  zeroes, output + "1");

        if (ones > zeroes) {
            printNBinaryNumbers2(k-1, ones, zeroes + 1, output + "0");
        }

    }
}
