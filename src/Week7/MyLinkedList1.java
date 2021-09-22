package Week7;

public class MyLinkedList1 {

	// head
	Node first;
	int numOfNode;

	public MyLinkedList1() {
		first = null;
		numOfNode = 0;
	}

	public String get(int index) {
		if (!validIndex(index)) {
			return null;
		}
		Node temp = first;
		for (int i = 0; i < index; i++) {
			temp = temp.link;
		}
		return temp.data;
	}

	// �ùٸ� �ε����� �Է��ߴ��� Ȯ�����ִ� �Լ�
	private boolean validIndex(int index) {
		if (index < numOfNode && index >= 0)
			return true;
		else
			return false;
	}

	public void set(int index, String data) {
		if (!validIndex(index)) {
			return;
		}
		Node temp = first;
		for (int i = 0; i < index; i++) {
			temp = temp.link;
		}
		temp.data = data;
	}

	public void addFirst(String data) {
		Node newNode = new Node(data, first);
		first = newNode;
		numOfNode++;
	}

	public void addLast(String data) {
		if (numOfNode == 0) {
			addFirst(data);
		} else {
			Node temp = first;
			while (temp.link != null) {
				temp = temp.link;
			}

			temp.link = new Node(data, null);
			numOfNode++;
		}
	}

	public void add(int index, String data) {
		if (index == 0) {
			addFirst(data);
		} else if (index == numOfNode) {
			addLast(data);
		} else {
			if (!validIndex(index)) {
				return;
			}
			Node temp = first;
			int i = 0;
			while (i < index - 1) {
				temp = temp.link;
				i++;
			}
			temp.link = new Node(data, temp.link);
			numOfNode++;
		}
	}

	public String removeFirst() {
		if (first != null) {
			String retVal = first.data;
			// �ΰ��� �ִٰ� �����ϸ�, ���� first.link�� ����Ű�� ���� �� ���� Node�̴�
			// �� �� ���� Node�� first�� �����ϰڴٴ� ���̴�. ��, ù ���� Node�� remove�� ���̴�.
			// ���� Node�� �ϳ��ۿ� ���ٸ�, first.link�� null�̱� ������, first�� null�� �� ���̴�.
			first = first.link;
			numOfNode--;
			return retVal;
		} else {
			return null;
		}
	}

	public String removeLast() {
		if (first != null) {
			Node temp = first;
			// ������ Node ���� ���߱� ���ؼ�
			Node tempNext = temp.link;
			while (tempNext.link != null) {
				temp = tempNext;
				tempNext = tempNext.link;
			}
			temp.link = null;
			numOfNode--;
			return tempNext.data;
		} else {
			return null;
		}
	}

	public String remove(int index) {
		if (!validIndex(index)) {
			return null;
		} else if (index == numOfNode - 1) {
			return removeLast();
		} else {
			Node temp = first;
			Node tempNext = temp.link;
			int i = 0;
			while (i < index - 1) {
				temp = tempNext;
				tempNext = tempNext.link;
				i++;
			}
			temp.link = tempNext.link;
			numOfNode--;
			return tempNext.data;
		}
	}
	
	//���� ���� indexOf�Լ� ȣ���ؼ� index�� ã�� remove(int index)�� �ٽ� ȣ���ϴ� ��
	//But, �׷��� �Ǹ� �ݺ��� �� ���̳� �ϰ� ��
	public int remove(String data) {
		Node temp = first;
		//ó���̸� ���� Node�� first�� ������
		if (temp.data.compareTo(data) == 0) {
			first = temp.link;
			numOfNode--;
			return 0;
		}
		Node tempNext = temp.link;
		int i = 1;
		while(tempNext != null) {
			if(tempNext.data.compareTo(data)==0) {
				temp.link = tempNext.link;
				numOfNode--;
				return i;
			}
			else {
				temp = tempNext;
				tempNext = tempNext.link;
				i++;
			}
		}
		return -1;
	}

	private int indexOf(String data) {
		Node temp = first;
		for(int i=0; i<numOfNode; i++) {
			if(temp.data.compareTo(data) == 0) {
				return i;
			}
			else {
				temp = temp.link;
			}
		}
		return -1;
	}

	public int sizeOf() {
		return numOfNode;
	}
	
	public void sort() {
		if(numOfNode <= 1) {
			return;
		}
		Node temp = first;
		//���ο� List�� �ϳ��� ��� �� Node�� ������
		Node max;
		//���ο� List�� ������
		MyLinkedList1 sortedList = new MyLinkedList1();
		//���� List�� �����ִ� Node�� �ϳ��� ���� ������
		while(temp != null) {
			//max Node�� temp�� �ѹ��� ���� ���� ū Node��
			max = findMax(temp);
			//���ο� List�� �տ������� maxNode�� �߰���
			sortedList.addFirst(max.data);
			//���� List���� max�� remove
			remove(max.data);
			//�ٽ� �پ�� List�� �������ϱ� ���� first ������
			temp = first;
		}
		//first�� ������ ���ο� List�� ����Ŵ
		first = sortedList.first;
		//Node�� ������ ���ο� List�� Node�� ������ ����Ŵ
		numOfNode = sortedList.numOfNode;
	}
	
	private Node findMax(Node temp) {
		Node max = temp;
		while(temp.link != null) {
			temp = temp.link;
			if(temp.data.compareTo(max.data) > 0 ) {
				max = temp;
			}
		}
		return max;
	}

	public String toString() {
		Node temp = first;
		String retVal = "";
		while(temp != null) {
			retVal += "/"+temp.data.toString();
			temp = temp.link;
		}
		return retVal;
	}

	public static void main(String[] args) {
		MyLinkedList1 list = new MyLinkedList1();

		list.add(list.sizeOf(), "lee");
		list.add(list.sizeOf(), "kim");
		list.add(list.sizeOf(), "park");
		System.out.println(list.toString());

		list.add(1, "choi");
		list.add(1, "jung");
		list.add(0, "hong");
		System.out.println(list.toString());
		list.add(list.sizeOf(), "cha");
		list.add(list.sizeOf(), "song");

		System.out.println(list.toString());
		list.sort();
		System.out.println(list.sizeOf());
		System.out.println(list.toString());
	}

	private class Node {
		String data;
		Node link;

		private Node(String input, Node next) {
			data = input;
			link = next;
		}
	}

}
