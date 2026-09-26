class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];
        
        for (int index = 0; index < n; index++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int result = 0;
        for (int node = 0; node < n; node++) {
            if(!visit[node]) {
                breadthFirstSearch(adj, visit, node);
                result++;
            } 
        }
        return result;
    }

    private void breadthFirstSearch(List<List<Integer>> adj, boolean[] visit, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visit[node] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int nei : adj.get(current)) {
                if (!visit[nei]) {
                    visit[nei] = true;
                    queue.offer(nei);
                }
            }
        }
    }
}
