package pm.HashSet;

import java.util.HashSet;

class Person{
	String name;
	int age;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public int hashCode(){
		return name.hashCode(); 
	}
	public boolean equal(Object obj){
		if(this == obj)
			return true;
		if(obj==null)
			return false;
		Person other = (Person)obj;
		return other.name.equals(this.name);
	}
}

public class Demo1 {
	public static void main(String[] args) {
		HashSet hashset =new HashSet();
		Person p1= new Person("jjjj",28);
		Person p2= new Person("aaaa",22);
		Person p3= new Person("jjjj",24);
		hashset.add(p1);
		hashset.add(p2);
		hashset.add(p3);
		for(Object obj:hashset){
			Person p =(Person) obj;
			System.out.println(p.name+":"+p.age);
		}
	}

}
