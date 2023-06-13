package slidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author amrit
 * First Negative Number in every Window of Size K | Sliding Window
 * Link : <a href="https://youtu.be/uUXXEgK2Jh8">...</a>
 */
public class FirstNegativeNum {

	public static void main(String[] args) {
		int[] ar = {-8, 2, 3, -6, 10};
		int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
		int k1 = 2;
		int k2 = 3;

		findFirstNegativeNumINEveryWindow(ar, k1);
		findFirstNegativeNumINEveryWindow(arr, k2);
	}

	private static void findFirstNegativeNumINEveryWindow(int[] ar, int k) {

		Queue<Integer> q = new LinkedList<>();

		int start = 0, end = 0, size = ar.length;
		List<Integer> answer = new ArrayList<>();

		// till end reaches last element
		while (end < size) {

			if (ar[end] < 0) {
				q.add(ar[end]);
			}

			if ((end - start + 1) < k) {
				end++;

			} else if ((end - start + 1) == k) {

				if (q.size() > 0) {
					int peek = q.peek();
					answer.add(peek);

					if (peek == ar[start]) {
						q.remove();
					}

				} else {
					answer.add(0);
				}
				start++;
				end++;
			}
		}

		System.out.println(answer);
	}
}
