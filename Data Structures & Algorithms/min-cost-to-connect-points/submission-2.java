class Solution {
    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < size; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, key -> new ArrayList<>()).add(new int[]{dist, j});
                adj.computeIfAbsent(j, key -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        int result = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, 0});
        while (visit.size() < size) {
            int[] current = minHeap.poll();
            int cost = current[0];
            int index = current[1];
            if (visit.contains(index)) {
                continue;
            }
            result += cost;
            visit.add(index);
            for (int[] nei : adj.getOrDefault(index, List.of())) {
                int neiCost = nei[0];
                int neiIndex = nei[1];
                if (!visit.contains(neiIndex)) {
                    minHeap.offer(new int[]{neiCost, neiIndex});
                }
            }
        }
        return result;
    }
}
