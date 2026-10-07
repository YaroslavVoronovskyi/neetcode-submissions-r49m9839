/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrevious = dummy;

        while (true) {
            ListNode kth = getKth(groupPrevious, k);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;

            ListNode previous = kth.next;
            ListNode current = groupPrevious.next;
            while (current != groupNext) {
                ListNode temp = current.next;
                current.next = previous;
                previous = current;
                current = temp;
            }

            ListNode temp = groupPrevious.next;
            groupPrevious.next = kth;
            groupPrevious = temp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode current, int k) {
        while (current != null && k > 0) {
            current = current.next;
            k--;
        } 
        return current;
    }
}
