class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int index = 0; index < numCourses; index++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);        
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < numCourses; index++) {
            if (indegree[index] == 0) {
                queue.add(index);
            }
        }

        int finish = 0;
        int[] output = new int[numCourses];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            output[numCourses - finish - 1] = node;
            finish++;
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        if (finish != numCourses) {
            return new int[0];
        }
        return output;
    }
}
