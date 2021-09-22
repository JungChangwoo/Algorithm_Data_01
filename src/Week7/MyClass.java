package Week7;

public class MyClass implements Comparable<MyClass>{
	
	int idNumber;
	String name;

	public MyClass(int i, String s) {
		idNumber = i;
		name = s;
	}
	
	public int compareTo(MyClass that) {
		return this.name.compareTo(that.name);
	}
	
	public boolean equals(MyClass that) {
		return this.name.equals(that.name);
	}
	
	public String toString() {
		return name+" ["+idNumber+"] "; 
	}

}
