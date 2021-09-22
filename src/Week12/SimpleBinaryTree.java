package Week12;

public class SimpleBinaryTree {
	
	TreeNode root = null;

	public TreeNode makeTree(TreeNode l, char val, TreeNode r) {
		root = new TreeNode(l, val, r);
		return root;
	}
	
	public void showTree(TreeNode t) {
		if(t != null) {
			showTree(t.left);
			System.out.print(t.data);
			showTree(t.right);
		}
	}
	
	public void treeInArray(TreeNode t) {
		char [] treeArray = new char[8];
		
		convert(t, treeArray, 1);
		
		System.out.println("< Tree In Array >");
		for(int i=0; i<8; i++) {
			System.out.println("  "+i+" : "+treeArray[i]);
		}
	}
	
	private void convert(TreeNode t, char[] treeArray, int i) {
		if(t != null) {
			treeArray[i] = t.data;
			convert(t.left, treeArray, 2*i);
			convert(t.right, treeArray, 2*i+1);
		}
	}
	
	public static void main(String[] args) {

		SimpleBinaryTree bt1 = new SimpleBinaryTree();
		
		TreeNode n1 = bt1.makeTree(null, 'A', null);
		TreeNode n2 = bt1.makeTree(null, 'B', null);
		TreeNode n3 = bt1.makeTree(n1, '*', n2);
		TreeNode n4 = bt1.makeTree(null, 'C', null);
		TreeNode n5 = bt1.makeTree(null, 'D', null);
		TreeNode n6 = bt1.makeTree(n4, '/', n5);
		TreeNode n7 = bt1.makeTree(n3, '-' , n6);
		
		bt1.showTree(n3);
		System.out.println();
		
		bt1.showTree(n6);
		System.out.println();
		
		bt1.showTree(n7);
		System.out.println();
	}

}
