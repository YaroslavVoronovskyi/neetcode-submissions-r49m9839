class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        depthFirstSearch(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }

    private void depthFirstSearch(int[] candidates, int target, int index, List<Integer> current, int total) {
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (total > target || index == candidates.length) {
            return;
        }
        current.add(candidates[index]);
        depthFirstSearch(candidates, target, index + 1, current, total + candidates[index]);
        current.remove(current.size() - 1);
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        depthFirstSearch(candidates, target, index + 1, current, total);
    }
}
