package codingPatterns.fastSlowPointers;

/**
 * In a linked list of even length  n, the node at position  i (0-based indexing) is considered the twin
 * of the node at position (n−1−i) for all 0≤i<n/2. Eg. For, n=4  node 0 and node 3  are twins, and node
 * 1 and node 2 are twins. These pairs are the only twins in a linked list of size 4
 * The twin sum is defined as the sum of a node’s value and its twin’s value.
 * Given the head of a linked list with an even number of nodes, return the maximum twin sum of the linked list.
 */

public class MaximumTwinSumLinkedList {
    public static int twinSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode reverse;
        int max = 0, sum;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        reverse = reverseList(slow);
        //System.out.println(reverse.data);

        while (reverse != null) {
            sum = reverse.val + head.val;
            max = Math.max(sum, max);
            reverse = reverse.next;
            head = head.next;
        }
        // Replace this placeholder return statement with your code
        return max;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(12);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(10);
        System.out.println("Max sum: " + twinSum(head));
    }

}
