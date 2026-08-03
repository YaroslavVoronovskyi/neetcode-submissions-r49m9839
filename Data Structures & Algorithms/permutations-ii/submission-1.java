class Solution {

    private Set<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] numbers) {
        result = new HashSet<>();
        List<Integer> perm = new ArrayList<>();
        backtrack(numbers, perm);
        return new ArrayList<>(result);
    }

    private void backtrack(int[] numbers, List<Integer> perm) {
        if (perm.size() == numbers.length) {
            result.add(new ArrayList<>(perm));
            return;
        }
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != Integer.MIN_VALUE) {
                int temp = numbers[index];
                perm.add(numbers[index]);
                numbers[index] = Integer.MIN_VALUE;
                backtrack(numbers, perm);
                numbers[index] = temp;
                perm.removeLast();
            }
        }
    }
}