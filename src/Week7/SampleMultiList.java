package Week7;

import Week6.MyArrayList3;

public class SampleMultiList<E extends Comparable<E>> {
	MyArrayList3<Group> groupList ;
	
	public SampleMultiList() {
		groupList = new MyArrayList3<>(3);	
	}
	
	public void add(String g, E entity) {
		System.out.println("Add : "+g+", " + entity.toString());

		int index = indexOf(g);
		//이미 그룹이 생성됨
		if (index>=0)
			//바로 node추가하듯이 추가
			groupList.get(index).list.addFirst(entity);
		else {
			//이미 그룹이 생성되지 않았다면, 
			groupList.addLast(new Group(g));
			System.out.println(groupList.toString());
			System.out.println(groupList.get(groupList.sizeOf()-1).list);

			groupList.get(groupList.sizeOf()-1).list.addFirst(entity);
		}
	}
	
	private int indexOf(String g) {
		for (int i=0; i<groupList.sizeOf();i++) {
			if (groupList.get(i).gname==g)
				return i;
		}
		return -1;
	}

	public void showLists() {
		System.out.println("\n< Lists of All Groups >");
		for (int i=0;i<groupList.sizeOf();i++) {
			System.out.println(groupList.get(i).toString());
		}
	}
	
	public void sort() {
		groupList.sort();
	}

	public static void main(String[] args) {
		SampleMultiList<StudentInfo> myList = new SampleMultiList<>();
		
		myList.add("group2", new StudentInfo(131, "Kim"));
		myList.add("group4", new StudentInfo(432, "Hwang"));
		myList.add("group3", new StudentInfo(222, "Cho"));
		myList.add("group1", new StudentInfo(123, "Lee"));
		myList.add("group1", new StudentInfo(321, "Park"));
		myList.add("group3", new StudentInfo(133, "Song"));
		myList.add("group2", new StudentInfo(333, "Choi"));
		myList.add("group1", new StudentInfo(233, "Jung"));
		
		myList.showLists();
		
		myList.sort();
		
		myList.showLists();


	}
	static class StudentInfo implements Comparable<StudentInfo>{
		int id;
		String name;
		public StudentInfo(int idNumber, String nameString) {
			id = idNumber;
			name = nameString;
		}
		@Override
		public int compareTo(StudentInfo that) {
			return (this.id>that.id)? 1 : (this.id<that.id)? -1 : 0;
		}
		
		public String toString() {
			return name+"["+id+"]";
		}
	} 
	private class Group implements Comparable<Group>{
		String gname;
		MyLinkedList<E> list;
		
		public Group(String groupName) {
			gname = groupName;
			list=new MyLinkedList<>();
		}
		@Override
		public int compareTo(Group that) {
			return (this.gname.compareTo(that.gname));
		}
		
		public boolean equals(Group that) {
			return (this.gname.equals(that.gname));
		}
		
		public String toString() {
			String retVal=gname;
			if (list!=null)
				retVal = retVal+" => "+list.toString();
			return retVal;
		}
	}

}