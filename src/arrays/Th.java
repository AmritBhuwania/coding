package arrays;

public class Th extends Thread {
	
	private static int x;
	
	public synchronized void thi() {
		int c = x;
		c++;
		x = c;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		thi();
	}
	
	public static void main(String[] args) {
		Thread t = new Th();
		System.out.println("H");
		t.start();
		t.run();
	}
	
	

}
