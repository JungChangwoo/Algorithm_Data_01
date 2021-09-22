package Week4;

/**
 * 하노이탑 예제를 통해서 재귀함수 알고리즘에 대한 심화를 위한 Class
 * @author ikkwi
 *
 */
public class Hanoi {
	
	/**
	 * 하노이 탑 알고리즘 구하는 함수
	 * @param n = 몇개의 원반
	 * @param A = 원반이 쌓여있는 탑
	 * @param B = 우리가 옮길 탑
	 * @param C = 비어있는 탑
	 */
	public void hanoi(int n, char A, char B, char C) {
		if(n ==1) {
			move(n, A, B);
		} else {
			//n-1개의 원반을 A->C로 보조기둥 B를 이용하여 옮긴다. 
			hanoi(n-1, A, C, B);
			//제일 큰 원반을 A-> B로 옮긴다.
			move(n, A, B);
			//n-1개의 원반을 C->B로 옮기고 보조 기둥 A를 이용하여 옮긴다.
			hanoi(n-1, C, B, A);
		}
	}
	
	//원반을 옮기고 옮기는 과정을 보여줌
	public void move(int n, char start, char goal) {
		char A = start;
		char B = goal;
		System.out.println(n+"원반을 "+A+"에서"+B+"로");
	}

	public static void main(String[] args) {
		int n = 6;
		char Start = 'A';
		char Goal = 'B';
		char Assistant = 'C';
		Hanoi h = new Hanoi();
		h.hanoi(4, Start, Goal, Assistant);

	}

}
