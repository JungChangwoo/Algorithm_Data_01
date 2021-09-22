package Week4;

/**
 * �ϳ���ž ������ ���ؼ� ����Լ� �˰��� ���� ��ȭ�� ���� Class
 * @author ikkwi
 *
 */
public class Hanoi {
	
	/**
	 * �ϳ��� ž �˰��� ���ϴ� �Լ�
	 * @param n = ��� ����
	 * @param A = ������ �׿��ִ� ž
	 * @param B = �츮�� �ű� ž
	 * @param C = ����ִ� ž
	 */
	public void hanoi(int n, char A, char B, char C) {
		if(n ==1) {
			move(n, A, B);
		} else {
			//n-1���� ������ A->C�� ������� B�� �̿��Ͽ� �ű��. 
			hanoi(n-1, A, C, B);
			//���� ū ������ A-> B�� �ű��.
			move(n, A, B);
			//n-1���� ������ C->B�� �ű�� ���� ��� A�� �̿��Ͽ� �ű��.
			hanoi(n-1, C, B, A);
		}
	}
	
	//������ �ű�� �ű�� ������ ������
	public void move(int n, char start, char goal) {
		char A = start;
		char B = goal;
		System.out.println(n+"������ "+A+"����"+B+"��");
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
