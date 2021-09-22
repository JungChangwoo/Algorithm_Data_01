package Week6;

public class MyArrayList3<T> {
	T[] array;
	int arrSize;
	int numOfData;

	public MyArrayList3(int initSize) {
		arrSize = initSize;
		array = (T[])new Object[arrSize];
		numOfData = 0;
	}

	public T get(int index) {
		// 만일 index가 arrSize보다 크거나 음수이면 에러 발생
		if (index >= arrSize || index < 0) {
			System.out.println("Invalid Index...");
			return null;
		}
		return array[index];
	}
	public void set(int index, T data) {
		array[index] = data;
	}
	
	public void addFirst(T data) {
		add(0, data);
	}
	
	public void addLast(T data) {
		add(numOfData, data);
	}

	public void add(int index, T data) {
		if (numOfData >= arrSize) {
			T[] bigArray = (T[])new Object[arrSize * 2];
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

	public T remove(int index) {
		if(index < 0) {
			return null;
		}
		T retVal = array[index];
		for(int i = index +1; i < numOfData; i++) {
			array[i-1] = array[i];
		}
		numOfData--;
		return retVal;
	}

	public int remove(T data) {
		int index = indexOf(data);
		remove(index);
		return index;
	}

	private int indexOf(T data) {
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
	
	public int compare(T o1, T o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2);
		} else {
			return -1;
		}
	}
	
	public void sort() {
		for(int i = numOfData-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(compare(array[j], array[j+1]) > 0) {
					T temp = array[j];
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
		MyArrayList3<MyClass> list = new MyArrayList3<>(3);
		
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