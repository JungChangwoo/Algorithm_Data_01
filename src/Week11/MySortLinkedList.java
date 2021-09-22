package Week11;

public class MySortLinkedList {
	
	Node first = null;
	int nOfCompare;
	
	public void insertAscendingOrder(int input) {
		nOfCompare = 0;
		if(first == null) {
			first = new Node(input);
			return;
		}
		if(first.value > input) {
			Node temp = new Node(input);
			temp.next = first;
			first = temp;
			return;
		}
		Node p = first;
		Node q = first.next;
		
		while(q != null && q.value < input) {
			nOfCompare++;
			p = q;
			q=q.next;
		}
		p.next = new Node(input);
		p.next.next = q;
		
	}
	
	public int getStatCompare() {
		return this.nOfCompare;
	}
	
	public int removeFirst() {
		if(first != null) {
			int result = first.value;
			first = first.next;
			return result;
		}
		else {
			return -9999;
		}
	}
	
	private class Node{
		int value;
		Node next;
		private Node(int input) {
			this.value = input;
			this.next = null;
		}
	}
}
