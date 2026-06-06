class Solution {
    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        int node = 0;
        int[] dist = new int[size];
        boolean[] visit = new boolean[size];
        Arrays.fill(dist, 100000000);
        int edges = 0;
        int result = 0;

        while (edges < size - 1) {
            visit[node] = true;
            int nextNode = -1;
            for (int index = 0; index < size; index++) {
                if (visit[index]) continue;
                int curDist = Math.abs(points[index][0] - points[node][0]) +
                              Math.abs(points[index][1] - points[node][1]);
                dist[index] = Math.min(dist[index], curDist);
                if (nextNode == -1 || dist[index] < dist[nextNode]) {
                    nextNode = index;
                }
            }
            result += dist[nextNode];
            node = nextNode;
            edges++;
        }
        return result;
    }
}
