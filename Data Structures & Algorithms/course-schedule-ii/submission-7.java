class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int index = 0; index < numCourses; index++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] course : prerequisites) {
            indegree[course[1]]++;
            adjacencyList.get(course[0]).add(course[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < numCourses; index++) {
            if (indegree[index] == 0) {
                queue.add(index);
            }
        }

        int finish = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[numCourses - finish - 1] = node;
            finish++;
            for (int item : adjacencyList.get(node)) {
                indegree[item]--;
                if (indegree[item] == 0) {
                    queue.add(item);
                }
            }
        }
        if (finish != numCourses) {
            return new int[0];
        }
        return result;
    }
}
