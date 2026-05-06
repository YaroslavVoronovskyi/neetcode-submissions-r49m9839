class Solution {
    private List<List<Integer>> result = new ArrayList<>();
 
    public List<List<Integer>> combinationSum2(int[] numbers, int target) {
        result.clear();
        Arrays.sort(numbers);
        depthFirstSearch(0, new ArrayList<>(), 0, numbers, target);
        return result;
    }

    private void depthFirstSearch(int index, List<Integer> path, int current, int[] numbers, int target) {
        if (current == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < numbers.length; i++) {
            if (i > index && numbers[i] == numbers[i - 1]) {
                continue;
            }
            if (current + numbers[i] > target) {
                break;
            }
        path.add(numbers[i]);
        depthFirstSearch(i + 1, path, current + numbers[i], numbers, target);
        path.remove(path.size() - 1);
        }
    }
}
