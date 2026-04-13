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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        ListNode previous = slow.next = null;
        while (second != null) {
            ListNode temporary = second.next;
            second.next = previous;
            previous = second;
            second = temporary;
        }
        ListNode first = head;
        second = previous;
        while (second != null) {
            ListNode temporaryFirst = first.next;
            ListNode temporarySecond = second.next;
            first.next = second;
            second.next = temporaryFirst;
            first = temporaryFirst;
            second = temporarySecond;
        }
    }
}
