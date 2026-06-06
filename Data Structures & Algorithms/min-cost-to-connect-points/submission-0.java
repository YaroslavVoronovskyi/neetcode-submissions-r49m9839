class Solution {
    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < size; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                map.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                map.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }
        int result = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, 0});
        while (visit.size() < size) {
            int[] current = queue.poll();
            int cost = current[0];
            int i = current[1];
            if (visit.contains(i)) {
                continue;
            }
            result += cost;
            visit.add(i);
            for (int[] item : map.getOrDefault(i, Collections.emptyList())) {
                int itemCost = item[0];
                int itemIndex = item[1];
                if (!visit.contains(itemIndex)) {
                    queue.offer(new int[]{itemCost, itemIndex});
                }
            }
        }
        return result;
    }
}
