class Solution {
    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        Map<Integer, List<int[]>> adjacency = new HashMap<>();
        for (int outer = 0; outer < size; outer++) {
            int x1 = points[outer][0];
            int y1 = points[outer][1];
            for (int inner = outer + 1; inner < size; inner++) {
                int x2 = points[inner][0];
                int y2 = points[inner][1];
                int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adjacency.computeIfAbsent(outer, key -> new ArrayList<>()).add(new int[]{distance, inner});
                adjacency.computeIfAbsent(inner, key -> new ArrayList<>()).add(new int[]{distance, outer});
            }
        }

        int result = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, 0});
        while (visited.size() < size) {
            int[] current = minHeap.poll();
            int cost = current[0];
            int index = current[1];
            if (visited.contains(index)) {
                continue;
            }
            result += cost;
            visited.add(index);
            for (int[] neighbor : adjacency.getOrDefault(index, List.of())) {
                int neighborCost = neighbor[0];
                int neighborIndex = neighbor[1];
                if (!visited.contains(neighborIndex)) {
                    minHeap.offer(new int[]{neighborCost, neighborIndex});
                }
            } 
        }
        return result;
    }
}
