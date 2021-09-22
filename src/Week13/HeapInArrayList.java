package Week13;

import java.util.ArrayList;

public class HeapInArrayList {

	private ArrayList<Character> heap = new ArrayList<>();

	public HeapInArrayList() {
		// index 0 은 null로 채움
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
		// 자식노드가 없는데 자식노드로 내려왔거나 index가 0인 즉, null인 부분에 도달하면 return
		if (k >= heap.size() || i < 1) {
			return;
		}
		// right 자식이 있고 right가 부모보다 크다면, 교환해줄 자식을 right로 설정
		if (k + 1 < heap.size() && (heap.get(k + 1) > heap.get(k))) {
			k++;
		}
		// 자식이 부모보다 크다면, 교환
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
		// 자기가 들어갈 index
		int k = heap.size();
		heap.add(k, c);

		System.out.print(c + "  ");
		// 부모 index
		int parentIndex = k / 2;
		// insert가 되고 나서 부모와 비교하여 자리를 바꿔줌
		heapifyUpward(parentIndex);
		System.out.println(heap.toString());
	}

	// 부모 자식 관계 정렬
	private void heapifyUpward(int i) {
		// left Child
		int k = i * 2;
		// 자식노드가 없는데 자식노드로 내려왔거나 index가 0인 즉, null인 부분에 도달하면 return
		if (k >= heap.size() || i < 1) {
			return;
		}
		// right 자식이 있고 right가 부모보다 크다면, 교환해줄 자식을 right로 설정
		if (k + 1 < heap.size() && (heap.get(k + 1) > heap.get(k))) {
			k++;
		}
		// 자식이 부모보다 크다면, 교환
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
