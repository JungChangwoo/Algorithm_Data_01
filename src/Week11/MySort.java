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
	 * 전체 원소들 중에서 기준 위치에 맞는 원소를 선택하여 자리를 교환하는 방식으로 정렬 
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
	 * 인접한 두 개의 원소를 비교하여 자리를 교환하는 방식 
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
	 * 정렬할 전체 원소에 대해서 정렬을 수행하지 않고, 기준 값을 중심으로 
	 * 왼쪽 부분 집합과 오른쪽 부분 집합으로 분할아여 정렬하는 방법
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
	 * 병합정렬 : 여러 개의 정렬된 자료의 집합을 병합하여 한 개의 정렬된 집합으로 만드는 방식
	 * 부분집합으로 분할하고, 각 부분집합에 대해서 정렬 작업을 완성한 후에 정렬된 부분집합들을 다시 결합하는 방식
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
		
		//첫 번재 부분 집합의 첫 번째
		int i = p;
		//두 번째 부분 집합의 첫 번째
		int j = q + 1;
		//Sorted배열의 첫 번째 (index를 위해서)
		int k = p;
		//Sorted배열에 넣어주기 위해서 두 배열을 비교하면서 넣어줌
		while (i <= q && j <= r) {
			nOfCompare++;
			nOfMove++;
			if (data[i] < data[j]) {
				sorted[k++] = data[i++];
			} else {
				sorted[k++] = data[j++];
			}
		}
		//만약 두 번째 부분 집합이 다 끝나고 첫 번째만 남았을 때
		while (i <= q) {
			nOfMove++;
			sorted[k++] = data[i++];
		}
		//만약 첫 번째 부분 집합이 다 끝나고 두 번째만 남았을 때
		while (j <= r) {
			nOfMove++;
			sorted[k++] = data[j++];
		}		
		//마지막에 정리된 배열을 원래 데이터 배열에 넣어줌
		for (int l = p; l <= r; l++) {
			nOfMove++;
			data[l] = sorted[l];
		}
		return data;
	}
	
	/*
	 * 삽입 정렬 
	 * 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여,
	 * 자신의 위치를 찾아 삽입함으로써 정렬을 완성
	 * linked List에 적합하나 테스트를 위해 arrayList에도 적용함
	 */
	public int[] insertionSort(int[] data) {
		int dataSize = data.length;
		if (dataSize > 1) {
			// 두 번재 자리부터 시작하여 마지막까지 loop
			for (int i = 1; i < dataSize; i++) {
				// i보다 앞의 자료들과 비교하기 위해서
				int j = 0;
				// i보다 앞에 있는 것들중에 i가 더 크면 그대로 냅두고 다음 꺼 찾음
				while (data[i] > data[j] && j < i) {
					nOfCompare++;
					j++;
				}
				//만약에 앞에 있는 것들 중에 i보다 더 큰 거 발견 == j에 있는 거
				if (j < i) {
					// i에 있는 거 꺼낸 다음
					int temp = data[i];
					// 삽입될 자리부터 i-1까지 뒤로 한 칸씩 보냄
					for (int k = i - 1; k >= j; k--) {
						nOfMove++;
						data[k + 1] = data[k];
					}
					// 삽입 될 자리에 꺼낸 i를 넣어줌 
					data[j] = temp;
					//이후에 다음 자릿수로 넘어간 후 반복
				}
			}
		}
		return data;
	}

	
	public int[] insertionSortLinkedList(int[] data) {
		int dataSize = data.length;
		MySortLinkedList sorted = new MySortLinkedList();
		// 하나씩 link 타고 들어가서 정렬함 
		for (int i = 0; i < dataSize; i++) {
			sorted.insertAscendingOrder(data[i]);
			this.nOfCompare += sorted.getStatCompare();
			this.nOfMove++;
		}
		// 정렬된 배열을 원래 배열에 넣어줌
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
