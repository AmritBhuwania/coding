package recursion;

public class PhonePad {
	
	public static void main(String[] args) {
		pad("", "12");
	}
	
	static void pad(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		int digit = up.charAt(0) - '0'; // converts '1' to 1
		
		for (int i = 3 * (digit-1); i < 3 * digit; ++i) {
			char ch = (char)('a'+i);
			pad(p + ch, up.substring(1));
			//pad(p, up.substring(1));
		}
	}
}
