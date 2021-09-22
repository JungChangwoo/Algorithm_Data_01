package Week3;

/**
 * ����� �»�ܿ��� �����Ͽ� ���ϴܱ��� �̵��ϸ鼭 �湮�� ������
 * ���� ���� �ִ밡 �ǵ��� �ϴ� 
 * ��θ� ã�� �Լ�
 * @author ChangwooJUNG
 */
public class Week3_2 {
	/**
	 * ������ ���
	 */
	int [][] path;
	
	
	public Week3_2(int [][] input) {
		path = input;
	}
	
	//�Ųٷ� ���ϴܺ��� �»�ܱ��� �� or���� �������� ����Լ��� ȣ����
	public int FindMaxPath(int [][] path,int row, int column) {
		
		/**
		 * ����Լ��� Ż�� ����
		 * row�� column�� 0�� �Ǹ� ��, �»���� �Ǹ� Ż����
		 */
		if(row==0 && column==0) {
			return path[0][0];
		}
		//���̻� �������� ������ �� ���ٸ�, �������� �̵��� ����Լ� ȣ��
		else if (row == 0) {
			return FindMaxPath(path, 0, column-1) + path[row][column];
		}
		//���̻� �������� ������ �� ���ٸ�, ���� �̵��� ����Լ� ȣ��
		else if (column == 0) {
			return FindMaxPath(path, row-1, 0) + path[row][column];
		}
		//Math.max�� �̿��� ���� or ���� �̵����� �� �� ū ���� ��ȯ����
		else {
			return Math.max(FindMaxPath(path,row-1,column), FindMaxPath(path,row,column-1))+path[row][column];
		}
	}


	
	

	public static void main(String[] args) {
		/**
		 * ��� ����
		 */
		int path[][] = {
				{6,7,12,3},
				{5,3,29,18},
				{9,25,3,3},
				{8,10,14,9}
		};
		Week3_2 instance = new Week3_2(path);
		//���
		int result = instance.FindMaxPath(path, 3, 3);
		//��� ���
		System.out.println(result);
		
	}

}
