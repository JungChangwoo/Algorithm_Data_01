package Week14;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreePlus {
	
	double PROBCHILD = 0.7;
	
	Node root;
	
	public TreePlus() {
		root = null;
	}
	
	public void makeTree(int [] input) {
		if(input.length == 0) {
			return;
		}
		Deque<Node> q = new ArrayDeque<Node>();
		root = new Node(input[0], null, null, null);
		q.add(root);
		int currentIndex=1;
		makeTreeIteration(input, currentIndex, q);
	}

	private void makeTreeIteration(int[] input, int currentIndex, Deque<Node> q) {
		while(q.size() > 0 && currentIndex < input.length) {
			Node node = q.poll();
			double pLeft = Math.random();
			double pRight = Math.random();
			if(pLeft<PROBCHILD || (pLeft >= PROBCHILD) && (pRight >= PROBCHILD)) {
				node.left = new Node(input[currentIndex++], null, null, node);
				q.add(node.left);
			}
			if(pRight<PROBCHILD) {
				node.right = new Node(input[currentIndex++], null, null, node);
				q.add(node.right);
			}
		}
	}
	
	public void showTree() {
		show(root);
	}
	
	private void show(Node node) {
		if(node == null) {
			System.out.print("  ---");
		}
		else {
			System.out.print("  "+node.key);
			show(node.left);
			show(node.right);
		}
	}
	
	public int maxDepth() {
		return maxDepth(root);
	}
	
	private int maxDepth(Node node) {
		if(node == null) {
			return 0;
		}
		else {
			return Math.max(maxDepth(node.left), maxDepth(node.right))+1;
		}
	}
	
	public String maxPath() {
		return maxPath(root);
	}
	
	private String maxPath(Node node) {
		if(node == null) {
			return null;
		}
		else if(maxDepth(node.left) >= maxDepth(node.right)) {
			return node.key + " - "+ maxPath(node.left);
		}
		else {
			return node.key + " - " + maxPath(node.right);
		}
	}

	public static void main(String[] args) {
		int inputSize = 30;
		int [] data = new int [inputSize];
		
		for(int i=0; i<inputSize; i++) {
			data[i] = i*10;
		}
		
		TreePlus t = new TreePlus();
		
		t.makeTree(data);
		t.showTree();
		
		System.out.println("\nMax. Depth : "+t.maxDepth());
		System.out.println("\nMax. Path : "+t.maxPath());

	}
	
	class Node {
		int key;
		Node left, right, parent;
		
		public Node(int c, Node l, Node r, Node p) {
			key = c;
			left = l;
			right = r;
			parent = p;
		}
		
		public String toString() {
			return ""+key;
		}
	}

}
