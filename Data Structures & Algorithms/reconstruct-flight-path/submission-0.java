class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new ArrayList<>());
        }
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        for (List<String> ticket : tickets) {
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> result = new ArrayList<>();
        result.add("JFK");
        if ( depthFirstSearch("JFK", result, map, tickets.size() + 1)) {
            return result;
        }
        return new ArrayList<>();
    }

    private boolean depthFirstSearch(String src, List<String> result, Map<String, List<String>> map, int targetLen) {
        if (result.size() == targetLen) {
            return true;
        }
        if (!map.containsKey(src)) {
            return false;
        }
        List<String> temp = new ArrayList<>(map.get(src));
        for (int index = 0; index < temp.size(); index++) {
            String item = temp.get(index);
            map.get(src).remove(index);
            result.add(item);
            if (depthFirstSearch(item, result, map, targetLen)) {
                return true;
            }
            map.get(src).add(index, item);
            result.remove(result.size() - 1);
        }
        return false;
    }
}
