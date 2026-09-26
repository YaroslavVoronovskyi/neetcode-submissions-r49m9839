class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        int[] indegree = new int[size + 1];
        List<List<Integer>> adj = new ArrayList<>(size + 1);
        for (int index = 0; index <= size; index++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int index = 1; index <= size; index++) {
            if(indegree[index] == 1) {
                queue.offer(index);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            indegree[node]--;
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 1) {
                    queue.offer(nei);
                }
            }
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (indegree[u] == 2 && indegree[v] > 0) {
                return new int[]{u, v};
            }
        }
        return new int[0];
    }
}
