package Week12;

public class TreeNode {
	
	char data;
	TreeNode left;
	TreeNode right;

	public TreeNode(TreeNode l, char val, TreeNode r) {
		data = val;
		left = l;
		right = r;
	}
	
	public String toString() {
		return ""+data;
	}
}
