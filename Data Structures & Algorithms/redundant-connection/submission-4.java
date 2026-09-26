class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int index = 0; index <= size; index++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            boolean[] visit = new boolean[size + 1];

            if (depthFirstSearch(u, -1, adj, visit)) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean depthFirstSearch(int node, int parent, List<List<Integer>> adj, boolean[] visit) {
        if (visit[node]) {
            return true;
        }

        visit[node] = true;
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (depthFirstSearch(nei, node, adj, visit)) {
                return true;
            }
        }
        return false;
    }
}
