class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] numbers) {
        result = new ArrayList<>();
        backtrack(numbers, 0);
        return result;
    }

    private void backtrack(int[] numbers, int idx) {
        if (idx == numbers.length) {
            List<Integer> permutations = new ArrayList<>();
            for (int number : numbers) {
                permutations.add(number);
            }
            result.add(permutations);
            return;
        }
        for (int index = idx; index < numbers.length; index++) {
            swap(numbers, idx, index);
            backtrack(numbers, idx + 1);
            swap(numbers, idx, index);
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
