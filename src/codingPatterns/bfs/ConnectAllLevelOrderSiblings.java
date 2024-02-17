package codingPatterns.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, connect each node with its level order successor.
 * The last node of each level should point to the first node of the next level.
 */
public class ConnectAllLevelOrderSiblings {
    public static void main(String args[]) throws InterruptedException {
        ConnectAllLevelOrderSiblings connectAllLevelOrderSiblings = new ConnectAllLevelOrderSiblings();

        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.right = new Node(6);

        System.out.println("Level order traversal of binary tree is: ");
        Node head = connectAllLevelOrderSiblings.connectAllLevelOrderSiblings(tree);

        while (head != null) {
            System.out.print(head.data + ",");
            head = head.next;
        }
    }

    private Node connectAllLevelOrderSiblings(Node tree) {

        if (tree == null) return tree;
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);
        Node prevNode = null, curr;

        while (!queue.isEmpty()) {
            curr = queue.poll();

            if (prevNode == null) {
                prevNode = curr;
            } else {
                prevNode.next = curr;
                prevNode = curr;
            }

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        return tree;

    }
}
