package test;

public class DiamondProblem {

	public static void main(String[] args) {
		new AB().hi();
		new DE().bla();
		new DEF().bla();
	}
}

interface A {
	default void hi() { System.out.println("A"); }
}

interface B {
	default void hi() { System.out.println("B"); }
}

class AB implements A, B { // won't compile

	public void hi() { A.super.hi(); }

}



interface D extends A { }

interface E extends A { }

interface F extends A {
	default void hi() { System.out.println("F"); }
}

class DE implements D, E { 

	public void bla() {
		// TODO Auto-generated method stub
		new DE().hi(); // prints A

	}
}

class DEF implements D, E, F { 

	public void bla() {
		// TODO Auto-generated method stub
		new DEF().hi(); // prints A

	}
}


