package java8;

interface InterF {

	void add(int a, int b);
}

// No need to implement the Interface
public class Lambda {

	public static void main(String[] args) {
		InterF f = (a, b) -> System.out.println(a+b);

		f.add(10, 20);
		f.add(10, 10);
	}
}
