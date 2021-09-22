package Week11;

public class MySort {

	int nOfCompare, nOfSwap, nOfMove;

	public int[] createData(int size) {
		int[] data = new int[size];
		for (int i = 0; i < size; i++) {
			data[i] = (int) (Math.random() * size * 10);
		}
		return data;
	}

	public void resetCounter() {
		this.nOfCompare = 0;
		this.nOfSwap = 0;
		this.nOfMove = 0;
	}

	public void showStat(String algName) {
		System.out.println("\n< " + algName + " >");
		System.out.println("    - n. of comparisons : " + nOfCompare);
		if (nOfSwap != 0)
			System.out.println("    - n. of swaps : " + nOfSwap);
		if (nOfMove != 0)
			System.out.println("    - n. of moves : " + nOfMove);
	}

	/*
	 * ��ü ���ҵ� �߿��� ���� ��ġ�� �´� ���Ҹ� �����Ͽ� �ڸ��� ��ȯ�ϴ� ������� ���� 
	 */
	public int[] selectionSort(int[] data) {
		int dataSize = data.length;
		for (int i = 0; i < dataSize - 1; i++) {
			for (int j = i + 1; j < dataSize; j++) {
				this.nOfCompare++;
				if (data[i] > data[j]) {
					data = swap(data, i, j);
				}
			}
		}
		return data;
	}

