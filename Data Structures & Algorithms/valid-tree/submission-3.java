class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) {
            return true;
        }
        if (edges.length > n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        if (!depthFirstSearch(0, -1, visit, adj)) {
            return false;
        }
        return visit.size() == n;
    }

    private boolean depthFirstSearch(int node, int parent, Set<Integer> visit, List<List<Integer>> adj) {
        if (visit.contains(node)) {
            return false;
        }
        visit.add(node);
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (!depthFirstSearch(nei, node, visit, adj)) {
                return false;
            }
        }
        return true;
    }
 }
