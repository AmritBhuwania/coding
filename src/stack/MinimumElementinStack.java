package stack;

import java.util.Stack;

/**
 * @author amrit
 * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(),
 * isEmpty(), isFull() and an additional operation getMin() which should return minimum element
 * from the SpecialStack. All these operations of SpecialStack must be O(1). To implement SpecialStack,
 * you should only use standard Stack data structure and no other data structure like arrays, list, etc.

	Link: https://youtu.be/asf9P2Rcopo
	Refer: https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 */

public class MinimumElementinStack {

	static Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public static void main(String[] args) {

		MinimumElementinStack elementinStack = new MinimumElementinStack();
		elementinStack.push(7);
		elementinStack.push(5);
		elementinStack.push(2);
		elementinStack.push(8);
		elementinStack.push(3);
		elementinStack.displayStack();
		System.out.println("Min element: " + elementinStack.minElement());
		System.out.println("Popped Element: " + elementinStack.pop());
		elementinStack.displayStack();
		System.out.println("Min element: " + elementinStack.minElement());
		System.out.println("Popped Element: " + elementinStack.pop());
		elementinStack.displayStack();
		System.out.println("Min element: " + elementinStack.minElement());
		System.out.println("Popped Element: " + elementinStack.pop());
		elementinStack.displayStack();
		System.out.println("Min element: " + elementinStack.minElement());
		System.out.println("Popped Element: " + elementinStack.pop());
		elementinStack.displayStack();
		System.out.println("Min element: " + elementinStack.minElement());
		System.out.println("Popped Element: " + elementinStack.pop());
		elementinStack.displayStack();
		System.out.println("Min element: " + elementinStack.minElement());
		System.out.println("Popped Element: " + elementinStack.pop());
	}

	int minElement() {
		if(minStack.size() == 0) return -1;

		return minStack.peek();
	}

	void push(int elem) {
		stack.push(elem);

		if (minStack.size() == 0 || elem <= minStack.peek()) {
			minStack.push(elem);
		}
	}

	int pop() {
		if (stack.size() == 0) {
			return -1;
		}

		int elem = stack.pop();

		if (minStack.peek() == elem) {
			minStack.pop();
		}
		return elem;
	}

	void displayStack () {

		if (stack.isEmpty()) {
			System.out.println("Stack is Empty!" + "\n");
			return;
		}

		Stack<Integer> s = new Stack<Integer>();

		while (!stack.isEmpty()) {
			s.push(stack.pop());
		}

		System.out.print("Stack: ");
		while (!s.isEmpty()) {
			int x = s.pop();
			System.out.print(x + ", ");
			stack.push(x);
		}
		System.out.println("\n");
	}

}
