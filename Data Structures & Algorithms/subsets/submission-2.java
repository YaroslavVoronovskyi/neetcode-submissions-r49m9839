class Solution {
    public List<List<Integer>> subsets(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        int size = numbers.length;
        for (int index = 0; index < (1 << size); index++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if ((index & (1 << j)) != 0) {
                    subset.add(numbers[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
