package MidTerm;

public class MyClass implements Comparable<MyClass> {

	int idNumber;
	String name;
	public MyClass(int i, String s) {
		idNumber=i;
		name=s;
	}
	
//	public int compareTo(MyClass that) {
//		if(this.idNumber > that.idNumber) {
//			return 1;
//		} else if (this.idNumber < that.idNumber) {
//			return -1;
//		} else {
//			return 0;
//		}
//	}
	
	public int compareTo(MyClass that) {
		return this.name.compareTo(that.name);
	}
	
	public boolean equals(MyClass that) {
		return this.name.equals(that.name);
	}
	
	public String toString() {
		return name + " ["+idNumber+"] ";
	}

}