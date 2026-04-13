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
    public ListNode recursion(ListNode head, int[] numbers) {
        if (head == null) {
            return null;
        }
        head.next = recursion(head.next, numbers);
        numbers[0]--;
        if (numbers[0] == 0) {
            return head.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int number) {
        return recursion(head, new int[]{number});
    }
}
