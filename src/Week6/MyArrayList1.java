package Week6;

public class MyArrayList1 {
	String[] array;
	int arrSize;
	int numOfData;

	public MyArrayList1(int initSize) {
		arrSize = initSize;
		array = new String[arrSize];
		numOfData = 0;
	}

	public String get(int index) {
		// ���� index�� arrSize���� ũ�ų� �����̸� ���� �߻�
		if (index >= arrSize || index < 0) {
			System.out.println("Invalid Index...");
			return null;
		}
		return array[index];
	}
	public void set(int index, String data) {
		array[index] = data;
	}
	
	public void addFirst(String data) {
		add(0, data);
	}
	
	public void addLast(String data) {
		add(numOfData, data);
	}

	public void add(int index, String data) {
		if (numOfData >= arrSize) {
			String[] bigArray = new String[arrSize * 2];
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

	public String remove(int index) {
		// �ش� index�� ���� ����
		array[index] = null;
		// ���� data�� index���� �ڿ� �ִ� data���� �������� ��ĭ�� �ű�
		for (int i = index; i < numOfData - 1; i++) {
			array[i] = array[i + 1];
		}
		// numOfData -1
		numOfData--;
		return null;
	}

	public int remove(String data) {
		int index = indexOf(data);
		remove(index);
		return index;
	}

	private int indexOf(String data) {
		for(int i=0; i<= numOfData-1; i++) {
			if(array[i] == data) {
				return i;
			}
		}
		return 0;
	}

	public int sizeOf() {
		return numOfData;
	}

	public int arrSize() {
		return arrSize;
	}
	
	public void sort() {
		//�ڿ������� �״��� ū�� �״��� ū��...
		for(int i = numOfData-1; i>0; i--) {
			//i��°���� ���� ū ���� ã�Ƽ� i index�� �־���
			for(int j=0; j<i; j++) {
				if(array[j].compareTo(array[j+1])>0) {
					String temp = array[j];
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
		MyArrayList1 list = new MyArrayList1(3);

		list.add(list.sizeOf(), "a");
		list.add(list.sizeOf(), "b");
		list.add(list.sizeOf(), "c");
		System.out.println(list.toString());
		System.out.println("Current Max Size : " + list.arrSize());

		list.add(1, "choi");
		System.out.println("Curren Max Size : " + list.arrSize());
		list.add(1, "jung");
		list.add(0, "hong");
		System.out.println(list.toString());
		list.add(list.sizeOf(), "cha");
		System.out.println("Current Max Size : " + list.arrSize());
		list.add(list.sizeOf(), "song");

		System.out.println(list.toString());
		list.get(13);
		System.out.println("Get Index 3 : "+list.get(3));

		list.remove(3);
		System.out.println(list.toString());
		System.out.println("Current arrSize : " + list.numOfData);
		
		list.remove("cha");
		System.out.println(list.toString());
		System.out.println("Current arrSize : " + list.numOfData);
	}

}
