package codingPatterns.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree and a node, find the level order successor of the given node in the tree.
 * The level order successor is the node that appears right after the given node in the level order traversal.
 */
public class LevelOrderSuccessor {
    public static void main(String args[]) {
        LevelOrderSuccessor levelOrderSuccessor = new LevelOrderSuccessor();

        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.right = new Node(6);

        System.out.println("Level order traversal of binary tree is: ");
        System.out.println(levelOrderSuccessor.levelOrderSuccessor(tree, 5));
    }

    private Integer levelOrderSuccessor(Node tree, int key) {

        if (tree == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            Node ele = queue.poll();

            if (ele.left != null) {
                queue.add(ele.left);
            }
            if (ele.right != null) {
                queue.add(ele.right);
            }

            if (ele.data == key)
                break;
        }
        return queue.peek() == null ? -1 : queue.poll().data;
    }
}
