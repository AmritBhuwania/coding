package codingPatterns.dfs;

public class HeightOfTree {
    public static void main(String[] args) {
        HeightOfTree heightOfTree = new HeightOfTree();
        Node tree = new Node(1);
        tree.left = new Node(7);
        tree.right = new Node(9);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(2);
        tree.right.right = new Node(7);
        tree.right.right.right = new Node(8);

        System.out.println(heightOfTree.treeHeight(tree));
    }

    private int treeHeight(Node tree) {
        if (tree == null) {
            return 0;
        }

        return Math.max(treeHeight(tree.left), treeHeight(tree.right)) + 1;
    }
}
