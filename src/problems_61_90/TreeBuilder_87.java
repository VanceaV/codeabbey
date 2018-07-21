package problems_61_90;

import java.util.Scanner;

public class TreeBuilder_87 {

	private static Scanner scan = new Scanner(System.in);
	private Node root;

	public static void main(String[] args) {

		TreeBuilder_87 tb = new TreeBuilder_87();
		tb.buildGraph();
		System.out.println(tb.root);

	}

	public void buildGraph() {

		int iter = scan.nextInt();
		for (int i = 0; i < iter; i++) {
			if (i == 0) {
				root = new Node(scan.nextInt());
				continue;
			}
			int next = scan.nextInt();
			Node currentNode = root;
			while (true) {
				if (next > currentNode.getValue()) {
					if (currentNode.getRight() == null) {
						Node newNode = new Node(next);
						currentNode.setRight(newNode);
						break;
					} else {
						currentNode = currentNode.getRight();
					}
				} else {
					if (currentNode.getLeft() == null) {
						Node newNode = new Node(next);
						currentNode.setLeft(newNode);
						break;
					} else {
						currentNode = currentNode.getLeft();
					}
				}
			}
		}
	}
}

class Node {

	private int value;
	private Node left;
	private Node right;

	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {

		return "(" + (left == null ? "-" : left) + "," + value + "," + (right == null ? "-" : right) + ")";
	}
}
