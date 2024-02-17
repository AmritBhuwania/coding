package codingPatterns.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent the averages of all of its levels.
 */
public class LevelAveragesInBinaryTree {
    public static void main(String args[]) {
        LevelAveragesInBinaryTree levelAveragesInBinaryTree = new LevelAveragesInBinaryTree();
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.right = new Node(6);

        System.out.println("Level order traversal of binary tree is: ");
        System.out.println(levelAveragesInBinaryTree.levelAverages(tree));
    }

    public List<Double> levelAverages(Node node) {

        List<Double> ans = new ArrayList<>();
        double levelSum;
        int levelSize;
        Node ele;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            levelSum = 0.0;

            for (int i = 0; i < levelSize; ++i) {
                ele = queue.poll();
                levelSum += ele.data;

                if (ele.left != null) {
                    queue.add(ele.left);
                }
                if (ele.right != null) {
                    queue.add(ele.right);
                }
            }
            ans.add(levelSum/levelSize);
        }
        return ans;
    }
}
