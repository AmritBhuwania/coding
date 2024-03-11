package codingPatterns.dfs;

/**
 * Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that
 * the sum of all the node values of that path equals ‘S’.
 */
public class BinaryTreePathSum {

    public static void main(String args[]) {
        BinaryTreePathSum treePathSum = new BinaryTreePathSum();
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.right = new Node(6);

        System.out.println("Level order traversal of binary tree is: ");
        System.out.println(treePathSum.binaryTreePathSum(tree, 10));
    }

    private boolean binaryTreePathSum(Node root, int sum) {

        if (root == null) return false;

        if (root.left == null && root.right == null && root.data == sum) {
            return true;
        }

        return binaryTreePathSum(root.left, sum - root.data) || binaryTreePathSum(root.right, sum - root.data);

    }
}
