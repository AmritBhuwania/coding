package codingPatterns.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the minimum depth of a binary tree.
 * The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String args[]) {
        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.right = new Node(6);

        System.out.println("Reverse level order traversal of binary tree is: ");
        System.out.println(minimumDepthOfBinaryTree.minimumDepthBinaryTree(tree));
    }

    private int minimumDepthBinaryTree(Node tree) {

        if (tree == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);
        int minimumDepth = 0;

        while (!queue.isEmpty()) {
            ++minimumDepth;
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                Node ele = queue.poll();
                if (ele.right == null && ele.left == null) {
                    return minimumDepth;
                }

                if (ele.left != null) {
                    queue.add(ele.left);
                }

                if (ele.right != null) {
                    queue.add(ele.right);
                }
            }
        }

        return minimumDepth;

    }
}
