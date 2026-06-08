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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int left, int right) {
         if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int middle = left + (right - left) / 2;
        ListNode leftNode = divide(lists, left, middle);
        ListNode rightNode = divide(lists, middle + 1, right);
        return conquer(leftNode, rightNode);
    }

    private ListNode conquer(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        return dummy.next;
    }
}
