package codingPatterns.dfs;

/**
 * Given a binary tree, find the length of its diameter.
 * The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
 * The diameter of a tree may or may not pass through the root.
 */
public class PathWithMaximumSum {

    static int maxSum = 0;
    public static void main(String[] args) {
        PathWithMaximumSum pathWithMaximumSum = new PathWithMaximumSum();
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        tree.right.right.right = new Node(8);


        System.out.println(pathWithMaximumSum.pathWithMaximumSum(tree));
        System.out.println(maxSum);
    }

    private int pathWithMaximumSum(Node tree) {
        if (tree == null) {
            return 0;
        }

        int leftPathSum = pathWithMaximumSum(tree.left);
        int rightPathSum = pathWithMaximumSum(tree.right);

        leftPathSum = Math.max(leftPathSum, 0);
        rightPathSum = Math.max(rightPathSum, 0);

        int currSum = leftPathSum + rightPathSum + tree.data;
        maxSum = Math.max(currSum, maxSum);

        return Math.max(leftPathSum, rightPathSum) + tree.data;
    }
}
