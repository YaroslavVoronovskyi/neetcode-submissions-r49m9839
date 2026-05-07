class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] numbers) {
        Arrays.sort(numbers);
        backtrack(numbers, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] numbers, int index, List<Integer> subset) {
        if (index == numbers.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        result.add(new ArrayList<>(subset));
        for (int j = index; j < numbers.length; j++) {
            if (j > index && numbers[j] == numbers[j - 1]) {
                continue;
            }
            subset.add(numbers[j]);
            backtrack(numbers, j + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
