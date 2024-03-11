package codingPatterns.dfs;

public class SumOfPathNumbers {
    public static void main(String args[]) {
        SumOfPathNumbers sumOfPathNumbers = new SumOfPathNumbers();
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.right = new Node(6);

        System.out.println("Level order traversal of binary tree is: ");
        System.out.println(sumOfPathNumbers.sumOfPathNumbers(tree, 0));
    }

    private int sumOfPathNumbers(Node root, int pathSum) {

        if (root == null) return 0;

        pathSum = pathSum * 10 + root.data;

        if (root.left == null && root.right == null) {
            return pathSum;
        }

        return sumOfPathNumbers(root.left,  pathSum) + sumOfPathNumbers(root.right, pathSum);

    }
}
