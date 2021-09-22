package MidTerm;


//Comparable을 상속받아야 CompareTo시 문제 없음
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

	// 올바른 인덱스를 입력했는지 확인해주는 함수
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
			// 두개가 있다고 가정하면, 현재 first.link가 가리키는 것은 두 번재 Node이다
			// 그 두 번재 Node를 first로 지정하겠다는 것이다. 즉, 첫 번재 Node가 remove된 것이다.
			// 만약 Node가 하나밖에 없다면, first.link가 null이기 때문에, first는 null이 될 것이다.
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
			// 마지막 Node 전에 멈추기 위해서
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

	// 편리한 것은 indexOf함수 호출해서 index값 찾고 remove(int index)에 다시 호출하는 것
	// But, 그렇게 되면 반복을 두 번이나 하게 됨
	public int remove(T data) {
		Node<T> temp = first;
		// 처음이면 다음 Node를 first로 지정함
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
	
//	//index를 알려주기 위해서
//	int index = 0;
//	Node<T> temp = first;
//	//indexOf Recursive한 버전
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
		// 새로운 List에 하나씩 들어 갈 Node를 정의함
		Node<T> max;
		// 새로운 List를 정의함
		MyLinkedList<T> sortedList = new MyLinkedList<>();
		// 기존 List에 남아있는 Node가 하나도 업을 때까지
		while (temp != null) {
			// max Node는 temp를 한바퀴 돌고 가장 큰 Node임
			max = findMax(temp);
			// 새로운 List에 앞에서부터 maxNode를 추가함
			sortedList.addFirst(max.data);
			// 기존 List에서 max를 remove
			remove(max.data);
			// 다시 줄어든 List를 재정의하기 위해 first 재정의
			temp = first;
		}
		// first가 이제는 새로운 List를 가리킴
		first = sortedList.first;
		// Node의 갯수도 새로운 List의 Node의 갯수를 가리킴
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
//		
//		//과제 3번
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
