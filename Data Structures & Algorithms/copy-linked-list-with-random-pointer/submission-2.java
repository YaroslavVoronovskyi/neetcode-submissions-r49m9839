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
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        
        Node current = head;
        while (current != null) {
            if (!map.containsKey(current)) {
                map.put(current, new Node(0));
            }
            map.get(current).val = current.val;

            if (!map.containsKey(current.next)) {
                map.put(current.next, new Node(0));
            }
            map.get(current).next = map.get(current.next);

            if (!map.containsKey(current.random)) {
                map.put(current.random, new Node(0));
            }
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }
}
