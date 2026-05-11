package interview;

import com.github.javafaker.Faker;

public class FakerDemo {

	public static void main(String[] args) {
Faker faker = new Faker();
String firstName = faker.name().lastName();
String lastName = faker.name().lastName();

System.out.println(firstName);
System.out.println(lastName);
int id = faker.random().nextInt(1000);
System.out.println(id);
	

	}

}
