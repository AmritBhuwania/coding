package recursion;

import java.util.ArrayList;
import java.util.List;


/**
 * Problem Description: https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle1840/1
 * Link: https://youtu.be/ULUNeD0N9yI?si=1DUl-91Q8Szcbd-b
 */
public class JosephusProblem {

    public static void main(String[] args) {
        int n = 40, k = 7;
        List<Integer> input = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            input.add(i);
        }
        int index = 0, ans = -1;

        // doing --k since if we want to remove 2nd person everytime i.e someone at index 0
        // (basically, we are always counting from 0, so we can do --k here)
        solve(input, --k, index, ans);
    }

    private static void solve(List<Integer> input, int k, int index, int ans) {

        if (input.size() == 1) {
            System.out.println(input.getFirst());
            return;
        }

        index = (index + k) % input.size();
        input.remove(index);

        solve(input, k, index, ans);

    }
}
