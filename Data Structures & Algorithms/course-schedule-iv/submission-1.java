class Solution {

    private List<Integer>[] list;
    private Map<Integer, Set<Integer>> prereqMap;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        list = new ArrayList[numCourses];
        prereqMap = new HashMap<>();
        for (int index = 0; index < numCourses; index++) {
            list[index] = new ArrayList<>();
        } 
        for (int[] pre : prerequisites) {
            list[pre[1]].add(pre[0]);
        }
        for (int crs = 0; crs < numCourses; crs++) {
            depthFirstSearch(crs);
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(prereqMap.get(query[1]).contains(query[0]));
        }
        return result;
    }

    private Set<Integer> depthFirstSearch(int crs) {
        if(prereqMap.containsKey(crs)) {
            return prereqMap.get(crs);
        }
        Set<Integer> prereqs = new HashSet<>();
        for (int pre : list[crs]) {
            prereqs.addAll(depthFirstSearch(pre));
        }
        prereqs.add(crs);
        prereqMap.put(crs, prereqs);
        return prereqs;
    }
}