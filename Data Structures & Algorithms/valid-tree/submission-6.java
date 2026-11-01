class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1});
        visited.add(0);


        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];
            for (int item : adjacencyList.get(node)) {
                if (item == parent) {
                    continue;
                }
                if (visited.contains(item)) {
                    return false;
                }
                visited.add(item);
                queue.offer(new int[]{item, node});
            }
        }
        return visited.size() == n;
    }
 }
