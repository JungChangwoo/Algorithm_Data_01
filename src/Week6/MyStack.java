package Week6;

public class MyStack {
	
	MyArrayList1 stack = new MyArrayList1(3);
	
	int top = 0;
	
	public void push(String data) {
		stack.addLast(data);
		top = stack.sizeOf();
		System.out.println(top);
	}

	public String pop() {
		if(stack.sizeOf() == 0) {
			return null;
		} else {
			String retVal = stack.remove(top-1);
			top = stack.sizeOf();
			return retVal;
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
		
	

	}

}
