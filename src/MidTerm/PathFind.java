package MidTerm;


public class PathFind {
	
	int[][] matrix;
	int[][] memo;
	//호출횟수
	int nOfCalls;
	
	public PathFind(int[][] input) {
		matrix = input;
		nOfCalls = 0;
	}
	
	//2-1 을 구하는 메소드
	public int maxPathWeight(int row, int col) {
		nOfCalls++;
		if(row == 0 && col == 0) return matrix[row][col];
		else if(row==0) return matrix[row][col] + maxPathWeight(row, col-1);
		else if(col==0) return matrix[row][col] + maxPathWeight(row-1, col);
		//대각선 포함
		else return matrix[row][col] + Math.max(Math.max(maxPathWeight(row, col-1), maxPathWeight(row-1, col)), maxPathWeight(row-1, col-1));
	}
	
	public int nCalls() {
		return nOfCalls;
	}
	
	public void initMemo() {
		nOfCalls = 0;
		int n = matrix.length;
		memo = new int[n][n];
	}
	
	//2-2를 구하는 메소드
	public int maxPathWeight2(int row, int col) {
		nOfCalls++;
		
		if(row==0 && col ==0) {
			if(memo[row][col]==0) {
				memo[row][col] = matrix[row][col];
			}
			return memo[row][col];
		}
		else if(row==0) {
			if(memo[row][col] ==0) {
				memo[row][col] = matrix[row][col]+maxPathWeight2(row, col-1);
			}
			return memo[row][col];
		}
		else if(col==0) {
			if(memo[row][col] ==0) {
				memo[row][col] = matrix[row][col]+maxPathWeight2(row-1, col);
			}
			return memo[row][col];
		}
		else {
			if(memo[row][col] ==0) {
				memo[row][col] = matrix[row][col]+
						//대각선 포함
						Math.max(Math.max(maxPathWeight2(row, col-1), maxPathWeight2(row-1, col)), maxPathWeight2(row-1, col-1));
			}
			return memo[row][col];
		}
	}

	public static void main(String[] args) {
		int n = 6;
		int[][] matrix = 
					{{6,-7,12,-5,2,8},
					{0,-3,11,18,-1,6},
					{0,0,17,-3,-5,-11},
					{0,0,0,-2,13,-4},
					{0,0,0,0,-9,10},
					{0,0,0,0,0,5},};
		
		PathFind pf = new PathFind(matrix);
		System.out.println(pf.maxPathWeight(n-1, n-1)+"("+pf.nCalls()+")");
		
		pf.initMemo();
		System.out.println(pf.maxPathWeight2(n-1, n-1)+"("+pf.nCalls()+")");

	}

}
