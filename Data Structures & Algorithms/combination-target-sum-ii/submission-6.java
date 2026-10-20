class Solution {
    private List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<>(), 0, candidates, target);
        return result;
    }

    private void backtrack(int index, List<Integer> path, int current, int[] candidates, int target) {
        if (current == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (current + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backtrack(i + 1, path, current + candidates[i], candidates, target);
            path.remove(path.size() - 1);
        }
    }
}
