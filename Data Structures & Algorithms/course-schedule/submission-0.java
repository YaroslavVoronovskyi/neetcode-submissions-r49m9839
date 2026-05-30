class Solution {

    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> set = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int index = 0; index < numCourses; index++) {
            map.put(index, new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            map.get(item[0]).add(item[1]);
        }
        for (int index = 0; index < numCourses; index++) {
            if(!depthFirstSearch(index)) {
                return false;
            }
        }
        return true;
    }

    private boolean depthFirstSearch(int index) {
        if (set.contains(index)) {
            return false;
        }
        if (map.get(index).isEmpty()) {
            return true;
        }
        set.add(index);
        for (int item : map.get(index)) {
            if (!depthFirstSearch(item)) {
                return false;
            }
        }
        set.remove(index);
        map.put(index, new ArrayList<>());
        return true;
    }
}
