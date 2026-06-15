class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.getFirst(), key -> new PriorityQueue()).add(ticket.getLast());
        }
        List<String> result = new LinkedList<>();
        Stack<String> stack = new Stack();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            String current = stack.peek();
            if (!map.containsKey(current) || map.get(current).isEmpty()) {
                result.addFirst(stack.pop());
            } else {
                stack.push(map.get(current).poll());
            }
        }
        return result;
    }
}
