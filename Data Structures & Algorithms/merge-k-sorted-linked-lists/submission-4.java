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
    
        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for (int index = 0; index < lists.length; index += 2) {
                ListNode l1 = lists[index];
                ListNode l2 = (index + 1) < lists.length ? lists[index + 1] : null;
                mergedLists.add(mergedList(l1, l2));
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode mergedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return dummy.next;
    }
}
