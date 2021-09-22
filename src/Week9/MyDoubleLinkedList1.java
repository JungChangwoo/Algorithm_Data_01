package Week9;

public class MyDoubleLinkedList1 {

	Node first, last;

	public MyDoubleLinkedList1() {
		first =null;
		last=null;
	}
	
	public String get(int index) {
		if(!validIndex(index))
			return null;
		Node temp = first;
		for(int i=0; i<index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	private boolean validIndex(int index) {
		if (index<sizeOf(first) && index>=0)
			return true;
		else
			return false;
	}

	public void addFirst(String data) {
		//	구현 결과
		Node newNode = new Node(data, null, first);
		first = newNode;
		if (last==null)
			last=newNode;
		else
			first.next.previous=newNode;

	}
	public void addLast(String data) {
		//	구현 결과
		Node newNode = new Node(data, last, null);
		last = newNode;
		if (first==null)
			first=newNode;
		else
			last.previous.next=newNode;

	}
	public void add(int index, String data) {
		//	구현 결과
		if (index==0)
			addFirst(data);
		else if (index==sizeOf(first))
			addLast(data);
		else {
			if (!validIndex(index))
				return;
			Node temp= first;
			int i=1;
			while (i<index) {
				temp=temp.next;
				i++;
			}
			Node newNode= new Node(data, temp, temp.next);
			newNode.previous.next=newNode;
			newNode.next.previous=newNode;
		}
	}
	
	public String removeFirst() {
		if(first != null) {
			String retVal = first.data;
			first= first.next;
			if(first != null) {
				first.previous = null;
			}
			else {
				last = null;
			}
			return retVal;
		} else {
			return null;
		}
	}
	
	public String removeLast() {
		if(last != null) {
			String retVal = last.data;
			last = last.previous;
			if(last != null) {
				last.next = null;
			} else {
				first = null;
			}
			return retVal;
		} else {
			return null;
		}
	}
	
	public String remove(int index) {
		if(!validIndex(index))
			return null;
		if(index == 0) {
			return removeFirst();
		} 
		else if(index == sizeOf()-1)
			return removeLast();
		else {
			Node temp = first.next;
			int i = 1;
			while(i<index) {
				temp = temp.next;
				i++;
			}
			String retVal = temp.data;
			temp.previous.next = temp.next;
			temp.next.previous = temp.previous;
			
			return retVal;
		}
	}
	
	public int remove(String data) {
		int index = indexOf(data);
		remove(index);
		return index;
	}
	
	private int indexOf(String data) {
		Node temp = first;
		for(int i=0; i<sizeOf(); i++) {
			if(temp.data.compareTo(data) == 0)
				return i;
			temp = temp.next;
		}
		return -1;
	}
	
	private int sizeOf(Node link) {
		if (link==null)
			return 0;
		else
			return 1+sizeOf(link.next);
	}
	
	private int sizeOf() { 
		return sizeOf(first);
	}
	
	public void sort() {
		if(sizeOf()<=1)
			return;
		Node temp = first;
		Node min;
		MyDoubleLinkedList1 sortedList = new MyDoubleLinkedList1();
		while(temp != null) {
			min = findMin(temp);
			sortedList.addFirst(min.data);
			remove(min.data);
			temp = first;
		}
		first = sortedList.first;
	}
	
	private Node findMin(Node temp) {
		Node min = temp;
		while(temp.next != null) {
			temp = temp.next;
			if(temp.data.compareTo(min.data)>0) {
				min = temp;
			}
		}
		return min;
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
