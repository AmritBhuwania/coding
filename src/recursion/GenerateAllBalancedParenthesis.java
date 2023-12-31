package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBalancedParenthesis {
    public static void main(String[] args) {
        int m = 3, n = 3;
        String output = "";

        System.out.println(generateAllBalancedParenthesis(m, n, output, new ArrayList<>()));
        System.out.println(generateAllBalancedParenthesis2(m, n, output, new ArrayList<>()));
    }

    private static List<String> generateAllBalancedParenthesis(int m, int n, String output, List<String> ans) {

        if (m == 0 && n == 0) {
            //System.out.println(output);
            ans.add(output);
            return ans;
        }

        if (m == n) {
            generateAllBalancedParenthesis(m-1, n, output + "(", ans);
        } else if (m == 0) {
            generateAllBalancedParenthesis(m, n-1, output + ")", ans);
        } else {
            generateAllBalancedParenthesis(m-1, n, output + "(", ans);
            generateAllBalancedParenthesis(m, n-1, output + ")", ans);
        }

        return ans;
    }

    private static List<String> generateAllBalancedParenthesis2(int m, int n, String output, List<String> ans) {

        if (m == 0 && n == 0) {
            //System.out.println(output);
            ans.add(output);
            return ans;
        }

        // until open is present
        if (m != 0) {
            generateAllBalancedParenthesis2(m - 1, n, output + "(", ans);
        }

        // when close is greater than open.
        if (n > m) {
            generateAllBalancedParenthesis(m, n-1, output + ")", ans);
        }

        return ans;
    }
}
