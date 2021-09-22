package Week12;

public class Node {
	char data;
	Node left;
	Node right;
	Node parent;
	
	public Node(char val) {
		data = val;
		left = null;
		right = null;
		parent = null;
	}
	
	public String toString() {
		return ""+data;
	}
}
