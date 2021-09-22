package Week6;


/**
 * Circular Queue에 Generic Type을 적용한 Class
 * @author 정창우
 *
 */

public class MyQueue3<T> {
	int qSize = 5;
	T[] queue = (T[])new Object[qSize];
	int front = 0;
	int rear = 0;
	
	public boolean enqueue(T data) {
		if((rear+1)%qSize == front) {
			return false;
		} else {
			queue[rear] = data;
			rear = (rear+1)%qSize;
			return true;
		}
	}
	
	public T dequeue() {
		if(front == rear) {
			return null;
		} else {
			T retVal = queue[front];
			queue[front] = null;
			front = (front+1)%qSize;
			return retVal;
		}
	}
	
	public int sizeOf() {
		return (rear >= front) ? (rear-front):(rear-front+qSize);
	}
	
	public void showQueue() {
		for(int i=0; i< qSize; i++) {
			System.out.print(queue[i]+" - ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MyQueue3<MyClass> q = new MyQueue3<>();
		
		int idNum = 0;
		
		
		q.enqueue(new MyClass(idNum++, "lee"));
		q.enqueue(new MyClass(idNum++, "kim"));
		q.enqueue(new MyClass(idNum++, "park"));
		q.enqueue(new MyClass(idNum++, "choi"));
		q.showQueue();
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.showQueue();
		
		q.enqueue(new MyClass(idNum++, "lee"));
		q.enqueue(new MyClass(idNum++, "kim"));
		q.enqueue(new MyClass(idNum++, "park"));
		q.enqueue(new MyClass(idNum++, "choi"));
		q.showQueue();
		
		
	}
}

