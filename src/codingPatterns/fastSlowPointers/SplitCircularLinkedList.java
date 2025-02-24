package codingPatterns.fastSlowPointers;

/**
 * Given a circular linked list, list, of positive integers, your task is to split it into two circular linked lists.
 * The first circular linked list should contain the first half of the nodes (exactly ⌈list.length / 2⌉ nodes),
 * in the same order they appeared in the original list, while the second circular linked list should include
 * the remaining nodes in the same order.
 *
 * Return an array, answer, of length 2, where:
 * answer[0] is the circular linked list representing the first half.
 * answer[1] is the circular linked list representing the second half.
 */
public class SplitCircularLinkedList {

    public static ListNode[] splitCircularLinkedList(ListNode head) {
        // Initialize slow and fast pointers to the head of the list
        ListNode slow = head;
        ListNode fast = head;

        // Move slow by one step and fast by two steps to find the middle of the list
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
        }

        // Set head1 to the start of the first half
        ListNode head1 = head;
        // Set head2 to the start of the second half, which is the node after slow
        ListNode head2 = slow.next;
        // Make the first half circular by pointing slow's next to head1
        slow.next = head1;

        // Reuse the fast pointer to find the end of the second half
        fast = head2;
        while (fast.next != head) {
            fast = fast.next; // Move to the end of the second half
        }
        // Make the second half circular by linking the last node to head2
        fast.next = head2;

        // Return the heads of the two split circular linked lists
        return new ListNode[]{head1, head2};
    }

    // Driver code
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head;
        ListNode[] splitLists = splitCircularLinkedList(head);
        System.out.println("1st linked list: ");
        print(splitLists[0]);
        System.out.println("\n2nd linked list: ");
        print(splitLists[1]);
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        while (true) {
            System.out.print(head.val + ", ");
            head = head.next;
            if (head == temp) {
                break;
            }
        }
    }
}
