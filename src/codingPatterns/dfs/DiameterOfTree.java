package codingPatterns.dfs;

/**
 * Given a binary tree, find the length of its diameter.
 * The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
 * The diameter of a tree may or may not pass throu
 */
public class DiameterOfTree {

    static int treeDiameter = 0;
    public static void main(String[] args) {
        DiameterOfTree diameterOfTree = new DiameterOfTree();
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        tree.right.right.right = new Node(8);


        System.out.println(diameterOfTree.treeHeight(tree));
        System.out.println(treeDiameter);
    }

    private int treeHeight(Node tree) {
        if (tree == null) {
            return 0;
        }

        int leftTreeHeight = treeHeight(tree.left);
        int rightTreeHeight = treeHeight(tree.right);

        int currDiameter = leftTreeHeight + rightTreeHeight + 1;
        treeDiameter = Math.max(currDiameter, treeDiameter);

        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
}
