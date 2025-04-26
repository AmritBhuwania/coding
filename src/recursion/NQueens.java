package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/description/
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.'both indicate a queen and an empty space, respectively.
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        List<String> board = new ArrayList<>();
        String s = ".";
        s = s.repeat(n);
        for (int i = 0; i < n; ++i) {
            board.add(s);
        }

        //System.out.println(Arrays.asList(board));

        List<List<String>> ans = new ArrayList<>();
        List<Integer> leftRow = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> lowerDiagonal = new ArrayList<>(Collections.nCopies(2*n-1, 0));
        List<Integer> upperDiagonal = new ArrayList<>(Collections.nCopies(2*n-1, 0));

        solve(0, n, board, ans, leftRow, lowerDiagonal, upperDiagonal );
        return ans;
    }

    public void solve(int col, int n, List<String> board, List<List<String>> ans,
                      List<Integer> leftRow, List<Integer> lowerDiagonal, List<Integer> upperDiagonal) {
        //System.out.println(Arrays.asList(board) + ", col:" + col);
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < n; ++row) {
            if (leftRow.get(row) == 0 && lowerDiagonal.get(col + row) == 0 &&
                    upperDiagonal.get(n-1+col-row) == 0) {
                String temp = board.get(row).substring(0, col) + 'Q' +
                        board.get(row).substring(col + 1);
                //System.out.println(temp);
                board.set(row, temp);
                leftRow.set(row, 1);
                lowerDiagonal.set(row + col, 1);
                upperDiagonal.set(n - 1 + col - row, 1);

                solve(col+1, n, board, ans, leftRow, lowerDiagonal, upperDiagonal);

                temp = board.get(row).substring(0, col) + '.' +
                        board.get(row).substring(col + 1);
                board.set(row, temp);
                leftRow.set(row, 0);
                lowerDiagonal.set(row + col, 0);
                upperDiagonal.set(n - 1 + col - row, 0);
            }
        }
    }

    private boolean isSafePlace(int n, char[][] nQueens, int row, int col) {
        for (int i = 0; i < n; i++) {
            if (nQueens[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void solveNQueens(int n, List<List<String>> output, char[][] nQueens, int row) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] rowArray : nQueens) {
                solution.add(new String(rowArray));
            }
            output.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafePlace(n, nQueens, row, col)) {
                nQueens[row][col] = 'Q';
                solveNQueens(n, output, nQueens, row + 1);
                nQueens[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueensApproach2(int n) {
        List<List<String>> output = new ArrayList<>();
        char[][] nQueens = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }

        solveNQueens(n, output, nQueens, 0);
        return output;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(Collections.singletonList(nQueens.solveNQueens(4)));
        System.out.println(Collections.singletonList(nQueens.solveNQueensApproach2(4)));
    }

}
