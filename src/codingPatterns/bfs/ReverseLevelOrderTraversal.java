package codingPatterns.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal in reverse order, i.e.,
 * the lowest level comes first.
 * You should populate the values of all nodes in each level from left to right in separate sub-arrays.
 */
public class ReverseLevelOrderTraversal {

    public static void main(String args[]) {
        ReverseLevelOrderTraversal reverseLevelOrderTraversal = new ReverseLevelOrderTraversal();
        Node tree = new Node(12);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.right = new Node(1);

        System.out.println("Reverse level order traversal of binary tree is: ");
        System.out.println(reverseLevelOrderTraversal.printReverseLevelOrder(tree));
    }

    private List<List<Integer>> printReverseLevelOrder(Node tree) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> levelList;
        int levelSize;

        if (tree == null) {
            return new ArrayList<>();
        }

        queue.add(tree);

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            levelList = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; ++i) {
                Node ele = queue.poll();
                levelList.add(ele.data);

                if (ele.left != null) {
                    queue.add(ele.left);
                }
                if (ele.right != null) {
                    queue.add(ele.right);
                }
            }

            ans.add(0, levelList); // OR, ans.addFirst(levelList);
        }
        return ans;
    }
}
