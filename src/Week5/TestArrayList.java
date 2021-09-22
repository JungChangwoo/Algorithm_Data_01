package Week5;

import java.util.List;
import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		
		ArrayList ar = new ArrayList();
		ar.add(1);
		System.out.println(ar);
		ar.add("sabc");
		System.out.println(ar);
		
		List l = new ArrayList();
		l.add(10);
		l.add("asdf");
		System.out.println(l);
		
		Object o = new Object();
		System.out.println(o);
		o = 3;
		System.out.println(o);
		
		int x = (int) ar.get(0);
		String y = (String) ar.get(1);
		
		ArrayList<Integer> ari = new ArrayList<>();
		ArrayList<String> ars = new ArrayList<>();
		ari.add(1);
		ars.add("string");
		x = ari.get(0);
		y = ars.get(0);
		
		ArrayList<MyClass> arm = new ArrayList<>();
		arm.add(new MyClass(3, "asdf"));
		MyClass mc = arm.get(0);

	}

}
