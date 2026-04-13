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
        head = reorder(head, head.next);
    }

    private ListNode reorder(ListNode root, ListNode current) {
        if (current == null) {
            return root;
        }
        root = reorder(root, current.next);
        if (root == null) {
            return null;
        }

        ListNode temporary = null;
        if (root == current || root.next == current) {
            current.next = null;
        } else {
            temporary = root.next;
            root.next = current;
            current.next = temporary;
        }
        return temporary;
    }
}
