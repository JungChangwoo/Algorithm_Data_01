package Week4;

public class Fibonacci {
	static long count=0;
	long memo;
	
	public long fiboRecursion(int n) {
		count++;
		if(n<=0) {
			if(memo ==0) {
				memo = 0;
			}
			return memo;
		}
		if(n==1) {
			if(memo == 0) {
				memo = 1;
			}
			return memo;
		}
		if(memo == 0) {
			memo = fiboRecursion(n-1)+fiboRecursion(n-2);
		}
		return memo;
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		long val;
		for(int n=5; n<30; n++) {
			val = f.fiboRecursion(n);
			System.out.println(" (recursion)"+count);
		}
	}

}
