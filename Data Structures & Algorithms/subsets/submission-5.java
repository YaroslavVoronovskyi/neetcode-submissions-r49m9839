class Solution {
    public List<List<Integer>> subsets(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int number : numbers) {
            int size = result.size();
            for (int index = 0; index < size; index++) {
                List<Integer> subset = new ArrayList<>(result.get(index));
                subset.add(number);
                result.add(subset);
            }
        }
        return result;
    }
}
