package codingPatterns.fastSlowPointers;

/**
 * Given the head of a linked list, your task is to check whether the linked list is a palindrome
 * or not. Return TRUE if the linked list is a palindrome; otherwise, return FALSE.
 */
public class PalindromeLinkedList2 {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revert = reverse(slow);

        boolean check = compareTwoHalves(head, revert);

        //may Re-reverse the second half of the linked list to restore the
        // original linked list just before returning
        reverse(revert);

        return check;

    }

    public static ListNode reverse(ListNode head) {
        ListNode next, prev = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static boolean compareTwoHalves(ListNode firstHalf, ListNode secondHalf) {
        // Compare the corresponding nodes of the first and second halves of the linked list
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            } else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }
        }
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(1);

        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        System.out.println("Check palindrome: " + isPalindrome(head));
    }

}
