package test;

import java.util.Scanner;
import java.util.Stack;

public class SampleTest {

	//2+3 = 5 + 5 = 10 

	public static void main(String[] args) {
		char c;

		Stack<Integer> myResults = new Stack<>();
		Stack<Integer> redos = new Stack<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st val: ");
		int num = sc.nextInt();
		int result = num;
		int num2 = 0;

		boolean hasToInsertInStack;
		while (sc.hasNext()) {

			//System.out.println("Enter operator: ");
			String str = sc.next();

			if (!str.equals("u") && !str.equals("r")) {
				//System.out.println("Enter next number: ");
				num2 = sc.nextInt();
			}
			hasToInsertInStack = true;
			switch (str) {
			case "+":
				result += num2;
				break;

			case "-":
				result -= num2;
				break;

			case "*":
				result *= num2;
				break;

			case "/":
				result /= num2;
				break;

			case "u":
				redos.push(myResults.pop());
				hasToInsertInStack = false;
				result = myResults.peek();

				break;
				
			case "r":
				result = redos.pop();
				break;

			default:
				System.out.println("Invalid char/number");
				break;
			}

			System.out.println("Result: " + result);
			if (hasToInsertInStack) {
				myResults.push(result);
			}

		}


	}

}
