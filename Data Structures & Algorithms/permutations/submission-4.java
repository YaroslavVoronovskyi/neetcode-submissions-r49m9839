class Solution {
    public List<List<Integer>> permute(int[] numbers) {
        if (numbers.length == 0) {
            return Arrays.asList(List.of());
        }
        List<List<Integer>> permutations = permute(Arrays.copyOfRange(numbers, 1, numbers.length));
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> permutation : permutations) {
            for (int index = 0; index <= permutation.size(); index++) {
                List<Integer> copy = new ArrayList<>(permutation);
                copy.add(index, numbers[0]);
                result.add(copy);
            }
        }
        return result;
    }
}
