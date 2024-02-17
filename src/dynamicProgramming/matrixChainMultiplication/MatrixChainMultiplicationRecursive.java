package dynamicProgramming.matrixChainMultiplication;

public class MatrixChainMultiplicationRecursive {
    public static void main(String[] args) {
        int[] input = new int[]{40, 20, 30, 10, 30};
        System.out.println("Ans: " + solve(input, 1, input.length-1));
    }

    private static int solve(int[] input, int i, int j) {

        if (i >= j) {
            return 0;
        }


        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; ++k) {
            int tempAns = solve(input, i, k) + solve(input, k+1, j) + input[i-1] * input[k] * input[j];
            ans = Math.min(tempAns, ans);
        }

        return ans;
    }

}
