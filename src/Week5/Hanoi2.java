package Week5;

public class Hanoi2 {
	int maxSize;
	String [][] poles;
	int [] curPlates = {0,0,0};
	
	public Hanoi2(String[] plates) {
		maxSize = plates.length;
		poles = new String[3][maxSize];
		poles[0] = plates;
		curPlates[0] = maxSize;
	}
	private void hanoi(int i, int j) {
		hanoi(maxSize, i-1, j-1);
	}
	public void hanoi(int level, int from, int to) {
		if(level == 1) {
			move(level,from, to);
		}else {
			int extra = (3-from-to)%3;
			hanoi(level-1, from, extra);
			showTower();
			move(level, from, to);
			showTower();
			hanoi(level-1, extra, to);
		}
	}
	
	public void showTower() {
		System.out.println();
		for(int i =0; i<3; i++) {
			System.out.print("Pole "+(i+1)+" |");
			for(int j=0; j<curPlates[i]; j++) {
				System.out.print(poles[i][j]+" |");
			}
			System.out.println();
		}
	}
	
	private void move(int level, int from, int to) {
		curPlates[from]--;
		if(curPlates[from]<0) {
			System.out.println("Indexing Error...");
			return;
		}
		poles[to][curPlates[to]]=poles[from][curPlates[from]];
		curPlates[to]++;
	}

	public static void main(String[] args) {
		String [] plates = {"±ÕÁ¤", "ÇÏ´Ã", "¿¬µÎ", "º¸¶ó", "ÃÊ·Ï","»¡°­","ÁÖÈ²"};
		Hanoi2 me = new Hanoi2(plates);
		
		me.showTower();
		me.hanoi(1, 2);
		me.showTower();

	}

}
