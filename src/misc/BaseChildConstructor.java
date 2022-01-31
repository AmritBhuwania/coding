package misc;

public class BaseChildConstructor extends Base{

	public BaseChildConstructor() {
		
		System.out.println("Child age: " + ++this.age);
	}
	
	public static void main(String[] args) {
		
		Base base = new Base();
		
		System.out.println("Calling child construct");
		BaseChildConstructor childConstructor = new BaseChildConstructor();
	}
	

}

class Base {
	
	public int age;
	
	public Base() {
		this.age = 2;
		System.out.println("Base age: " + age);
		// TODO Auto-generated constructor stub
	}

}
