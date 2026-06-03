class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int index = 0; index <= size; index++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int col = edge[0];
            int row = edge[1];
            list.get(col).add(row);
            list.get(row).add(col);
            boolean[] visit = new boolean[size + 1];
            if (depthFirstSearch(col, -1, list, visit)) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean depthFirstSearch(int node, int parent, List<List<Integer>> list, boolean[] visit) {
        if (visit[node]) {
            return true;
        }
        visit[node] = true;
        for (int item : list.get(node)) {
            if (item == parent) {
                continue;
            }
            if (depthFirstSearch(item, node, list, visit)) {
                return true;
            }
        }
        return false;
    }
}
