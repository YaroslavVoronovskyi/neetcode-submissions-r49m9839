class Solution {

    private Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] numbers) {
        Arrays.sort(numbers);
        backtrack(numbers, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private void backtrack(int[] numbers, int index, List<Integer> subset) {
        if (index == numbers.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(numbers[index]);
        backtrack(numbers, index + 1, subset);
        subset.remove(subset.size() - 1);
        while (index + 1 < numbers.length && numbers[index] == numbers[index + 1]) {
            index++;
        }
        backtrack(numbers, index + 1, subset);
    }
}
