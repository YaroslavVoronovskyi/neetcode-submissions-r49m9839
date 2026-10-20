class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] numbers) {
        result = new ArrayList<>();
        backtrack(new ArrayList<>(), numbers, new boolean[numbers.length]);
        return result;
    }

    private void backtrack(List<Integer> permutations, int[] numbers, boolean[] pick) {
        if (permutations.size() == numbers.length) {
            result.add(new ArrayList<>(permutations));
            return;
        }
        for (int index = 0; index < numbers.length; index++) {
            if (!pick[index]) {
                permutations.add(numbers[index]);
                pick[index] = true;
                backtrack(permutations, numbers, pick);
                permutations.remove(permutations.size() - 1);
                pick[index] = false;
            }
        }
    }
}
