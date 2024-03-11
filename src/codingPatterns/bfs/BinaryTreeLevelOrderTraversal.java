package codingPatterns.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal.
 * You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 */


public class BinaryTreeLevelOrderTraversal {

    public static void main(String args[]) {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.right = new Node(6);

        System.out.println("Level order traversal of binary tree is: ");
        System.out.println(binaryTreeLevelOrderTraversal.printLevelOrder(tree));
    }

    public List<List<Integer>> printLevelOrder(Node node) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> level;
        int levelSize;
        Node ele;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            level = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; ++i) {
                ele = queue.poll();
                level.add(ele.data);

                if (ele.left != null) {
                    queue.add(ele.left);
                }
                if (ele.right != null) {
                    queue.add(ele.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
