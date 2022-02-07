package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author amrit
 * Find the next greater element after the current element in the array
 * eg. Input: { 18, 3, 19, 23, 5, 21, 9 }
 * 	 Output : {-1, 18, -1, -1, 23, 23, 21}
 */
public class NextGreater {

	public static void main(String[] args) {
		int arr[] = { 18, 3, 19, 23, 5, 21, 9 };
		int n = arr.length;
		printNGE(arr, n);
	}

	static void printNGE(int ar[], int n) {

		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> ans = new ArrayList<Integer>();
		int size = ar.length;

		stack.add(ar[size-1]);
		ans.add(-1);
		int peek;

		for (int i = size - 2; i >= 0; --i) {
			
			int curr = ar[i];
			System.out.println(curr);

			peek = stack.peek();

			// Case1: if top of stack(peek) > current element(curr) 
			if (curr < peek) {
				stack.add(curr);
				ans.add(peek);

			} else {
				while(!stack.isEmpty()) {
					peek = stack.peek();
					/* Case2: Keep comparing peek element with current element to find a greater element and
					 * if its not the case, keep popping the element from stack until stack is empty
					 * or we find a greater element in stack than the current element
					 */
					if (curr >= peek) {
						stack.pop();
					} else {
						break;
					}
				}

				// if stack became empty, the current element was highest till now, push in stack
				if (stack.isEmpty()) {
					stack.add(curr);
					ans.add(-1);
				} else {
					stack.add(curr);
					ans.add(peek);
				}
			}
		}
		Collections.reverse(ans);
		System.out.println(ans);
	}
}
