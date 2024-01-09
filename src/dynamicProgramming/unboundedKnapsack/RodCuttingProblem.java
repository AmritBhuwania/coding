package dynamicProgramming.unboundedKnapsack;

/**
 * Link: https://youtu.be/SZqAQLjDsag?si=auo6ps0qCW5iNdLF
 * Rod Cutting Problem
 *  Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the  maximum value obtainable by cutting up the rod and selling the pieces.
 * Example:
 * if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 */
public class RodCuttingProblem {
    public static void main(String[] args) {
        int maxLength = 8;
        int price[] = new int[] {1, 5, 8, 9, 10, 17, 17,  20};
        int length[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(maximizeProfit(length, price, maxLength));

        maxLength = 12;
        price = new int[] {1, 5, 8, 9, 10, 17, 17,  20, 21, 22, 23, 24};
        length = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        System.out.println(maximizeProfit(length, price, maxLength));
    }

    private static int maximizeProfit(int[] length, int[] price, int maxLength) {
        int matrix[][] = new int[price.length + 1][maxLength + 1];
        for (int i = 0; i < maxLength + 1; ++i) {
            for (int j = 0; j < maxLength + 1; ++j) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < maxLength + 1; ++i) {
            for (int j = 1; j < maxLength + 1; ++j) {
                if (length[i-1] <= j) {
                    matrix[i][j] = Math.max(price[i-1] + matrix[i][j - length[i-1]], matrix[i-1][j]);
                } else {
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }

        return matrix[maxLength][maxLength];

    }
}
