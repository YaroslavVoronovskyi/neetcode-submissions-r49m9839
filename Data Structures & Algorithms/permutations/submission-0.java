class Solution {
    public List<List<Integer>> permute(int[] numbers) {
        if (numbers.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }

        List<List<Integer>> permutations = permute(Arrays.copyOfRange(numbers, 1, numbers.length));
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> item : permutations) {
            for (int index = 0; index <= item.size(); index++) {
                List<Integer> copy = new ArrayList<>(item);
                copy.add(index, numbers[0]);
                result.add(copy);
            }
        }
        return result;
    }
}
