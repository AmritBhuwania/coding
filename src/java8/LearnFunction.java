package java8;

import java.util.function.Function;

public class LearnFunction {

	public static Function<String, String> p = i -> i+i;

	public static void main(String[] args) {

		System.out.println(p.apply("1"));
		System.out.println(p.apply("2"));
		System.out.println(p.apply(null));

		Function<String, Integer> p1 = i -> i.length();
		System.out.println(p1.apply("1fghjh"));
		System.out.println(p1.apply("25678"));
		System.out.println(p1.apply(null));
	}

}
