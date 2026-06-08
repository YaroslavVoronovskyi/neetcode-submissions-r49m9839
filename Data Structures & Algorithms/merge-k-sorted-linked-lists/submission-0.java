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
        List<Integer> nodes = new ArrayList<>();
        for (ListNode item : lists) {
            while (item != null) {
                nodes.add(item.val);
                item = item.next;
            }
        }
        Collections.sort(nodes);
        ListNode result = new ListNode(0);
        ListNode current = result;
        for (int node : nodes) {
            current.next = new ListNode(node);
            current = current.next;
        }
        return result.next;
    }
}
