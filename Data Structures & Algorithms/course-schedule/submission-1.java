class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        for (int index = 0; index < numCourses; index++) {
            list.add(new ArrayList<>());
        }        
        for (int[] item : prerequisites) {
            indegree[item[1]]++;
            list.get(item[0]).add(item[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < numCourses; index++) {
            if(indegree[index] == 0) {
                queue.add(index);
            }
        }
        int finish = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            finish++;
            for (int item : list.get(node)) {
                indegree[item]--;
                if (indegree[item] == 0) {
                    queue.add(item);
                }
            }
        }
        return finish == numCourses;
    }
}
