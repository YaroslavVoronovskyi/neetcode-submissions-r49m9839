class Solution {
    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        int node = 0;
        int[] distances = new int[size];
        boolean[] visited = new boolean[size];
        Arrays.fill(distances, 100000000);
        int edges = 0;
        int result = 0;
        
        while (edges < size - 1) {
            visited[node] = true;
            int nextNode = -1;
            for (int index = 0; index < size; index++) {
                if (visited[index]) {
                    continue;
                }
                int currentDistance = Math.abs(points[index][0] - points[node][0]) + 
                                      Math.abs(points[index][1] - points[node][1]);
                distances[index] = Math.min(distances[index], currentDistance);
                if (nextNode == -1 || distances[index] < distances[nextNode]) {
                    nextNode = index;
                }
            }
            result += distances[nextNode];
            node = nextNode;
            edges++;
        }
        return result;
    }
}
