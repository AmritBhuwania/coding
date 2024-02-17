package dynamicProgramming.matrixChainMultiplication;

public class MatrixChainMultiplicationMemoization {
    public static void main(String[] args) {
        int[] input = new int[]{ 1, 2, 3, 4}; // 1, 2, 3, 4 // 40, 20, 30, 10, 30
        int matrix[][] = new int[input.length][input.length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                matrix[i][j] = -1;
            }

        }
        System.out.println("Ans: " + solve(input, 1, input.length-1, matrix));
    }

    private static int solve(int[] input, int i, int j, int [][] matrix) {

        if (i >= j) {
            return 0;
        }

        if (matrix[i][j] != -1) {
            return matrix[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; ++k) {
            int tempAns = solve(input, i, k, matrix) + solve(input, k+1, j, matrix) + input[i-1] * input[k] * input[j];
            ans = Math.min(tempAns, ans);
            matrix[i][j] = ans;
        }

        return ans;
    }

}


