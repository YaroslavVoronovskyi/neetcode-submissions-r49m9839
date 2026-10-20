class Solution {
    public List<List<Integer>> subsets(int[] numbers) {
        int size = numbers.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < (1 << size); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(numbers[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
