package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author amrit
 * Find the prev greater element after the current element in the array
 * eg. Input: { 18, 3, 19, 23, 5, 21, 9 }
 * 	 Output : {-1, 18, -1, -1, 23, 23, 21}
 */
public class PrevGreater {

	public static void main(String[] args) {
		int ar[] = { 18, 3, 19, 23, 5, 21, 9 };

		printPGE(ar);
	}

	static void printPGE(int ar[]) {

		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> ans = new ArrayList<Integer>();
		int size = ar.length;

		for (int i = 0; i < size; ++i) {

			/*
			 * Check 3 conditions:
			 * 1. if stack empty: insert -1 in answer
			 * 2. else if top of stack is greater than current element, insert the top element of stack in answer
			 * 3. else keep checking until stack is empty or we get an element in stack greater than current element
			 *    for this step, insert in answer according to 1st and 2 condition.
			 *  Keep inserting element & index in stack after each iteration
			 */			
			if (stack.isEmpty()) {
				ans.add(-1);
			} else if (stack.peek() > ar[i]) {
				ans.add(stack.peek());
			} else {
				while (!stack.isEmpty() && stack.peek() <= ar[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					ans.add(-1);
				} else {
					ans.add(stack.peek());
				}
			}
			stack.push(ar[i]);
		}
		System.out.println(ans);
	}
}
