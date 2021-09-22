package Week12;

public class BST {
	
	Node root;
	
	public BST() {
		root = null;
	}
	
	public void insert(char x) {
		if(root == null) {
			root = new Node(x);
		}
		else if(search(root, x) != null) {
			return;
		}
		else if ( x < root.data) {
			insert(root.left, root, x);
		}
		else {
			insert(root.right, root, x);
		}
	}
	
	private void insert(Node p, Node parent, char x) {
		if(p == null) {
			Node temp = new Node(x);
			temp.parent = parent;
			if(x < parent.data) {
				parent.left = temp;
			}
			else {
				parent.right = temp;
			}
		}
		else if(x < p.data) {
			insert(p.left, p, x);
		}
		else {
			insert(p.right, p, x);
		}
	}

	public Node search(Node startNode, char x) {
		Node p = startNode;
		if(p == null || p.data == x) {
			return p;
		}
		else if(x < p.data) {
			return search(p.left, x);
		}
		else {
			return search(p.right, x);
		}
	}
	
	public void delete(char x) {
		delete(root, x);
	}
	
	private void delete(Node startNode, char x) {
		Node v = search(startNode, x);
		if(v == null) {
			return;
		}
		//case 1 : no child
		if(v.left == null && v.right == null) {
			if(x < v.parent.data) {
				v.parent.left = null;
			}
			else {
				v.parent.right = null;
			}
			return;
		}
		//case 2 : 1 Child
		if(v.left == null || v.right == null) {
			if(v.left != null) {
				v.left.parent = v.parent;
				//삭제하려는 Node가 부모에서 왼쪽이면
				if(v == v.parent.left) {
					v.parent.left = v.left;
				}
				//삭제하려는 Node가 부모에서 오른쪽이면
				else {
					v.parent.right = v.left;
				}
			}
			else {
				v.right.parent = v.parent;
				if(v == v.parent.left) {
					v.parent.left = v.right;
				}
				else {
					v.parent.right = v.right;
				}
			}
			return;
		}
		//case 3 : 2 Child
		Node q = successor(v);
		v.data = q.data;
		delete(v.right, q.data);
		
	}
	
	private Node successor(Node v) {
		if(v == null) {
			return null;
		}
		Node p = v.right;
		while(p.left != null) {
			p = p.left;
		}
		return p;
	}
	
	private Node predecessor(Node v) {
		if(v == null) {
			return null;
		}
		Node p = v.left;
		while(p.right != null) {
			p = p.right;
		}
		return p;
	}
	
	
	public void showTree() {
		System.out.println(toString(root));
	}
	
	private String toString(Node t) {
		return inorder(t);
	}

	private String inorder(Node t) {
		if(t == null) {
			return "";
		}
		else {
			return inorder(t.left)+" "+t.data+" "+inorder(t.right);
		}
	}

	public static void main(String[] args) {
		char [] data = {'M', 'Y', 'U', 'N', 'G', 'I', 'S', 'W'};
		BST bt = new BST();
		
		for(int i=0; i<data.length; i++) {
			bt.insert(data[i]);
		}
		System.out.println("\nTree Created : ");
		bt.showTree(); 
		
		bt.delete('S');
		System.out.print("\nAfter deleting 'S'  : ");
		bt.showTree();
		bt.delete('G');
		System.out.print("\nAfter deleting 'G'  : ");
		bt.showTree();
		bt.delete('U');
		System.out.print("\nAfter deleting 'U'  : ");
		bt.showTree();
	}

}
