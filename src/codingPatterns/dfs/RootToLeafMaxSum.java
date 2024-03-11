package codingPatterns.dfs;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafMaxSum {

    static int max;
    public static void main(String args[]) {
        RootToLeafMaxSum rootToLeafMaxSum = new RootToLeafMaxSum();
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
        max = Integer.MIN_VALUE;
        rootToLeafMaxSum.rootToLeafMaxSum(tree, currentPath, allPaths);
        System.out.println(max);

        for (List<Integer> path : allPaths) {
            int sum = path.parallelStream().reduce(0, Integer::sum);
            if (sum == max) {
                System.out.println(path);
            }
        }
    }

    private void rootToLeafMaxSum(Node node, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null) return;

        currentPath.add(node.data);
        if (node.left == null && node.right == null) {
            allPaths.add(List.copyOf(currentPath));
            int sum = currentPath.stream().reduce(0, Integer::sum);
            max = Math.max(sum, max);
        }

        rootToLeafMaxSum(node.left, currentPath, allPaths);
        rootToLeafMaxSum(node.right, currentPath, allPaths);

       currentPath.removeLast();

    }
}
