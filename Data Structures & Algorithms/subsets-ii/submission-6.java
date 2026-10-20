class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] numbers) {
        Arrays.sort(numbers);
        backtrack(0, new ArrayList<>(), numbers);
        return result;
    }

    private void backtrack(int index, List<Integer> subset, int[] numbers) {
        result.add(new ArrayList<>(subset));
        for (int j = index; j < numbers.length; j++) {
            if (j > index && numbers[j] == numbers[j - 1]) {
                continue;
            }
            subset.add(numbers[j]);
            backtrack(j + 1, subset, numbers);
            subset.remove(subset.size() - 1);
        }
    }
}
