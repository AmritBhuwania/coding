package recursion;

/**
 * 
 * @author amrit
 * Print possible ways of getting a target from a dice
 */
public class Dice {

	public static void main(String[] args) {
		dice("", 4);
	}
	
	static void dice(String p, int target) {
		
		if (target == 0) {
			System.out.println(p);
			return;
		}
		
		for (int i = 1; i <= target; ++i) {
			dice(p + i, target - i);
		}
	}
}
