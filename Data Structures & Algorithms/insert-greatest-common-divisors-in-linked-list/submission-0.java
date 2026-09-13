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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current.next != null) {
            int firstNumber = current.val;
            int secondNumber = current.next.val;
            int gcdValue = gcd(firstNumber, secondNumber);
            ListNode newNode = new ListNode(gcdValue, current.next);
            current.next = newNode;
            current = newNode.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}