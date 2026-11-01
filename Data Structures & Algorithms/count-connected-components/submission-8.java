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
                bredthFirstSearch(adjacencyList, visited, node);
                result++;
            }
        }
        return result;
    }

    private void bredthFirstSearch(List<List<Integer>> adjacencyList, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int item : adjacencyList.get(current)) {
                if(!visited[item]) {
                    visited[item] = true;
                    queue.offer(item);
                }
            }
        }
    }
}
