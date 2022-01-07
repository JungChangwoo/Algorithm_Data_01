package Week13;

import java.util.ArrayDeque;
import java.util.Deque;

public class HeapTree {
	
	Node heap;  // root
	Node last;  // last

	public HeapTree() {
		heap = null;
		last = null;
	}

	public void heapSort(char[] input) {
		buildHeap(input);
		preOrderTraverse(heap);
		System.out.println();
		inOrderTraverse(heap);
		System.out.println();
		postOrderTraverse(heap);
		System.out.println();
//		sortOut2();                                                                                                                              
		sortOut();
	}
	
	private void sortOut() {
		System.out.println("< Max.Heap >");
		
		while(heap != null) {
			System.out.println(deleteHeap()+"  "+toString());
		}
	}
	
	private void sortOut2() {
		System.out.println("< Max.Heap >");
		
		while(heap != null) {
//			System.out.println(deleteHeap()+"  "+toString2());
		}
	}

	private Character deleteHeap() {
		if(heap == null) {
			return null;
		}
		char retVal = heap.key;
		
		if(heap == last) {
			heap = null;
			last = null;
		}
		else {
			heap.key = last.key;
			Node prev = getPrev(last);
			
			//������ Node�� ����
			if(last == last.parent.left) {
				last.parent.left = null;
			}
			else {
				last.parent.right = null;
			}
			last = prev;
			
			heapifyDownward(heap);
		}
		
		return retVal;
	}

	private Node getPrev(Node node) {
		if(node == null || node == heap) {
			return node;
		}
		// right�� last�϶�
		if(node.parent.right != null) {
			return node.parent.left;
		}
		// last�� left�϶�, 2���� ���̽� ���
		Node p = node;
		while(p.parent != null && p == p.parent.left) {
			p = p.parent;
		}
		// ���� last�� ���� ���� �ƴ϶��
		if(p.parent != null) {
			p = p.parent.left;
		}
		while(p.right != null) {
			p = p.right;
		}
		return p;
	}

	private void heapifyDownward(Node node) {
		if (node == null || node.left == null) {
			return;
		}
		Node larger = node.left;
		if(node.right != null && node.right.key > node.left.key) {
			larger = node.right;
		}
		if(larger.key > node.key) { //�ڽ��� �θ𺸴� ũ�ٸ�,,, �ٲٰ� �ٽ� Recursion
			swap(larger, node);
			heapifyDownward(larger);
		}
		
	}
	// �θ� �ڽ� ���� ����
	private void heapifyUpward(Node node) {
		// �ڽĳ�尡 ���µ� �ڽĳ��� �����԰ų� index�� 0�� ��, null�� �κп� �����ϸ� return
		if(node == null || node.left == null) {
			return;
		}
		// left right �� ���� �� ū�� �𸣱� ������ �켱 left�� ����
		Node larger = node.left;
		// right �ڽ��� �ְ� right�� �θ𺸴� ũ�ٸ�, ��ȯ���� �ڽ��� right�� ����
		if (node.right != null && node.right.key > node.left.key) {
			larger = node.right;
		}
		// �ڽ��� �θ𺸴� ũ�ٸ�, ��ȯ
		if (larger.key > node.key) {
			swap(larger, node);
			heapifyUpward(node.parent);
		}

	}

	private void buildHeap(char[] input) {
		System.out.println("<< Heap implemented in Linked-Tree >>");
		for (int i = 0; i < input.length; i++) {
			insertHeap(input[i]);
		}
	}

	private void insertHeap(char c) {
		// ó���̶��
		if(heap == null) {
			heap = new Node(c, null, null, null);
			last = heap;
			return;
		}
		// ��� �־���� ���� �˱� ����(���� �θ� �־�� ���� ���� �θ� �־�� ����
		Node pNext = getParentOfNext(last);
		// ���ο� ��� ����� �θ�� pNext
		last = new Node(c, null, null, pNext);
		// left�� ���ٸ� last�� left��
		if(pNext.left == null) {
			pNext.left = last;
		}
		// right�� ���ٸ� last�� right��
		else {
			pNext.right = last;
		}
		// �ְ��� ���� 
		heapifyUpward(last.parent);
		System.out.println(toString());
	}

	private Node getParentOfNext(Node node) {
		if(node == null || node == heap) {
			return node;
		}
		// left�� last�϶�
		if(node.parent.right == null) {
			return node.parent;
		}
		// last�� right�϶�, 2���� ���̽� ���
		Node p = node;
		while(p.parent != null && p == p.parent.right) {
			p = p.parent;
		}
		// ���� last�� ������ ���� �ƴ϶��
		if(p.parent != null) {
			p = p.parent.right;
		}
		while(p.left != null) {
			p = p.left;
		}
		return p;
	}

	private void swap(Node a, Node b) {
		char temp = a.key;
		a.key = b.key;
		b.key = temp;
	}
	
	public String toString() {
		if(heap == null) {
			return null;
		}
		Deque<Node> q = new ArrayDeque<Node>();
		q.add(heap);
		return levelOrderTraverse(q, "");
	}
	
//	public String toString2() {
//		if(heap == null) {
//			return null;
//		}
//		Stack<Node> q = new Stack<Node>();
//		q.push(heap);
//		return levelOrderTraverseQ(q, "");
//	}
	
	private void preOrderTraverse(Node t) {
		if(t != null) {
			System.out.print(t.key+" ");
			preOrderTraverse(t.left);
			preOrderTraverse(t.right);
		}
	}
	
	private void inOrderTraverse(Node t) {
		if(t != null) {
			inOrderTraverse(t.left);
			System.out.print(t.key+" ");
			inOrderTraverse(t.right);
		}
	}
	
	private void postOrderTraverse(Node t) {
		if(t != null) {
			postOrderTraverse(t.left);
			postOrderTraverse(t.right);
			System.out.print(t.key+" ");
		}
	}
	
	// Queue ����
	private String levelOrderTraverse(Deque<Node> q, String retString) {
		Node node = q.poll();
		if(node == null) {
			return retString;
		}
		retString = retString + "  "+node.key;
		if(node.left != null) {
			q.add(node.left);
			if(node.right != null) {
				q.add(node.right);
			}
		}
		return levelOrderTraverse(q, retString);
	}
	
//	// Stack ����
//	private String levelOrderTraverseQ(Stack<Node> s, String retString) {
//		Node node = s.pop();
//		if(node == null) {
//			return retString;
//		}
//		retString = retString + "  "+node.key;
//		if(node.left != null) {
//			s.push(node.left);
//			retString = retString + "  "+node.key;
//			if(node.right != null) {
//				s.push(node.right);
//			}
//		}
//		return levelOrderTraverseQ(s, retString);
//		
//	}

	public static void main(String[] args) {
		char[] data = { 'M', 'Y', 'U', 'N', 'G', 'I', 'S', 'W' };

		HeapTree h = new HeapTree();

		h.heapSort(data);
	

	}
	
	class Node {
		char key;
		Node left, right, parent;
		
		public Node(char c, Node l, Node r, Node p) {
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
