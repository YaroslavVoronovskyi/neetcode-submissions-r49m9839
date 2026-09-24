class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int index = 0; index < numCourses; index++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            indegree[prereq[1]]++;
            adj.get(prereq[0]).add(prereq[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.add(course);
            }
        }

        int finish = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            finish++;
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        return finish == numCourses;
    }
}
