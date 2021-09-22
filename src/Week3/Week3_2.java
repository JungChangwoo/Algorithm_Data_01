package Week3;

/**
 * 행렬의 좌상단에서 시작하여 우하단까지 이동하면서 방문한 수들을
 * 더한 값이 최대가 되도록 하는 
 * 경로를 찾는 함수
 * @author ChangwooJUNG
 */
public class Week3_2 {
	/**
	 * 설정한 행렬
	 */
	int [][] path;
	
	
	public Week3_2(int [][] input) {
		path = input;
	}
	
	//거꾸로 우하단부터 좌상단까지 위 or왼쪽 방향으로 재귀함수를 호출함
	public int FindMaxPath(int [][] path,int row, int column) {
		
		/**
		 * 재귀함수의 탈출 조건
		 * row와 column이 0이 되면 즉, 좌상단이 되면 탈출함
		 */
		if(row==0 && column==0) {
			return path[0][0];
		}
		//더이상 위쪽으로 움직일 수 없다면, 왼쪽으로 이동한 재귀함수 호출
		else if (row == 0) {
			return FindMaxPath(path, 0, column-1) + path[row][column];
		}
		//더이상 왼쪽으로 움직일 수 없다면, 위로 이동한 재귀함수 호출
		else if (column == 0) {
			return FindMaxPath(path, row-1, 0) + path[row][column];
		}
		//Math.max를 이용해 왼쪽 or 위로 이동했을 때 더 큰 값을 반환해줌
		else {
			return Math.max(FindMaxPath(path,row-1,column), FindMaxPath(path,row,column-1))+path[row][column];
		}
	}


	
	

	public static void main(String[] args) {
		/**
		 * 경로 설정
		 */
		int path[][] = {
				{6,7,12,3},
				{5,3,29,18},
				{9,25,3,3},
				{8,10,14,9}
		};
		Week3_2 instance = new Week3_2(path);
		//결과
		int result = instance.FindMaxPath(path, 3, 3);
		//결과 출력
		System.out.println(result);
		
	}

}
