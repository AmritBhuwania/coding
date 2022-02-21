package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amrit
 * Given a invalid BST with utmost 2 nodes out of place. Find those nodes and swap them to make it a valid BST
 */

public class MakeBstValid {

	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(1);
		root.left.right = new Node(6);

		MakeBstValid makeBstValid = new MakeBstValid();
		makeBstValid.printTree(root);

		// pass the parent node also to the current node to handle the edge case 
		List<ParentChildNode> nodes = makeBstValid.findInValidNode(null, root, Integer.MIN_VALUE, Integer.MAX_VALUE, new ArrayList<ParentChildNode>());

		for (ParentChildNode childNode: nodes) {
			System.out.println(childNode);
		}

		// Edge cases when we only have 1 of the node out of place. Then just swap the node and its parent
		if (nodes.size() == 1) {
			makeBstValid.swap(nodes.get(0).parent, nodes.get(0).child);
		} else {
			makeBstValid.swap(nodes.get(0).child, nodes.get(1).child);
		}

		makeBstValid.printTree(root);
	}

	private List<ParentChildNode> findInValidNode(Node parent, Node root, int min, int max, List<ParentChildNode> inValidNodes) {

		if (root == null) {
			return inValidNodes;
		}

		if (inValidNodes.size() > 1) {
			return inValidNodes;
		}

		System.out.println("Curent node: " + root);

		if (null != root && root.data > max) {
			inValidNodes.add(new ParentChildNode(parent, root));
		}

		if (null != root && root.data < min) {
			inValidNodes.add(new ParentChildNode(parent, root));
		}

		findInValidNode(root, root.left, min, root.data, inValidNodes);
		findInValidNode(root, root.right, root.data, max, inValidNodes);	

		return inValidNodes;
	}

	void printTree (Node root) {
		if (root == null) {
			return;
		}

		printTree(root.left);
		System.out.print(root.data + ", ");
		printTree(root.right);
	}

	private void swap(Node node1, Node node2) {
		int temp = node1.data;
		node1.data = node2.data;
		node2.data = temp;
	}
}

class ParentChildNode {
	Node parent;
	Node child;
	public ParentChildNode(Node parent, Node child) {
		super();
		this.parent = parent;
		this.child = child;
	}
	@Override
	public String toString() {
		return "ParentChildNode [parent=" + parent + ", child=" + child + "]";
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Node(int data) {
		super(); 
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
}