package Week6;

public class MyArrayList2 {
	MyClass[] array;
	int arrSize;
	int numOfData;

	public MyArrayList2(int initSize) {
		arrSize = initSize;
		array = new MyClass[arrSize];
		numOfData = 0;
	}

	public MyClass get(int index) {
		// 만일 index가 arrSize보다 크거나 음수이면 에러 발생
		if (index >= arrSize || index < 0) {
			System.out.println("Invalid Index...");
			return null;
		}
		return array[index];
	}
	public void set(int index, MyClass data) {
		array[index] = data;
	}
	
	public void addFirst(MyClass data) {
		add(0, data);
	}
	
	public void addLast(MyClass data) {
		add(numOfData, data);
	}

	public void add(int index, MyClass data) {
		if (numOfData >= arrSize) {
			MyClass[] bigArray = new MyClass[arrSize * 2];
			for (int i = 0; i < arrSize; i++) {
				bigArray[i] = array[i];
			}
			arrSize *= 2;
			array = bigArray;
		}
		for (int j = numOfData - 1; j >= index; j--) {
			array[j + 1] = array[j];
		}
		array[index] = data;
		numOfData++;
	}

	public MyClass remove(int index) {
		if(index < 0) {
			return null;
		}
		MyClass retVal = array[index];
		for(int i = index +1; i < numOfData; i++) {
			array[i-1] = array[i];
		}
		numOfData--;
		return retVal;
	}

	public int remove(MyClass data) {
		int index = indexOf(data);
		remove(index);
		return index;
	}

	private int indexOf(MyClass data) {
		for(int i=0; i<= numOfData-1; i++) {
			if(array[i].equals(data)) {
				return i;
			}
		}
		return -1;
	}

	public int sizeOf() {
		return numOfData;
	}

	public int arrSize() {
		return arrSize;
	}
	
	public void sort() {
		for(int i = numOfData-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(array[j].compareTo(array[j+1])>0) {
					MyClass temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	
	public String toString() {
		String retVal = "";
		for (int i = 0; i < numOfData; i++) {
			retVal = retVal + "/" + array[i];
		}
		return retVal;
	}

	public static void main(String[] args) {
		MyArrayList2 list = new MyArrayList2(3);
		
		int idNum = 0;
		
		list.addLast(new MyClass(idNum++, "lee"));
		list.addLast(new MyClass(idNum++, "kim"));
		list.addLast(new MyClass(idNum++, "park"));
		list.addLast(new MyClass(idNum++, "choi"));
		list.addLast(new MyClass(idNum++, "jung"));
		list.addLast(new MyClass(idNum++, "song"));
		System.out.println(list.toString());
		System.out.println("Current Max Size : " + list.arrSize());

		System.out.println(list.remove(new MyClass(1, "kim")));
		System.out.println(list.toString());
		list.remove(1);
		System.out.println(list.toString());
		
		list.remove(list.get(2));
		System.out.println(list.toString());
		
		list.sort();
		System.out.println(list.toString());
	}

}
