class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visit = new HashSet<>();
        if (!depthFirstSearch(0, -1, visit, list)) {
            return false;
        }
        return visit.size() == n;
    }

    private boolean depthFirstSearch(int node, int parent, Set<Integer> visit, List<List<Integer>> list) {
        if (visit.contains(node)) {
            return false;
        }
        visit.add(node);
        for (int item : list.get(node)) {
            if (item == parent) {
                continue;
            }
            if (!depthFirstSearch(item, node, visit, list)) {
                return false;
            }
        }
        return true;
    }
}
