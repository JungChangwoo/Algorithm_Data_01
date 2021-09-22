package Week5;

public class Hanoi1 {
	
	int moveCounter = 0;
	public void hanoi(int level, char from, char to, char extra) {
		if(level == 1) {
			move(level,from, to);
		}else {
			hanoi(level-1, from, extra, to);
			move(level, from, to);
			hanoi(level-1, extra, to, from);
		}
	}
	
	public int howManyMove() {
		return moveCounter;
	}
	public void resetCount() {
		moveCounter = 0;
	}
	private void move(int level, char from, char to) {
		moveCounter++;
		System.out.println("Plate# "+level+" moved from "+from+" tp "+to);
	}
	public static void main(String[] args) {
		Hanoi1 me = new Hanoi1();
		int n = 4;
		me.hanoi(n, 'A', 'B', 'C');
		
		System.out.println(me.howManyMove());
		for(int i=3; i<10; i++) {
			me.resetCount();
			me.hanoi(i, 'A', 'B', 'C');
			System.out.println(i+" : "+me.howManyMove());
		}
	}

}
