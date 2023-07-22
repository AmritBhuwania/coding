package java8;

import java.util.function.Predicate;

public class LearnPredicate {
	
	public static Predicate<String> p = i -> i.length()%2 == 0;
	
	public static void main(String[] args) {
		
		System.out.println(p.test("10"));
		System.out.println(p.test("311"));
		System.out.println(p.test("df"));
		
		Predicate<Integer> p1 = i -> i%2 == 0;
		System.out.println(p1.test(1));
		System.out.println(p1.test(2));
		System.out.println(p1.test(null));
	}
	

}
