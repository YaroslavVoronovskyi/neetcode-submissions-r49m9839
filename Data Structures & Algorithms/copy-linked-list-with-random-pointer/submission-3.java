/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node firstNode = head;
        while (firstNode != null) {
            Node secondNode = new Node(firstNode.val);
            secondNode.next = firstNode.next;
            firstNode.next = secondNode;
            firstNode = secondNode.next;
        }

        Node newHead = head.next;
        firstNode = head;
        while (firstNode != null) {
            if (firstNode.random != null) {
                firstNode.next.random = firstNode.random.next;
            }
            firstNode = firstNode.next.next;
        }

        firstNode = head;
        while (firstNode != null) {
            Node secondNode = firstNode.next;
            firstNode.next = secondNode.next;
            if (secondNode.next != null) {
                secondNode.next = secondNode.next.next;
            }
            firstNode = firstNode.next;
        }
        return newHead;
    }
}
