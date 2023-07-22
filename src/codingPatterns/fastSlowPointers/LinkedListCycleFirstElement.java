package codingPatterns.fastSlowPointers;

public class LinkedListCycleFirstElement {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("Cycle starts at: " + new LinkedListCycleFirstElement().detectCycle(head).val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int cycleLength = 0;
        boolean isCyclePresent = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                isCyclePresent = true;
                cycleLength = findCycleLength(slow);
                break;
            }
        }
        if (isCyclePresent)
            return findStart(head, cycleLength);
        return null;
    }

    private int findCycleLength(ListNode head) {
        ListNode curr = head;
        int len = 0;
        do {
            ++len;
            curr = curr.next;
        } while (curr != head);

        return len;
    }

    private ListNode findStart(ListNode head, int cycleLength) {
        ListNode a = head;
        ListNode b = head;

        while (cycleLength > 0) {
            a = a.next;
            --cycleLength;
        }

        while (b != a) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}