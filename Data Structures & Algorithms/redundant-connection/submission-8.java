class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        List<List<Integer>> adjacencyList = new ArrayList<>(size + 1);
        int[] indegree = new int[size + 1];

        for (int index = 0; index <= size; index++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int node = edge[0];
            int parent = edge[1];
            adjacencyList.get(node).add(parent);
            adjacencyList.get(parent).add(node);
            indegree[node]++;
            indegree[parent]++;
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
            for (int item : adjacencyList.get(node)) {
                indegree[item]--;
                if (indegree[item] == 1) {
                    queue.offer(item);
                }
            }
        }
 
        for (int index = edges.length - 1; index >= 0; index--) {
            int node = edges[index][0];
            int parent = edges[index][1];
            if (indegree[node] == 2 && indegree[parent] > 0) {
                return new int[] {node, parent};
            }
        }
        return new int[0];
    }
}
