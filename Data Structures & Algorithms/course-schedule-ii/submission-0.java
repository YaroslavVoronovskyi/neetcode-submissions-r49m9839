class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : prerequisites) {
            map.computeIfAbsent(pair[0], key -> new ArrayList<>()).add(pair[1]);
        }
        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        for (int course = 0; course < numCourses; course++) {
            if (!depthFirstSearch(course, map, visit, cycle, output)) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for (int index = 0; index < numCourses; index++) {
            result[index] = output.get(index);
        }
        return result;
    }

    private boolean depthFirstSearch(int course, Map<Integer, List<Integer>> map, 
                                     Set<Integer> visit, Set<Integer> cycle, List<Integer> output) {
        if (cycle.contains(course)) {
            return false;
        }
        if (visit.contains(course)) {
            return true;
        }
        cycle.add(course);
        for (int item : map.getOrDefault(course, Collections.emptyList())) {
            if (!depthFirstSearch(item, map, visit, cycle, output)) {
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }
}
