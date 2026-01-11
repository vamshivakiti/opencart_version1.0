package keyworgsThisSatic;

public class StaticDemo {
	static int dept=101;
int empId;
int salary;
String name;
 void emp() {
	 int empId;
	 int salary;
	 String name;
 }

public static void main(String[] args) {
	StaticDemo sd = new StaticDemo();
	sd.emp();
}
}
