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
                depthFirstSearch(adj, visit, node);
                result++;
            } 
        }
        return result;
    }

    private void depthFirstSearch(List<List<Integer>> adj, boolean[] visit, int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (visit[current]) {
                continue;
            }
            visit[current] = true;
            for (int nei : adj.get(current)) {
                if (!visit[nei]) {
                    stack.push(nei);
                }
            }
        }
    }
}
