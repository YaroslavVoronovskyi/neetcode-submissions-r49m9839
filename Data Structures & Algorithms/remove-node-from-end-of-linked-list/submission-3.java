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
        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }

        int removeIndex = list.size() - number;
        if (removeIndex == 0) {
            return head.next;
        }
        list.get(removeIndex - 1).next = list.get(removeIndex).next;
        return head;
    }
}
