class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for (int index = 0; index < n; index++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        int result = 0;
        for (int node = 0; node < n; node++) {
            if (!visit[node]) {
                breadthFirstSearch(list, visit, node);
                result++;
            }
        }
        return result;
    }

    private void breadthFirstSearch(List<List<Integer>> list, boolean[] visit, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visit[node] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int item : list.get(current)) {
                if (!visit[item]) {
                    visit[item] = true;
                    queue.offer(item);
                }
            }
        }
    }
}
