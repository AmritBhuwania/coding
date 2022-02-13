package stack;

import java.util.Stack;

/**
 * @author amrit
 * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(),
 * isEmpty(), isFull() and an additional operation getMin() which should return minimum element
 * from the SpecialStack. All these operations of SpecialStack must be O(1). To implement SpecialStack,
 * you should only use standard Stack data structure and no other data structure like arrays, list, etc.

	Link: https://youtu.be/ZvaRHYYI0-4
 */

public class MinimumElementinStackInO1 {

	static Stack<Integer> stack = new Stack<Integer>();
	int minElement = -1;

	public static void main(String[] args) {

		MinimumElementinStackInO1 elementinStack = new MinimumElementinStackInO1();
		elementinStack.push(7);
		elementinStack.push(5);
		elementinStack.push(2);
		elementinStack.push(8);
		elementinStack.push(3);

		elementinStack.displayStack();
		System.out.println("Min element: " + elementinStack.minElement());
		System.out.println("Top element: " + elementinStack.top());
		System.out.println("Popped Element: " + elementinStack.pop());
		elementinStack.displayStack();
		System.out.println("Min element: " + elementinStack.minElement());
		System.out.println("Top element: " + elementinStack.top());
		System.out.println("Popped Element: " + elementinStack.pop());
		elementinStack.displayStack();
		System.out.println("Min element: " + elementinStack.minElement());
		System.out.println("Top element: " + elementinStack.top());
		System.out.println("Popped Element: " + elementinStack.pop());
		elementinStack.displayStack();
		System.out.println("Min element: " + elementinStack.minElement());
		System.out.println("Top element: " + elementinStack.top());
		System.out.println("Popped Element: " + elementinStack.pop());
		elementinStack.displayStack();
		System.out.println("Min element: " + elementinStack.minElement());
		System.out.println("Top element: " + elementinStack.top());
		System.out.println("Popped Element: " + elementinStack.pop());
		elementinStack.displayStack();
		System.out.println("Min element: " + elementinStack.minElement());
		System.out.println("Top element: " + elementinStack.top());
		System.out.println("Popped Element: " + elementinStack.pop());
	}

	int minElement() {
		if(stack.size() == 0) return -1;
		return minElement;
	}

	void push(int elem) {

		if (stack.size() == 0) {
			stack.push(elem);
			minElement = elem;

		} else if (elem >= minElement) {
			stack.push(elem);

		} else {
			// its a relation/trick so that we can get the prev minimum value
			// when the current min val will be poppped
			stack.push(2 * elem - minElement);
			minElement = elem;
		}
	}

	int pop() {

		if (stack.size() == 0) {
			return -1;

		} else if (stack.peek() >= minElement) {
			return stack.pop();

		} else {
			// store the original min value which would be the original value that has to be returned
			int tempMin = minElement;
			minElement = 2 * minElement - stack.peek();
			stack.pop();
			return tempMin;
		}
	}

	int top() {

		if (stack.size() == 0) {
			return -1;

		} else if (stack.peek() >= minElement) {
			return stack.peek();

		} else {
			return minElement;
		}
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

		System.out.print("Stack (Some may not be original value as they are used as flags): ");

		while (!s.isEmpty()) {
			int x = s.pop();
			System.out.print(x + ", ");
			stack.push(x);
		}
		System.out.println("\n");
	}

}
