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
            secondNode.next = firstNode.random;
            firstNode.random = secondNode;
            firstNode = firstNode.next;
        }

        Node newHead = head.random;
        firstNode = head;
        while (firstNode != null) {
            Node secondNode = firstNode.random;
            secondNode.random = (secondNode.next != null) ? secondNode.next.random : null;
            firstNode = firstNode.next;
        }

        firstNode = head;
        while (firstNode != null) {
            Node secondNode = firstNode.random;
            firstNode.random = secondNode.next;
            secondNode.next = (firstNode.next != null) ? firstNode.next.random : null;
            firstNode = firstNode.next;
        }
        return newHead;
    }
}
