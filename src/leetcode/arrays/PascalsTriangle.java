package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/description/
 */
public class PascalsTriangle {
    public static void main(String[] args) {

        int k = 5;
        System.out.println(new PascalsTriangle().generate(k));
   }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        if (numRows >= 1) {
            ans.add(List.of(1));
            if (numRows == 1) return ans;
        }

        if (numRows >= 2) {
            ans.add(List.of(1, 1));
            if (numRows == 2) return ans;
        }

        for (int k = 3; k <= numRows; ++k) {
            List<Integer> tempList = new ArrayList<>(k);
            for (int i = 0; i < k ; ++i) {
                if (i == 0) {
                    tempList.add(ans.get(k-2).get(0));
                } else if (i == k-1) {
                    tempList.add(ans.get(k-2).get(i-1));
                } else {
                    int value = ans.get(k-2).get(i-1) + ans.get(k-2).get(i);
                    tempList.add(value);
                }
            }
            ans.add(tempList);
        }
        return ans;
    }

}
