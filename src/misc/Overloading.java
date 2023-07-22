package misc;

public class Overloading {

	public void print(Object o) {
		System.out.println("object");
	}

	public void print(Integer o) {
		System.out.println("integer");
	}

	public void print(String o) {
		System.out.println("string");
	}
	
	public static void main(String[] args) {
		Overloading overloading = new Overloading();
		
		// Ambiguity between integer and string
		// overloading.print(null);
	}
}
