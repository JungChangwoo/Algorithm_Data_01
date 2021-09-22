package Practice;

public class Practice {
	
	public int FindMaxPath(int [][] path, int row, int column) {
		
		if(row ==0 && column == 0) {
			return path[0][0];
		}
		else if(row==0) {
			return path[row][column] + FindMaxPath(path,row, column-1);
		}
		else if(column==0) {
			return path[row][column] + FindMaxPath(path,row-1, column);
		}
		else {
			return path[row][column] + Math.max(FindMaxPath(path,row, column-1), FindMaxPath(path,row-1, column));
		}
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] matrix = 
					{{6,5,2,21},
					{5,3,11,18},
					{0,15,3,3},
					{3,1,4,63}};
		Practice pf = new Practice();
		System.out.println(pf.FindMaxPath(matrix, n, n));
		
	}
	
	

}
