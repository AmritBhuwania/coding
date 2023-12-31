package recursion;

import java.util.Stack;

/**
 * Link: https://youtu.be/oCcUNRMl7dA?si=Ndkmo1vth8h2NbPr
 * Delete middle element from a stack using recursion
 */
public class DeleteMiddleElementInStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        int k = (stack.size()/2) + 1;

        deleteMiddleElement(stack, k);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }

    }

    private static void deleteMiddleElement(Stack<Integer> stack, int k) {

        // delete the top element
        if (k == 1) {
            stack.pop();
            return;
        }

        // keep popping the elements until you reach the base condition
        int topEle = stack.pop();
        deleteMiddleElement(stack, k-1);

        // push back the top element
        stack.push(topEle);

    }
}
