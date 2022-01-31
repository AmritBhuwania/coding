package test;

import java.util.stream.Stream;

public class StringUse {

	public static void main(String[] args) {
		StringBuilder a = new StringBuilder("abc");
		StringBuilder b = a;

		a.append("sdf");

		System.out.println(a==b);
		System.out.println(a.equals(b));

		String s1 = "Test";
		String s2 = "Test";
		String s3 = new String("Test");
		final String s4 = s3.intern();
		System.out.println(s1 == s2);
		System.out.println("Here:" + s2 == s3);
		System.out.println("Here:" + s3 == s4);
		System.out.println(s1 == s3);
		System.out.println(s1 == s4);
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(s3.equals(s4));
		System.out.println(s1.equals(s4));
		System.out.println(s1.equals(s3));
		
		Stream<String> st = Stream.iterate("", (str) -> str + "x"); 
		System.out.println(st.limit(3).map(str -> str + "y"));
	}

}