	/*
	 * ������ �� ���� ���Ҹ� ���Ͽ� �ڸ��� ��ȯ�ϴ� ��� 
	 */
	public int[] bubbleSort(int[] data) {
		int dataSize = data.length;
		for (int i = dataSize - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				this.nOfCompare++;
				if (data[j] > data[j + 1]) {
					data = swap(data, j, j + 1);
				}
			}
		}
		return data;
	}
	
	/*
	 * ������ ��ü ���ҿ� ���ؼ� ������ �������� �ʰ�, ���� ���� �߽����� 
	 * ���� �κ� ���հ� ������ �κ� �������� ���Ҿƿ� �����ϴ� ���
	 */
	public int[] quickSort(int[] data) {
		return quickSort(data, 0, data.length - 1);
	}

	public int[] quickSort(int[] data, int p, int r) {
		if (p < r) {
			int q = partition(data, p, r);
			quickSort(data, p, q - 1);
			quickSort(data, q + 1, r);
		}
		return data;
	}

	private int partition(int[] data, int p, int r) {
		int pivot = r;
		int left = p;
		int right = r;

		while (left < right) {
			while (data[left] < data[pivot] && left < right) {
				nOfCompare++;
				left++;
			}
			while (data[right] >= data[pivot] && left < right) {
				nOfCompare++;
				right--;
			}
			if (left < right) {
				swap(data, left, right);
			}
		}
		swap(data, pivot, right);
		return right;
	}
	
	/*
	 * �������� : ���� ���� ���ĵ� �ڷ��� ������ �����Ͽ� �� ���� ���ĵ� �������� ����� ���
	 * �κ��������� �����ϰ�, �� �κ����տ� ���ؼ� ���� �۾��� �ϼ��� �Ŀ� ���ĵ� �κ����յ��� �ٽ� �����ϴ� ���
	 */
	public int[] mergeSort(int[] data) {
		return mergeSort(data, 0, data.length - 1);
	}

	private int[] mergeSort(int[] data, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(data, p, q);
			mergeSort(data, q + 1, r);
			merge(data, p, q, r);
		}
		return data;
	}

	private int[] merge(int[] data, int p, int q, int r) {
		int[] sorted = new int[data.length];
		
		//ù ���� �κ� ������ ù ��°
		int i = p;
		//�� ��° �κ� ������ ù ��°
		int j = q + 1;
		//Sorted�迭�� ù ��° (index�� ���ؼ�)
		int k = p;
		//Sorted�迭�� �־��ֱ� ���ؼ� �� �迭�� ���ϸ鼭 �־���
		while (i <= q && j <= r) {
			nOfCompare++;
			nOfMove++;
			if (data[i] < data[j]) {
				sorted[k++] = data[i++];
			} else {
				sorted[k++] = data[j++];
			}
		}
		//���� �� ��° �κ� ������ �� ������ ù ��°�� ������ ��
		while (i <= q) {
			nOfMove++;
			sorted[k++] = data[i++];
		}
		//���� ù ��° �κ� ������ �� ������ �� ��°�� ������ ��
		while (j <= r) {
			nOfMove++;
			sorted[k++] = data[j++];
		}		
		//�������� ������ �迭�� ���� ������ �迭�� �־���
		for (int l = p; l <= r; l++) {
			nOfMove++;
			data[l] = sorted[l];
		}
		return data;
	}
	
	/*
	 * ���� ���� 
	 * �ڷ� �迭�� ��� ��Ҹ� �տ������� ���ʴ�� �̹� ���ĵ� �迭 �κа� ���Ͽ�,
	 * �ڽ��� ��ġ�� ã�� ���������ν� ������ �ϼ�
	 * linked List�� �����ϳ� �׽�Ʈ�� ���� arrayList���� ������
	 */
	public int[] insertionSort(int[] data) {
		int dataSize = data.length;
		if (dataSize > 1) {
			// �� ���� �ڸ����� �����Ͽ� ���������� loop
			for (int i = 1; i < dataSize; i++) {
				// i���� ���� �ڷ��� ���ϱ� ���ؼ�
				int j = 0;
				// i���� �տ� �ִ� �͵��߿� i�� �� ũ�� �״�� ���ΰ� ���� �� ã��
				while (data[i] > data[j] && j < i) {
					nOfCompare++;
					j++;
				}
				//���࿡ �տ� �ִ� �͵� �߿� i���� �� ū �� �߰� == j�� �ִ� ��
				if (j < i) {
					// i�� �ִ� �� ���� ����
					int temp = data[i];
					// ���Ե� �ڸ����� i-1���� �ڷ� �� ĭ�� ����
					for (int k = i - 1; k >= j; k--) {
						nOfMove++;
						data[k + 1] = data[k];
					}
					// ���� �� �ڸ��� ���� i�� �־��� 
					data[j] = temp;
					//���Ŀ� ���� �ڸ����� �Ѿ �� �ݺ�
				}
			}
		}
		return data;
	}

	
	public int[] insertionSortLinkedList(int[] data) {
		int dataSize = data.length;
		MySortLinkedList sorted = new MySortLinkedList();
		// �ϳ��� link Ÿ�� ���� ������ 
		for (int i = 0; i < dataSize; i++) {
			sorted.insertAscendingOrder(data[i]);
			this.nOfCompare += sorted.getStatCompare();
			this.nOfMove++;
		}
		// ���ĵ� �迭�� ���� �迭�� �־���
		for (int i = 0; i < dataSize; i++) {
			data[i] = sorted.removeFirst();
		}
		return data;
	}

	private int[] swap(int[] data, int i, int j) {
		this.nOfSwap++;
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		return data;
	}

	private static void showData(int[] data) {
		int n = data.length;
		System.out.println("\n -- Data Status --");
		int nRow = 1 + (int) n / 10;
		for (int i = 0; i < nRow; i++) {
			for (int j = i * 10; j < Math.min(n, (i + 1) * 10); j++) {
				System.out.print("  " + data[j]);
			}
			System.out.println();
		}
	}

	private static void makeCopy(int[] dataSorted, int[] data) {
		int n = data.length;
		for (int i = 0; i < n; i++) {
			dataSorted[i] = data[i];
		}
	}

	public static void main(String[] args) {
		int dataSize = 35;
		int[] data = new int[dataSize];
		int[] dataSorted = new int[dataSize];

		MySort sort = new MySort();
		data = sort.createData(dataSize);
		System.out.println("\n< Initial Data Created >");
		showData(data);

		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.selectionSort(dataSorted);
		sort.showStat("Selection Sort");
		showData(dataSorted);

		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.bubbleSort(dataSorted);
		sort.showStat("Bubble Sort");
		showData(dataSorted);

		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.quickSort(dataSorted);
		sort.showStat("Quick Sort");
		showData(dataSorted);

		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.quickSort(dataSorted);
		sort.showStat("Quick Sort");
		showData(dataSorted);

		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.mergeSort(dataSorted);
		sort.showStat("Merge Sort");
		showData(dataSorted);

		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.insertionSort(dataSorted);
		sort.showStat("Insertion Sort");
		showData(dataSorted);

		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.insertionSortLinkedList(dataSorted);
		sort.showStat("Insertion Sort with Linked List");
		showData(dataSorted);
	}

}
