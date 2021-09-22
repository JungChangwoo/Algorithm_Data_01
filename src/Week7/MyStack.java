package Week7;

public class MyStack {
	
	MyLinkedList1 stack = new MyLinkedList1();
	
	public void push(String data) {
		stack.addFirst(data);
	}

	public String pop() {
		if(stack.sizeOf() == 0) {
			return null;
		}
		else {
			return stack.removeFirst();
		}
	}
	
	public int sizeOf() {
		return stack.sizeOf();
	}
	
	public void showStack() {
		System.out.println(stack.toString());
	}

	public static void main(String[] args) {
		MyStack st = new MyStack();
		
		st.push("lee");
		st.push("kim");
		st.push("park");
		st.push("jung");
		st.showStack();
		
		System.out.println(st.pop());
		System.out.println(st.pop());
		st.showStack();
	}

}
