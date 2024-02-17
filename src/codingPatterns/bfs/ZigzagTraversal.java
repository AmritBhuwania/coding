package codingPatterns.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent its zigzag level order traversal.
 * You should populate the values of all nodes of the first level from left to right,
 * then right to left for the next level and keep alternating in the same manner for the following levels.
 */
public class ZigzagTraversal {

    public static void main(String args[]) {
        ZigzagTraversal zigzagTraversal = new ZigzagTraversal();
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.right = new Node(6);

        System.out.println("Reverse level order traversal of binary tree is: ");
        System.out.println(zigzagTraversal.printZigzagTraversal(tree));
    }

    private List<List<Integer>> printZigzagTraversal(Node tree) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> level;
        int levelSize;
        Node ele;
        int x = -1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            level = new ArrayList<>(levelSize);
            ++x;

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

            if (x % 2 == 0)
                ans.add(level);
            else
                ans.add(level.reversed());
        }
        return ans;
    }
}
