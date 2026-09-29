class Solution {

    private Set<Integer> visit;
    private Set<Integer> path;
    private List<Integer> order;

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topoSort(k, rowConditions);
        if (rowOrder == null) {
            return new int[0][0];
        }
        int[] colOrder = topoSort(k, colConditions);
        if (colOrder == null) {
            return new int[0][0];
        }

        Map<Integer, Integer> valToRow = new HashMap<>();
        for (int index = 0; index < rowOrder.length; index++) {
            valToRow.put(rowOrder[index], index);
        }

        Map<Integer, Integer> valToCol = new HashMap<>();
        for (int index = 0; index < colOrder.length; index++) {
            valToCol.put(colOrder[index], index);
        }

        int[][] result = new int[k][k];
        for (int number = 1; number <= k; number++) {
            int row = valToRow.get(number);
            int col = valToCol.get(number);
            result[row][col] = number;
        }
        return result;
    }

    private int[] topoSort(int k, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int index = 1; index <= k; index++) {
            adj.put(index, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        visit = new HashSet<>();
        path = new HashSet<>();
        order = new ArrayList<>();

        for (int index = 1; index <= k; index++) {
            if (!visit.contains(index)) {
                if (!depthFirstSearch(index, adj)) {
                    return null;
                }
            }
        }

        Collections.reverse(order);
        return order.stream().mapToInt(index -> index).toArray();
    }

    private boolean depthFirstSearch(int src, Map<Integer, List<Integer>> adj) {
        if (path.contains(src)) {
            return false;
        }
        if (visit.contains(src)) {
            return true;
        }
        visit.add(src);
        path.add(src);
        for (int nei : adj.get(src)) {
            if (!depthFirstSearch(nei, adj)) {
                return false;
            }
        }
        path.remove(src);
        order.add(src);
        return true;
    }
}