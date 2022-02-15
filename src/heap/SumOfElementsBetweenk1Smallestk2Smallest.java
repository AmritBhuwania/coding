package heap;

import java.util.PriorityQueue;

/**
 * @author amrit
 * Link: https://youtu.be/3ioQQQrnw4Q
 * Given an array of integers and two numbers k1 and k2. Find the sum of all elements
 * between given two k1’th and k2’th smallest elements of the array. 
 * It may be assumed that all elements of array are distinct.

Example :
Input : arr[] = {20, 8, 22, 4, 12, 10, 14},  k1 = 3,  k2 = 6  
Output : 26          
         3rd smallest element is 10. 6th smallest element 
         is 20. Sum of all element between k1 & k2 is
         12 + 14 = 26
 */

public class SumOfElementsBetweenk1Smallestk2Smallest {

	public static void main(String[] args) {

		int k1 = 1;
		int k2 = 5;
		int[] ar = {2,4,1,3,5};

		int first = findKthSmallestElement(ar, k1);
		int second = findKthSmallestElement(ar, k2);

		int sum = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] > first && ar[i] < second) {
				sum += ar[i];
			}
		}
		System.out.println(sum);
	}

	static int findKthSmallestElement(int[] ar, int k) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

		for (int i = 0; i < ar.length; i++) {
			maxHeap.add(ar[i]);
			if (maxHeap.size() > k)
				maxHeap.poll();
		}

		return maxHeap.poll();
	}
}

