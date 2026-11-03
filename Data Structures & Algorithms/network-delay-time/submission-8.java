class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            map.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        Map<Integer, Integer> distance = new HashMap<>();
        for (int index = 1; index <= n; index++) {
            distance.put(index, Integer.MAX_VALUE);
        }

        depthFirstSearch(k, 0, map, distance);
        int result = Collections.max(distance.values());
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public void depthFirstSearch(int node, int time, Map<Integer, List<int[]>> map, Map<Integer, Integer> distance) {
        if (time >= distance.get(node)) {
            return;
        }
        distance.put(node, time);
        if (!map.containsKey(node)) {
            return;
        }
        for (int[] edge : map.get(node)) {
            depthFirstSearch(edge[0], time + edge[1], map, distance);
        }
    }
}
