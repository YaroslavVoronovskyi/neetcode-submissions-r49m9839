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
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1});
        visit.add(0);

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];
            for (int item : list.get(node)) {
                if (item == parent) {
                    continue;
                }
                if (visit.contains(item)) {
                    return false;
                }
                visit.add(item);
                queue.offer(new int[]{item, node});
            }
        }
        return visit.size() == n;
    }
}
