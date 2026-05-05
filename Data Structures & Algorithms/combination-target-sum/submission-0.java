class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] numbers, int target) {
        result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(numbers, target, current, 0);
        return result;
    }

    private void backtrack(int[] numbers, int target, List<Integer> current, int index) {
        if (target == 0) {
            result.add( new ArrayList<>(current));
            return;
        }
        if (target < 0 || index >= numbers.length) {
            return;
        }
        current.add(numbers[index]);
        backtrack(numbers, target - numbers[index], current, index);
        current.remove(current.size() - 1);
        backtrack(numbers, target, current, index + 1);
    }
}
