package Week6;

public class MyQueue1 {
	MyArrayList1 queue = new MyArrayList1(3);
	int front = 0;
	int rear = 0;
	
	public void enqueue(String data) {
		queue.add(rear, data);
		rear = queue.sizeOf();
	}
	
	public String dequeue() {
		if(front == rear) {
			return null;
		} else {
			String retVal = queue.remove(front);
			rear = queue.sizeOf();
			return retVal;
		}
	}
	
	public int sizeOf() {
		return rear- front;
	}
	
	public void showQueue() {
		System.out.println(queue.toString());
	}
	
	public static void main(String[] args) {
		MyQueue1 q = new MyQueue1();
		
		q.enqueue("lee");
		q.enqueue("kim");
		q.enqueue("park");
		q.enqueue("choi");
		q.showQueue();
		
		System.out.println(q.sizeOf());
	}
}
