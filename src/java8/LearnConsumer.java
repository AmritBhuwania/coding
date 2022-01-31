package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LearnConsumer {

	public static void main(String[] args) {

		Consumer<String> c = c1 -> System.out.println(c1);
		c.accept("1");
		c.accept("bnm");
		c.accept("fghj");

		List<String> list = Arrays.asList("cgh", "cgv", "cfghj", "fgh");
		for (String s: list)
			c.accept(s);
	}
}
