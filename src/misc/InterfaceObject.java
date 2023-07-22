package misc;


interface MyInterface{
	public int num = 30;
	public void demo();
}


public class InterfaceObject implements MyInterface {
	public void demo() {
		System.out.println("This is the implementation of the demo method");
	}
	public static void main(String args[]) {
		MyInterface obj = new InterfaceObject();
		obj.demo();
		System.out.println(MyInterface.num);
	}
}
