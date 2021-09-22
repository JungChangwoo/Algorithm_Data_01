package Week7;

//Comparable�� ��ӹ޾ƾ� CompareTo�� ���� ����
public class MyLinkedList<T extends Comparable<T>> {

	// head
	Node<T> first;
	int numOfNode;

	public MyLinkedList() {
		first = null;
		numOfNode = 0;
	}

	public T get(int index) {
		if (!validIndex(index)) {
			return null;
		}
		Node<T> temp = first;
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

	public void set(int index, T data) {
		if (!validIndex(index)) {
			return;
		}
		Node<T> temp = first;
		for (int i = 0; i < index; i++) {
			temp = temp.link;
		}
		temp.data = data;
	}

	public void addFirst(T data) {
		System.out.println(">> AddFirst " + data.toString());
		Node<T> newNode = new Node<>(data, first);
		first = newNode;
		numOfNode++;
	}

	public void addLast(T data) {
		if (numOfNode == 0) {
			addFirst(data);
		} else {
			Node<T> temp = first;
			while (temp.link != null) {
				temp = temp.link;
			}

			temp.link = new Node<>(data, null);
			numOfNode++;
		}
	}

	public void add(int index, T data) {
		if (index == 0) {
			addFirst(data);
		} else if (index == numOfNode) {
			addLast(data);
		} else {
			if (!validIndex(index)) {
				return;
			}
			Node<T> temp = first;
			int i = 0;
			while (i < index - 1) {
				temp = temp.link;
				i++;
			}
			temp.link = new Node<>(data, temp.link);
			numOfNode++;
		}
	}

	public T removeFirst() {
		if (first != null) {
			T retVal = first.data;
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

	public T removeLast() {
		if (first != null) {
			Node<T> temp = first;
			// ������ Node ���� ���߱� ���ؼ�
			Node<T> tempNext = temp.link;
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

	public T remove(int index) {
		if (!validIndex(index)) {
			return null;
		} else if (index == numOfNode - 1) {
			return removeLast();
		} else {
			Node<T> temp = first;
			Node<T> tempNext = temp.link;
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

	// ���� ���� indexOf�Լ� ȣ���ؼ� index�� ã�� remove(int index)�� �ٽ� ȣ���ϴ� ��
	// But, �׷��� �Ǹ� �ݺ��� �� ���̳� �ϰ� ��
	public int remove(T data) {
		Node<T> temp = first;
		// ó���̸� ���� Node�� first�� ������
		if (temp.data.compareTo(data) == 0) {
			first = temp.link;
			numOfNode--;
			return 0;
		}
		Node<T> tempNext = temp.link;
		int i = 1;
		while (tempNext != null) {
			if (tempNext.data.compareTo(data) == 0) {
				temp.link = tempNext.link;
				numOfNode--;
				return i;
			} else {
				temp = tempNext;
				tempNext = tempNext.link;
				i++;
			}
		}
		return -1;
	}

	private int indexOf(T data) {
		Node<T> temp = first;
		for (int i = 0; i < numOfNode; i++) {
			if (temp.data.compareTo(data) == 0) {
				return i;
			} else {
				temp = temp.link;
			}
		}
		return -1;
	}
	
	//index�� �˷��ֱ� ���ؼ�
	int index = 0;
	Node<T> temp = first;
	//indexOf Recursive�� ����
//	private int indexOf(MyLinkedList list ,T data) {
//		if(temp.data.compareTo(data)==0) {
//			return index;
//		}
//		temp = temp.link;
//		index++;
//		
//		indexOf()
//		
//		return -1;
//	}

	public int sizeOf() {
		return numOfNode;
	}

	public void sort() {
		if (numOfNode <= 1) {
			return;
		}
		Node<T> temp = first;
		// ���ο� List�� �ϳ��� ��� �� Node�� ������
		Node<T> max;
		// ���ο� List�� ������
		MyLinkedList<T> sortedList = new MyLinkedList<>();
		// ���� List�� �����ִ� Node�� �ϳ��� ���� ������
		while (temp != null) {
			// max Node�� temp�� �ѹ��� ���� ���� ū Node��
			max = findMax(temp);
			// ���ο� List�� �տ������� maxNode�� �߰���
			sortedList.addFirst(max.data);
			// ���� List���� max�� remove
			remove(max.data);
			// �ٽ� �پ�� List�� �������ϱ� ���� first ������
			temp = first;
		}
		// first�� ������ ���ο� List�� ����Ŵ
		first = sortedList.first;
		// Node�� ������ ���ο� List�� Node�� ������ ����Ŵ
		numOfNode = sortedList.numOfNode;
	}

	private Node<T> findMax(Node<T> temp) {
		Node<T> max = temp;
		while (temp.link != null) {
			temp = temp.link;
			if (temp.data.compareTo(max.data) > 0) {
				max = temp;
			}
		}
		return max;
	}

	public String toString() {
		Node<T> temp = first;
		String retVal = "";
		while (temp != null) {
			retVal += "/" + temp.data.toString();
			temp = temp.link;
		}
		return retVal;
	}

	public static void main(String[] args) {
		MyLinkedList<MyClass> list = new MyLinkedList<>();

		int idNum = 0;

		list.addLast(new MyClass(idNum++, "lee"));
		System.out.println(list.toString());
		list.addLast(new MyClass(idNum++, "kim"));
		System.out.println(list.toString());
		list.addLast(new MyClass(idNum++, "park"));
		System.out.println(list.toString());
		list.addLast(new MyClass(idNum++, "choi"));
		System.out.println(list.toString());
		list.addLast(new MyClass(idNum++, "jung"));
		System.out.println(list.toString());
		list.addLast(new MyClass(idNum++, "song"));
		System.out.println(list.toString());
		list.addLast(new MyClass(idNum++, "lim"));
		System.out.println(list.toString());
		list.addLast(new MyClass(idNum++, "chang"));
		System.out.println(list.toString());

		System.out.println(list.get(3).toString() + list.indexOf(list.get(3)));
		list.set(3, new MyClass(30, "hwang"));
		System.out.println(list.get(3).toString());

		System.out.println("Current number of data : " + list.sizeOf());

		System.out.println(list.remove(new MyClass(1, "kim")));
		System.out.println(list.toString());
		System.out.println("Data removed : " + list.remove(1).toString());
		System.out.println(list.toString());
		System.out.println(list.get(2).toString());
		System.out.println(list.toString());

		System.out.println("\n<< Sorting >>");
		System.out.println("Before: " + list.toString());
		list.sort();
		System.out.println("After : " + list.toString());
		
//		//���� 3��
//		for(int i=0; i<list.sizeOf(); i++) {
//			System.out.println(list.indexOf(list, list.get(i)));
//		}
//		System.out.println(list.indexOf(list, new MyClass(3, "choi")));

	}

	private class Node<T> {
		T data;
		Node<T> link;

		private Node(T input, Node<T> next) {
			data = input;
			link = next;
		}
	}

}
