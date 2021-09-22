package Week3;

import java.util.Arrays;

/**
 * 반복적 구조와 재귀적 구조의 이해를 위해 만든 Class입니다.
 * @author JUNGChangwoo
 *
 */
public class Week3_1 {
	
	/**
	 * 함수에 넣어줄 변수입니다.
	 */
	char [] data;
	/**
	 * 반복 횟수를 세어주는 변수입니다.
	 */
	int count = 0;
	/**
	 * data를 초기화하는 생성자입니다.
	 * @param input = data에 초기화해줄 값입니다.
	 */
	public Week3_1(char [] input) {
		data = input;
	}
	
	/**
	 * 반복적 구조로 필드의 data로 몇 개의 상태를 표현할 수 있는지 계산하고 상태를 보여주는 함수입니다.
	 * 쉽게 할 수 있는 실수가 뭐가 있는지 알려주기 위해서 만든 함수입니다.
	 * error = 전에 실행된 반복문의 변경된 값이 다음 반복문이 시작됐을 때 초기화를 해주지 않아서 발생하는 문제
	 */
	public void Iteration1() {
		int size = data.length;
		count = 0;
		//첫 번째 자리를 바꿔주는 반복문
		for(int i0=0; i0<size; i0++) {
			swapData(0,i0);
			//두 번째 자리를 바꿔주는 반복문
			for(int i1=1; i1<size; i1++) {
				swapData(1,i1);
				//세 번째 자리를 바꿔주는 반복문
				for(int i2=2; i2<size; i2++) {
					swapData(2,i2);
					//네 번째 자리와 다섯번째는 변수가 적으니 그냥 바로 계산해줌
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
	 * Iteration1에서 발생한 오류들을 제거한 올바른 함수
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
					//초기화
					swapData(3,4);
					swapData(2,i2);
				}
				//초기화
				swapData(1,i1);
			}
			//초기화
			swapData(0,i0);
		}
	}
	/**
	 * 재귀적 구조로 받은 input이 몇 개의 상태를 표현할 수 있는지 계산하고 상태를 보여주는 함수입니다.
	 * @param input 재귀적 구조 함수에 넣어줄 명시적data
	 * @param result 결과값
	 */
	public void Recursion(char [] input, String result) {
		//재귀가 끝나는 지점
		if(input.length == 1) {
			count++;
			System.out.println(count+"  "+result+input[0]);
		}
		for(int i=0; i<input.length; i++) {
			swapData(input, 0, i);
			result += input[0];
			//첫 번째 자리를 제외하고 다시 함수를 호출(재귀)
			Recursion(Arrays.copyOfRange(input, 1, input.length), result);
			result = result.substring(0, result.length()-1);
		}
	}
	
	/**
	 * Recursion을 호출할 때 사용자가 매개변수를 넘겨주지 않아도 overloading해서 실행하는 함수 
	 */
	public void Recursion() {
		Recursion(this.data, "");
	}
	
	/**
	 * 매개변수로 받은 두 인자값에 해당되는 data배열의 순서를 서로 바꿔주는 함수입니다.
	 * @param level index와 swap될 변수
	 * @param index level과 swap될 변수
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
	 * @param data swap을 해줄 배열입니다.
	 * @param level indext와 swap될 변수
	 * @param index level과 swap될 변수
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
	 * 기존에 만들어졌던 toString을 overriding해서 재정의함 
	 * data배열의 각 아이템들을 순서대로 합쳐서 string으로 변환시켜주는 함수
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
