/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        oldToNew.put(node, new Node(node.val));
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node item : current.neighbors) {
                if (!oldToNew.containsKey(item)) {
                    oldToNew.put(item, new Node(item.val));
                    queue.add(item);
                }
                oldToNew.get(current).neighbors.add(oldToNew.get(item));
            }
        }
        return oldToNew.get(node);
    }
}