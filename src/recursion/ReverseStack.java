package recursion;

import java.util.Stack;

/**
 * Link: https://youtu.be/8YXQ68oHjAs?si=zAa5OK-UGDoeTjYH
 */
public class ReverseStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        reverseStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }

    private static void reverseStack(Stack<Integer> stack) {

        if (stack.size() == 1) {
            return;
        }

        int topEle = stack.pop();
        reverseStack(stack);
        insertElementInStack(stack, topEle);
    }

    private static void insertElementInStack(Stack<Integer> stack, int ele) {

        if (stack.isEmpty()) {
            stack.push(ele);
            return;
        }

        int temp = stack.pop();
        insertElementInStack(stack, ele);
        stack.push(temp);
    }
}
