package codingPatterns.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Given a binary tree and a number ‘S’,
 * find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
 * Please note that the paths can start or end at any node but all paths
 * must follow direction from parent to child (top to bottom).
 */
public class CountPathsForASum {

    public static void main(String args[]) {
        CountPathsForASum countPathsForASum = new CountPathsForASum();
        Node tree = new Node(1);
        tree.left = new Node(7);
        tree.right = new Node(9);
        tree.left.left = new Node(6);
        tree.left.right = new Node(5);
        tree.right.left = new Node(2);
        tree.right.right = new Node(3);

        List<Integer> currentPath = new ArrayList<>();
        System.out.println(countPathsForASum.countPathsForASum(tree, 12, currentPath));

    }

    private int countPathsForASum(Node node, int sum, List<Integer> currentPath) {
        if (node == null) {
            return 0;
        }

        currentPath.add(node.data);
        int currSum = 0, count = 0;

        ListIterator<Integer> listIterator = currentPath.listIterator(currentPath.size());
        while (listIterator.hasPrevious()) {
            currSum += listIterator.previous();
            if (currSum == sum) {
                ++count;
            }
        }

        count += countPathsForASum(node.left, sum, currentPath);
        count += countPathsForASum(node.right, sum, currentPath);

        currentPath.removeLast();

        return count;
    }
}
