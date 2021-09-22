package MidTerm;

public class MyDoubleLinkedList1 {

	Node first, last;
	
	//갯수 세기
	int numOfNode;

	public MyDoubleLinkedList1() {
		first =null;
		last=null;
		numOfNode = 0;
	}

	private boolean validIndex(int index) {
		if (index<sizeOf(first) && index>=0)
			return true;
		else
			return false;
	}

	public void addFirst(String data) {
		//	구현하시오!
		Node newNode = new Node(data, null, first);
		first = newNode;
		numOfNode++;
		if(first == null) {
			first = last;
		}
	}
	public void addLast(String data) {
		//	구현하시오!
		if(numOfNode == 0) {
			addFirst(data);
		}
		else {
			Node newNode = new Node(data, last, null);
			last = newNode;
			numOfNode++;
		}
	}
	public void add(int index, String data) {
		//	구현하시오!
		if(index == 0) {
			addFirst(data);
		} else if (index == numOfNode) {
			addLast(data);
		} else {
			
			
		}

		
	}
	private int sizeOf(Node link) {
		if (link==null)
			return 0;
		else
			return 1+sizeOf(link.next);
	}

	public String toString() {
		Node temp = first;
		String retVal="";
		while(temp!=null) {
			retVal=retVal+"/"+temp.data.toString();
			temp=temp.next;
		}
		return retVal;
	}

	public static void main(String[] args) {

		MyDoubleLinkedList1 list = new MyDoubleLinkedList1();

		list.addLast("lee");
		System.out.println(list.toString());
		list.addFirst("kim");
		System.out.println(list.toString());
		list.addLast("park");
		System.out.println(list.toString());
		list.add(1, "choi");
		System.out.println(list.toString());
		list.addFirst("jung");
		System.out.println(list.toString());
		list.add(0, "hong");
		System.out.println(list.toString());

	}

	private class Node{
		String data;
		Node previous;
		Node next;
		private Node(String input, Node f, Node n) {
			data=input;
			previous = f;
			next=n;
		}
	}

}
