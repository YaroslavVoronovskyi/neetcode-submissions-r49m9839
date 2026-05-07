class Solution {
    public List<List<Integer>> permute(int[] numbers) {
        if (numbers.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }

        List<List<Integer>> permutations = new ArrayList<>();
        permutations.add(new ArrayList<>());
        for (int number : numbers) {
            List<List<Integer>> result = new ArrayList<>();
            for (List<Integer> item : permutations) {
                for (int index = 0; index <= item.size(); index++) {
                    List<Integer> copy = new ArrayList<>(item);
                    copy.add(index, number);
                    result.add(copy);
                }
            }
            permutations = result;
        }
        return permutations;
    }
}
