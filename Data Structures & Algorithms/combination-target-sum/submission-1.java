class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] numbers, int target) {
        result = new ArrayList<>();
        Arrays.sort(numbers);
        depthFirstSearch(0, new ArrayList<>(), 0, numbers, target);
        return result;
    }

    private void depthFirstSearch(int index, List<Integer> current, int total, int[] numbers, int target) {
        if (total == target) {
            result.add( new ArrayList<>(current));
            return;
        }
        for (int j = index; j < numbers.length; j++) {
            if (total + numbers[j] > target) {
                return;
            }
        current.add(numbers[j]);
        depthFirstSearch(j, current, total + numbers[j], numbers, target);
        current.remove(current.size() - 1);
        }
    }
}
