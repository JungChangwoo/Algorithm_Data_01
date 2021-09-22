package Week4;

public class Sort {
	
	public int[] quickSort(int[] data, int p, int r) {
		if(p<r) {
			int q = partition(data, p, r);
			quickSort(data, p, q-1);
			quickSort(data, q+1, r);
		}
		return data;
	}
	
	private int partition(int[] data, int p, int r) {
		int pivot = r;
		int left = p;
		int right = r;
//		int [] data = {12, 21, 15, 32, 22, 9, 11, 33, 41, 27};
		while(left < right) {
			while(data[left]<data[pivot] && left<right) left++;
			while(data[right]>data[pivot] && left<right) right--;
			if(left<right) swapData(data, left, right);
		}
		swapData(data, pivot, right);
		
		return right;
	}
	
	private void swapData(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String[] args) {
		int [] data = {12, 21, 15, 32, 22, 9, 11, 33, 41, 27};
		int [] sortedData = new int[data.length];
		
		Sort s = new Sort();
		sortedData = s.quickSort(data, 0, data.length-1);
		for(int i=0; i<sortedData.length;i++) {
			System.out.print(sortedData[i]+" ");
		}
		System.out.println();
	}

}
