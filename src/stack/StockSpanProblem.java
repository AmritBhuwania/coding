package stack;

import java.util.Arrays;
import java.util.Stack;

import heap.Pair;

/**
 * @author amrit
 * Link: https://youtu.be/p9T-fE1g1pU
 * Question: The stock span problem is a financial problem where we have a series of n daily price quotes
 *  for a stock and we need to calculate span of stock’s price for all n days.
	The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days
	just before the given day, for which the price of the stock on the current day is less than or equal to
	its price on the given day.
	For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values
	for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */

public class StockSpanProblem {

	public static void main(String[] args)
	{
		int price[] = { 100, 80, 60, 60, 60, 75, 85 };

		calculateSpan(price);
	}

	private static void calculateSpan(int[] price) {

		int size = price.length;
		int[] ans = new int[size];

		/*
		 * Check 3 conditions:
		 * 1. if stack empty: insert -1 in answer
		 * 2. else if top of stack is greater than current element, insert the top element of stack in answer
		 * 3. else keep checking until stack is empty or we get an element in stack greater than current element
		 *    for this step, insert in answer according to 1st and 2 condition.
		 *  Keep inserting element & index in stack after each iteration
		 */

		// Pair contins key-value pair(element-index pair)
		Stack<Pair> stack = new Stack<>();

		for (int i = 0; i < size; i++) {

			if (stack.isEmpty()) {
				ans[i] = -1;
			}

			else if (stack.peek().getKey() > price[i]) {
				ans[i] = stack.peek().getValue();

			} else {
				while (!stack.isEmpty() && stack.peek().getKey() <= price[i]) {
					stack.pop();
				}

				if (stack.isEmpty()) {
					ans[i] = -1;
				}
				else {
					ans[i] = stack.peek().getValue();
				}
			}
			stack.push(new Pair(price[i], i));
		}

		// to get actual number of days, perform (index - ans[i])
		for (int i = 0; i < ans.length; i++) {
			ans[i] = i - ans[i];
		}

		System.out.println(Arrays.toString(ans));
	}
}
