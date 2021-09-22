package Week5;

public class MyArrayList1 {
	int initSize = 3;
	String[] array;
	int arrSize;
	int numOfData;

	public MyArrayList1() {
		arrSize = initSize;
		array = new String[arrSize];
		numOfData = 0;
	}

	public String get(int index) {
		// 만일 index가 arrSize보다 크거나 음수이면 에러 발생
		if (index >= arrSize || index < 0) {
			System.out.println("Invalid Index...");
			return null;
		}
		return array[index];
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
		// 해당 index의 값을 지움
		array[index] = null;
		// 지운 data의 index보다 뒤에 있는 data들을 왼쪽으로 한칸씩 옮김
		for (int i = index; i <= numOfData - 1; i++) {
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

	public String toString() {
		String retVal = "";
		for (int i = 0; i < numOfData; i++) {
			retVal = retVal + "/" + array[i];
		}
		return retVal;
	}

	public static void main(String[] args) {
		MyArrayList1 list = new MyArrayList1();

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
