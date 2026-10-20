class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] numbers) {
        Arrays.sort(numbers);
        backtrack(0, new ArrayList<>(), numbers);
        return result;
    }

    private void backtrack(int index, List<Integer> subset, int[] numbers) {
        if (index == numbers.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(numbers[index]);
        backtrack(index + 1, subset, numbers);
        subset.remove(subset.size() - 1);

        while (index + 1 < numbers.length && numbers[index] == numbers[index + 1]) {
            index++;
        }
        backtrack(index + 1, subset, numbers);
    }
}
