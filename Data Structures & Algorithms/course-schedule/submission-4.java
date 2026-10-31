class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int index = 0; index < numCourses; index++) {
            map.put(index, new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            map.get(item[0]).add(item[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if(!depthFirstSearch(course)) {
                return false;
            }
        }
        return true;
    }

    private boolean depthFirstSearch(int course) {
        if (visited.contains(course)) {
            return false;
        }
        if (map.get(course).isEmpty()) {
            return true;
        }
        visited.add(course);
        for (int item : map.get(course)) {
            if (!depthFirstSearch(item)) {
                return false;
            }
        }
        visited.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}
