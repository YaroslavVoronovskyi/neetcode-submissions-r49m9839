class Solution {
    public List<List<Integer>> subsets(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        depthFirstSearch(numbers, 0, subset, result);
        return result;

    }

    private void depthFirstSearch(int[] numbers, int index, List<Integer> subset, List<List<Integer>> result) {
        if (index >= numbers.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(numbers[index]);
        depthFirstSearch(numbers, index + 1, subset, result);
        subset.remove(subset.size() - 1);
        depthFirstSearch(numbers, index + 1, subset, result);
    }
}
