class Solution {
        private List<List<Integer>> adjacencyList;
        private boolean[] visited;
        private Set<Integer> cycle;
        private int cycleStart;

    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        adjacencyList = new ArrayList<>();
        visited = new boolean[size + 1];
        cycle = new HashSet<>();
        cycleStart = -1;

        for (int index = 0; index <= size; index++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int node = edge[0];
            int parent = edge[1];
            adjacencyList.get(node).add(parent);
            adjacencyList.get(parent).add(node);
        }

        depthFirstSearch(1, -1);

        for (int index = edges.length - 1; index >= 0; index--) {
            int node = edges[index][0];
            int parent = edges[index][1];
            if (cycle.contains(node) && cycle.contains(parent)) {
                return new int[] {node, parent};
            }
        }
        return new int[0];
    }

    private boolean depthFirstSearch(int node, int parent) {
        if (visited[node]) {
            cycleStart = node;
            return true;
        }
        visited[node] = true;
        for (int item : adjacencyList.get(node)) {
            if (item == parent) {
                continue;
            }
            if (depthFirstSearch(item, node)) {
                if (cycleStart != -1) {
                    cycle.add(node);
                }
                if (node == cycleStart) {
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;
    }
}
