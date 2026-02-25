package oopsConcepts;

public class Person {

	String name;
	byte age;
	boolean isMarried;
	String address;
	long ph_num;
	double salary;
	void print() {
		
		System.out.println(age);
		System.out.println(address);
		System.out.println("my name is :"+name);
	}
	void walk() {
		System.out.println("I can walk");
	}
	
	void eat(String item) {
		System.out.println("I love to eat "+item);
	}
	
	String sleep() {
		return "Love to sleep";
	}
	
	String talk(String msg) {
		
		return msg;
	}
	

}
