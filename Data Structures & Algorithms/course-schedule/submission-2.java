class Solution {

    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int index = 0; index < numCourses; index++) {
            preMap.put(index, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }
        for (int course = 0; course < numCourses; course++) {
            if (!depthFirstSearch(course)) {
                return false;
            }
        }
        return true;
    }

    private boolean depthFirstSearch(int course) {
        if (visiting.contains(course)) {
            return false;
        }
        if (preMap.get(course).isEmpty()) {
            return true;
        }
        visiting.add(course);
        for (int pre : preMap.get(course)) {
            if (!depthFirstSearch(pre)) {
                return false;
            }
        }
        visiting.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}
