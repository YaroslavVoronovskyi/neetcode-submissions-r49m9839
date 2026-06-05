class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            map.computeIfAbsent(time[0], 
            x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for (int index = 1; index <= n; index++) {
            dist.put(index, Integer.MAX_VALUE);
        }

        depthFirstSearch(k, 0, map, dist);
        int result = Collections.max(dist.values());
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void depthFirstSearch(int node, int time, Map<Integer, 
                                  List<int[]>> map, Map<Integer, Integer> dist) {
        if (time >= dist.get(node)) {
            return;
        }
        dist.put(node, time);
        if (!map.containsKey(node)) {
            return;
        }
        for (int[] edge : map.get(node)) {
            depthFirstSearch(edge[0], time + edge[1], map, dist);
        }
    }
}
