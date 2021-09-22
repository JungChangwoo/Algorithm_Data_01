package Week3;

import java.util.Arrays;

/**
 * �ݺ��� ������ ����� ������ ���ظ� ���� ���� Class�Դϴ�.
 * @author JUNGChangwoo
 *
 */
public class Week3_1 {
	
	/**
	 * �Լ��� �־��� �����Դϴ�.
	 */
	char [] data;
	/**
	 * �ݺ� Ƚ���� �����ִ� �����Դϴ�.
	 */
	int count = 0;
	/**
	 * data�� �ʱ�ȭ�ϴ� �������Դϴ�.
	 * @param input = data�� �ʱ�ȭ���� ���Դϴ�.
	 */
	public Week3_1(char [] input) {
		data = input;
	}
	
	/**
	 * �ݺ��� ������ �ʵ��� data�� �� ���� ���¸� ǥ���� �� �ִ��� ����ϰ� ���¸� �����ִ� �Լ��Դϴ�.
	 * ���� �� �� �ִ� �Ǽ��� ���� �ִ��� �˷��ֱ� ���ؼ� ���� �Լ��Դϴ�.
	 * error = ���� ����� �ݺ����� ����� ���� ���� �ݺ����� ���۵��� �� �ʱ�ȭ�� ������ �ʾƼ� �߻��ϴ� ����
	 */
	public void Iteration1() {
		int size = data.length;
		count = 0;
		//ù ��° �ڸ��� �ٲ��ִ� �ݺ���
		for(int i0=0; i0<size; i0++) {
			swapData(0,i0);
			//�� ��° �ڸ��� �ٲ��ִ� �ݺ���
			for(int i1=1; i1<size; i1++) {
				swapData(1,i1);
				//�� ��° �ڸ��� �ٲ��ִ� �ݺ���
				for(int i2=2; i2<size; i2++) {
					swapData(2,i2);
					//�� ��° �ڸ��� �ټ���°�� ������ ������ �׳� �ٷ� �������
					count++;
					System.out.print(count+" : ");
					System.out.println(data);
					swapData(3,4);
					count++;
					System.out.println(count+" : "+toString());
				}
			}
		}
	}
	/**
	 * Iteration1���� �߻��� �������� ������ �ùٸ� �Լ�
	 */
	public void Iteration2() {
		int size = data.length;
		count = 0;
		for(int i0=0; i0<size; i0++) {
			swapData(0, i0);
			for(int i1=1; i1<size; i1++) {
				swapData(1, i1);
				for(int i2=2; i2<size; i2++) {
					swapData(2, i2);
					
					count++;
					System.out.println(count+" : "+toString());
					swapData(3,4);
					count++;
					System.out.println(count+" : "+toString());
					//�ʱ�ȭ
					swapData(3,4);
					swapData(2,i2);
				}
				//�ʱ�ȭ
				swapData(1,i1);
			}
			//�ʱ�ȭ
			swapData(0,i0);
		}
	}
	/**
	 * ����� ������ ���� input�� �� ���� ���¸� ǥ���� �� �ִ��� ����ϰ� ���¸� �����ִ� �Լ��Դϴ�.
	 * @param input ����� ���� �Լ��� �־��� �����data
	 * @param result �����
	 */
	public void Recursion(char [] input, String result) {
		//��Ͱ� ������ ����
		if(input.length == 1) {
			count++;
			System.out.println(count+"  "+result+input[0]);
		}
		for(int i=0; i<input.length; i++) {
			swapData(input, 0, i);
			result += input[0];
			//ù ��° �ڸ��� �����ϰ� �ٽ� �Լ��� ȣ��(���)
			Recursion(Arrays.copyOfRange(input, 1, input.length), result);
			result = result.substring(0, result.length()-1);
		}
	}
	
	/**
	 * Recursion�� ȣ���� �� ����ڰ� �Ű������� �Ѱ����� �ʾƵ� overloading�ؼ� �����ϴ� �Լ� 
	 */
	public void Recursion() {
		Recursion(this.data, "");
	}
	
	/**
	 * �Ű������� ���� �� ���ڰ��� �ش�Ǵ� data�迭�� ������ ���� �ٲ��ִ� �Լ��Դϴ�.
	 * @param level index�� swap�� ����
	 * @param index level�� swap�� ����
	 */
	private void swapData(int level, int index) {
		if(level != index) {
			char temp = data[level];
			data[level] = data[index];
			data[index] = temp;
		}
	}
	
	/**
	 * 
	 * @param data swap�� ���� �迭�Դϴ�.
	 * @param level indext�� swap�� ����
	 * @param index level�� swap�� ����
	 */
	private void swapData( char [] data, int level, int index) {
		if(level != index) {
			char temp = data[level];
			data[level] = data[index];
			data[index] = temp;
		}
	}
	
	public int maxIndexIter() {
		if(data.length < 1 ) {
			return -1;
		}
		int index = 0;
		int max = data[0];
		int i = 1;
		while(i < data.length) {
			if(data[i] > max) {
				max = data[i];
				index = i;
			}
			i++;
		}
		return index;
	}
	
	public int maxIndexRec(int startIndex) {
		if(startIndex == (data.length - 1)) {
			return startIndex;
		}
		int tempIndex = maxIndexRec(startIndex+1);
		if(data[startIndex]> data[tempIndex]) {
			return startIndex;
		}
		else
		{
			return tempIndex;
		}
	}
	
	public int search1(int value) {
		int i =0;
		while(i<data.length) {
			if(data[i]== value) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public int search2(int value, int i) {
		if(i == data.length) {
			return -1;
		}
		if(data[i] == value) {
			return i;
		}
		else {
			return search2(value, i+1);
		}
	}
	
/*	public int[] mySort() {
		int startIndex = 0;
		while(startIndex < data.length-1) {
			int tempIndex = maxIndexRec(startIndex+1);
			swapData(startIndex, tempIndex);
			startIndex++;
		}
//		return data;
	}
*/	
	
	
	/**
	 * ������ ��������� toString�� overriding�ؼ� �������� 
	 * data�迭�� �� �����۵��� ������� ���ļ� string���� ��ȯ�����ִ� �Լ�
	 */
	public String toString() {
		String result = "";
		for(int i=0; i<data.length; i++) {
			result += data[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		char data[] = {'a', 'b', 'c', 'd', 'e'};
		Week3_1 instance = new Week3_1(data);
//		instance.Iteration1();
//		instance.Iteration2();
		instance.Recursion(data, "");
//		instance.Recursion();
		

	}

}
