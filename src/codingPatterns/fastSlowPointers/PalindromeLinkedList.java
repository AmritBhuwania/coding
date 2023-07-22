package codingPatterns.fastSlowPointers;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println("Check palindrome: " + new PalindromeLinkedList().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode first = head;
        int length = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            length++;
        }

        // fast is equal to null for even length.
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);

        while(length-- > 0) {
            if (slow.val != first.val) {
                return false;
            }
            slow = slow.next;
            first = first.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode next, prev = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}