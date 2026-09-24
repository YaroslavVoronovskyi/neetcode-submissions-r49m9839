class Solution {

    private List<Integer> output = new ArrayList<>();
    private int[] indegree;
    private List<List<Integer>> adj;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        for (int index = 0; index < numCourses; index++) {
            adj.add(new ArrayList<>());
        }

        indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);        
        }

        for (int index = 0; index < numCourses; index++) {
            if (indegree[index] == 0) {
                depthFirstSearch(index);
            }
        }

        if (output.size() != numCourses) {
            return new int[0];
        }
        int[] result = new int[output.size()];
        for (int index = 0; index < output.size(); index++) {
            result[index] = output.get(index);
        }
        return result;
    }

    private void depthFirstSearch(int node) {
        output.add(node);
        indegree[node]--;
        for (int nei : adj.get(node)) {
            indegree[nei]--;
            if (indegree[nei] == 0) {
                depthFirstSearch(nei);
            }
        }
    }
}
