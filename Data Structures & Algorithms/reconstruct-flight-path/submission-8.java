class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> adjacency = new HashMap<>();
        for (List<String> ticket : tickets) {
            adjacency.computeIfAbsent(ticket.get(0), 
            key -> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> result = new LinkedList<>();
        depthFirstSearch(adjacency, "JFK", result);
        Collections.reverse(result);
        return result;
    }

    private void depthFirstSearch(Map<String, Queue<String>> adjacency, String source, List<String> result) {
        Queue<String> queue = adjacency.get(source);
        while (queue != null && !queue.isEmpty()) {
            String destination = queue.poll();
            depthFirstSearch(adjacency, destination, result);
        }
        result.add(source);
    }
}
