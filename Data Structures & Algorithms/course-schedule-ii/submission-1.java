class Solution {

    private List<Integer> output = new ArrayList<>();
    private int[] indegree;
    private List<List<Integer>> list;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        list = new ArrayList<>();
        for (int index = 0; index < numCourses; index++) {
            list.add(new ArrayList<>());
        }
        indegree = new int[numCourses];
        for (int[] item : prerequisites) {
            indegree[item[0]]++;
            list.get(item[1]).add(item[0]);
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
        for (int item : list.get(node)) {
            indegree[item]--;
            if (indegree[item] == 0) {
                depthFirstSearch(item);
            }
        }
    }
}
