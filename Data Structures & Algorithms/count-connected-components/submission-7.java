class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int index = 0; index < n; index++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        int result = 0;

        for (int node  = 0; node < n; node++) {
            if(!visited[node]) {
                depthFirstSearch(adjacencyList, visited, node);
                result++;
            }
        }
        return result;
    }

    private void depthFirstSearch(List<List<Integer>> adjacencyList, boolean[] visited, int node) {
        visited[node] = true;
        for (int item : adjacencyList.get(node)) {
            if (!visited[item]) {
                depthFirstSearch(adjacencyList, visited, item);
            }
        }
    }
}
