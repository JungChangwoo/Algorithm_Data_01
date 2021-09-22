package Week10;

public class Search {

	String[] data;
	int dataSize;

	static int seqCount = 0, binCount = 0;

	public Search() {

	}

	public Search(String[] input) {
		this.data = input;
		this.dataSize = data.length;
	}

	public int seqSearch1(String[] input, String key) {
		int n = input.length;
		int i = 0;
		while (i < n && input[i].compareTo(key) != 0) {
			i++;
		}
		if (i < n)
			return i;
		else
			return -1;
	}

	public int seqSearch2(String key) {
		int i = 0;
		while (i < this.dataSize && this.data[i].compareTo(key) != 0) {
			i++;
		}
		if (i < this.dataSize)
			return i;
		else
			return -1;
	}

	public int seqSearchRecursion(int start, String key) {
		if (start == this.dataSize) {
			return -1;
		} else if (this.data[start].compareTo(key) == 0) {
			return start;
		} else {
			return seqSearchRecursion(start + 1, key);
		}
	}

	// 정렬이 되어있다고 가정하고
	public int seqSearch3(String key) {
		int i = 0;
		while (i < this.dataSize && this.data[i].compareTo(key) < 0) {
			seqCount++;
			i++;
		}
		if (this.data[i].compareTo(key) == 0)
			return i;
		else
			return -1;
	}

	// seqSearch3를 recursion으로
	public int seqSearchRecursion2(int start, String key) {
		if (start == this.dataSize || this.data[start].compareTo(key) > 0) {
			return -1;
		} else if (this.data[start].compareTo(key) == 0) {
			return start;
		} else {
			return seqSearchRecursion2(start + 1, key);
		}
	}

	public void selectionSort() {
		for (int i = 0; i < this.dataSize - 1; i++) {
			for (int j = i + 1; j < this.dataSize; j++) {
				if (this.data[i].compareTo(this.data[j]) > 0) {
					String temp = this.data[i];
					this.data[i] = this.data[j];
					this.data[j] = temp;
				}
			}
		}
	}

	// iteration
	public int binarySearchIteration(int start, int end, String key) {
		while (start <= end) {
			binCount++;
			int middle = (start + end) / 2;
			if (key.compareTo(data[middle]) == 0)
				return middle;
			else if (key.compareTo(data[middle]) < 0)
				end = middle - 1;
			else
				start = middle + 1;
		}
		return -1;
	}

	// recursion
	public int binarySearchRecursion(int start, int end, String key) {
		if (start > end)
			return -1;
		int middle = (start + end) / 2;
		if (key.compareTo(data[middle]) == 0)
			return middle;
		else if (key.compareTo(data[middle]) < 0)
			return binarySearchRecursion(start, middle - 1, key);
		else
			return binarySearchRecursion(middle + 1, end, key);
	}

	public static void main(String[] args) {
		String[] input = { "lee", "kim", "park", "cho", "choi", "baek", "kang", "lim", "hwang", "yun" };

		Search test1 = new Search();
		System.out.println("case 1 : " + test1.seqSearch1(input, "baek"));

		Search test2 = new Search(input);
		System.out.println("case 2 : " + test2.seqSearch2("baek"));
		Search test3 = new Search(input);
		System.out.println("case 3 (Rec.) : " + test3.seqSearchRecursion(0, "baek"));

		test2.selectionSort();
		System.out.println("case 4 : " + test2.seqSearch3("lim"));
		System.out.println("case 5 (Rec.) : " + test2.seqSearchRecursion2(0, "baek"));

		System.out.println("case 6 (Binary) : " + test2.binarySearchIteration(0, input.length - 1, "lim"));
		System.out.println("case 6 (Binary Rec.) : " + test2.binarySearchRecursion(0, input.length - 1, "kang"));

		System.out.println(seqCount + " " + binCount);
	};
}
