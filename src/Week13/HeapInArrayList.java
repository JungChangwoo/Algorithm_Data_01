package Week13;

import java.util.ArrayList;

public class HeapInArrayList {

	private ArrayList<Character> heap = new ArrayList<>();

	public HeapInArrayList() {
		// index 0 �� null�� ä��
		heap.add(null);
	}

	public void heapSort(char[] input) {
		buildHeap(input);
	}

	private void sortOut() {
		System.out.println("< Max.Heap >");

		while (heap.size() > 1) {
			System.out.println(deleteHeap() + "  " + heap.toString());
		}
	}

	private Character deleteHeap() {
		if (heap.size() <= 1) {
			return null;
		}
		char retVal = heap.remove(1);

		if (heap.size() > 2) {
			heap.add(1, heap.remove(heap.size() - 1));
			heapifyDownward(1);
		}
		return retVal;
	}

	private void heapifyDownward(int i) {
		// left Child
		int k = i * 2;
		// �ڽĳ�尡 ���µ� �ڽĳ��� �����԰ų� index�� 0�� ��, null�� �κп� �����ϸ� return
		if (k >= heap.size() || i < 1) {
			return;
		}
		// right �ڽ��� �ְ� right�� �θ𺸴� ũ�ٸ�, ��ȯ���� �ڽ��� right�� ����
		if (k + 1 < heap.size() && (heap.get(k + 1) > heap.get(k))) {
			k++;
		}
		// �ڽ��� �θ𺸴� ũ�ٸ�, ��ȯ
		if (heap.get(k) > heap.get(i)) {
			swap(heap, k, i);
			heapifyUpward(k);
		}

	}

	private void buildHeap(char[] input) {
		System.out.println("<< Heap implemented in ArrayList >>");
		for (int i = 0; i < input.length; i++) {
			insertHeap(input[i]);
		}
	}

	private void insertHeap(char c) {
		// �ڱⰡ �� index
		int k = heap.size();
		heap.add(k, c);

		System.out.print(c + "  ");
		// �θ� index
		int parentIndex = k / 2;
		// insert�� �ǰ� ���� �θ�� ���Ͽ� �ڸ��� �ٲ���
		heapifyUpward(parentIndex);
		System.out.println(heap.toString());
	}

	// �θ� �ڽ� ���� ����
	private void heapifyUpward(int i) {
		// left Child
		int k = i * 2;
		// �ڽĳ�尡 ���µ� �ڽĳ��� �����԰ų� index�� 0�� ��, null�� �κп� �����ϸ� return
		if (k >= heap.size() || i < 1) {
			return;
		}
		// right �ڽ��� �ְ� right�� �θ𺸴� ũ�ٸ�, ��ȯ���� �ڽ��� right�� ����
		if (k + 1 < heap.size() && (heap.get(k + 1) > heap.get(k))) {
			k++;
		}
		// �ڽ��� �θ𺸴� ũ�ٸ�, ��ȯ
		if (heap.get(k) > heap.get(i)) {
			swap(heap, k, i);
			heapifyUpward(i / 2);
		}

	}

	private void swap(ArrayList<Character> heap2, int k, int i) {
		char temp = heap.get(k);
		heap.set(k, heap.get(i));
		heap.set(i, temp);

	}

	public static void main(String[] args) {
		char[] data = { 'M', 'Y', 'U', 'N', 'G', 'I', 'S', 'W' };

		HeapInArrayList h = new HeapInArrayList();

		h.heapSort(data);
		
		h.sortOut();

	}

}
