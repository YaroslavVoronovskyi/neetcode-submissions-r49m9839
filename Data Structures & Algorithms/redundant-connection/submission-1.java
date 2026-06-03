class Solution {

    private boolean[] visit;
    private List<List<Integer>> list;
    private Set<Integer> cycle;
    private int cycleStart;

    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        list = new ArrayList<>();
        for (int index = 0; index <= size; index++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int col = edge[0];
            int row = edge[1];
            list.get(col).add(row);
            list.get(row).add(col);
        }
        visit = new boolean[size + 1];
        cycle = new HashSet<>();
        cycleStart = -1;
        depthFirstSearch(1, -1);

        for (int index = size - 1; index >= 0; index--) {
            int col = edges[index][0];
            int row = edges[index][1];
            if (cycle.contains(col) && cycle.contains(row)) {
                return new int[]{col, row};
            }
        }
        return new int[0];
    }

    private boolean depthFirstSearch(int node, int parent) {
        if (visit[node]) {
            cycleStart = node;
            return true;
        }
        visit[node] = true;
        for (int item : list.get(node)) {
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
