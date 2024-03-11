package codingPatterns.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllRootToLeafPaths {
    public static void main(String args[]) {
        AllRootToLeafPaths allRootToLeafPaths = new AllRootToLeafPaths();
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
        allRootToLeafPaths.allRootToLeafPaths(tree, currentPath, allPaths);
        System.out.println(allPaths);
    }

    private void allRootToLeafPaths(Node node, List<Integer> currentPath, List<List<Integer>> allPaths){
        if (node == null) return;

        currentPath.add(node.data);
        if (node.left == null && node.right == null) {
            allPaths.add(List.copyOf(currentPath));
        }

        allRootToLeafPaths(node.left, currentPath, allPaths);
        allRootToLeafPaths(node.right, currentPath, allPaths);

        currentPath.removeLast();
    }
}
