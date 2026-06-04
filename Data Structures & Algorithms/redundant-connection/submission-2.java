class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        int[] indegree = new int[size + 1];
        List<List<Integer>> list = new ArrayList<>();
        for (int index = 0; index <= size; index++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int col = edge[0];
            int row = edge[1];
            list.get(col).add(row);
            list.get(row).add(col);
            indegree[col]++;
            indegree[row]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int index = 1; index <= size; index++) {
            if (indegree[index] == 1) {
                queue.offer(index);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            indegree[node]--;
            for (int index : list.get(node)) {
                indegree[index]--;
                if (indegree[index] == 1) {
                    queue.offer(index);
                }
            }
        }
        for (int index = size - 1; index >= 0; index--) {
            int col = edges[index][0];
            int row = edges[index][1];
            if (indegree[col] == 2 && indegree[row] > 0) {
                return new int[]{col, row};
            }
        }
        return new int[0];
    }
}
