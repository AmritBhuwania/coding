package codingPatterns.dfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FindAllPathsForASum {
    public static void main(String args[]) {
        FindAllPathsForASum findAllPathsForASum = new FindAllPathsForASum();
        Node tree = new Node(1);
        tree.left = new Node(7);
        tree.right = new Node(9);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(2);
        tree.right.right = new Node(7);

        System.out.println("Level order traversal of binary tree is: ");
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();
        findAllPathsForASum.findAllPathsForASum(tree, 12, currentPath, allPaths);
        System.out.println(allPaths);

    }

    private void findAllPathsForASum(Node node, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null) {
            return;
        }
        currentPath.add(node.data);

        if (node.data == sum && node.left == null && node.right == null) {
            // we need to create a copy since currentPath object is finally becoming empty bcoz of L40 currentPath.removeLast();
            allPaths.add(List.copyOf(currentPath));  // OR, allPaths.add(new ArrayList<>(currentPath));
        } else {
            findAllPathsForASum(node.left, sum - node.data, currentPath, allPaths);
            findAllPathsForASum(node.right, sum - node.data, currentPath, allPaths);
        }
        currentPath.removeLast();
    }
}
