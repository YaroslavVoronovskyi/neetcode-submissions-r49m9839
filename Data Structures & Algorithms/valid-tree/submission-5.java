class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (!depthFirstSearch(0, -1, visited, adjacencyList)) {
            return false;
        }
        return visited.size() == n;
    }

    private boolean depthFirstSearch(int node, int parent, Set<Integer> visited, List<List<Integer>> adjacencyList) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for (int item : adjacencyList.get(node)) {
            if (item == parent) {
                continue;
            }
            if (!depthFirstSearch(item, node, visited, adjacencyList)) {
                return false;
            }
        }
        return true;
    }
 }
