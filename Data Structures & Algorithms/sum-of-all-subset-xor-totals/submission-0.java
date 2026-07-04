class Solution {

    int result = 0;

    public int subsetXORSum(int[] numbers) {
        backtrack(0, numbers, new ArrayList<>());
        return result;
    }

    private void backtrack(int i, int[] numbers, List<Integer> subset) {
        int xorr = 0;
        for (int number : subset) {
            xorr ^= number;
        }
        result += xorr;
        for (int j = i; j < numbers.length; j++) {
            subset.add(numbers[j]);
            backtrack(j + 1, numbers, subset);
            subset.remove(subset.size() - 1);
        }
    }
}