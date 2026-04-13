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
    public ListNode removeNthFromEnd(ListNode head, int number) {
        int n = 0;
        ListNode current = head;
        while (current != null) {
            n++;
            current = current.next;
        }
        int removeIndex = n - number;
        if (removeIndex == 0) {
            return head.next;
        }
        current = head;
        for (int index = 0; index < n - 1; index++) {
            if ((index + 1) == removeIndex) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
        return head;
    }
}
