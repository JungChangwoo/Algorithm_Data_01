package Week4;

public class Sort2 {
	
	int[] data;
	public Sort2(int[] input) {
		data = new int[input.length];
		data = input;
	}
	
	public int[] quickSort( int p, int r) {
		if(p<r) {
			int q = partition(p, r);
			quickSort(p, q-1);
			quickSort(q+1, r);
		}
		return data;
	}
	
	private int partition(int p, int r) {
		int pivot = r;
		int left = p;
		int right = r;
		
		while(left < right) {
			while(data[left]<data[pivot] && left<right) left++;
			while(data[right]>data[pivot] && left<right) right--;
			if(left<right) swapData(left, right);
		}
		swapData(pivot, right);
		
		return right;
	}
	
	private void swapData(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String[] args) {
		int [] data = {12, 21, 15, 32, 22, 9, 11, 33, 41, 27};
		int [] sortedData = new int[data.length];
		
		Sort2 s = new Sort2(data);
		sortedData = s.quickSort( 0, data.length-1);
		for(int i=0; i<sortedData.length;i++) {
			System.out.print(sortedData[i]+" ");
		}
		System.out.println();
	}
}
