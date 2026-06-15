class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            map.computeIfAbsent(src, key -> new PriorityQueue()).offer(dst);
        }
        List<String> result = new ArrayList<>();
        depthFirstSearch(map, "JFK", result);
        Collections.reverse(result);
        return result;
    }

    private void depthFirstSearch(Map<String, PriorityQueue<String>> map, String src, List<String> result) {
        PriorityQueue<String> queue = map.get(src);
        while (queue != null && !queue.isEmpty()) {
            String dst = queue.poll();
            depthFirstSearch(map, dst,result);
        }
        result.add(src);
    }
}
