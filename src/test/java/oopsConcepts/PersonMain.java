package oopsConcepts;

public class PersonMain {

	public static void main(String[] args) {
		
		Person ravi = new Person();
		ravi.name="Ravi Kumar";
		ravi.age=29;
		ravi.isMarried=false;
		
		ravi.address="Hyderabad";
		ravi.print();
		ravi.eat("Biryani");
	System.out.println(	ravi.talk("Good Morning"));

	}

}
