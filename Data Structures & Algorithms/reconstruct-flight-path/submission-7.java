class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> adjacency = new HashMap<>();
        for (List<String> ticket : tickets) {
            adjacency.computeIfAbsent(ticket.get(0), 
            key -> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String current = stack.peek();
            if (!adjacency.containsKey(current) || adjacency.get(current).isEmpty()) {
                result.addFirst(stack.pop());
            } else {
                stack.push(adjacency.get(current).poll());
            }
        }
        return result;
    }
}
