class Solution {

    private List<int[]>[] adj;

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        for(int index = 0; index < edges.length; index++) {
            edges[index] = Arrays.copyOf(edges[index], edges[index].length + 1);
            edges[index][3] = index;
        }
        
        adj = new ArrayList[n];
        for (int index = 0; index < n; index++) {
            adj[index] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2], edge[3]});
            adj[edge[1]].add(new int[]{edge[0], edge[2], edge[3]});
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int idx = edge[3];
            if (w < minimax(n, u, v, idx)) {
                critical.add(idx);
            } else if (w == minimax(n, u, v, -1)) {
                pseudo.add(idx);
            }
        }
        return Arrays.asList(critical, pseudo);
    }

    public int minimax(int n, int src, int dst, int excludeIdx) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, src});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int maxW = current[0];
            int u = current[1];
            if (u == dst) {
                return maxW;
            }

            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                int edgeIdx = neighbor[2];
                if (edgeIdx == excludeIdx) {
                    continue;
                }   
                int newW = Math.max(maxW, weight);
                if (newW < dist[v]) {
                    dist[v] = newW;
                    queue.offer(new int[]{newW, v});
                }         
            }
        }
        return Integer.MAX_VALUE;
    }
}