class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] numbers) {
        if (numbers.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }
        result = new ArrayList<>();
        backtrack(new ArrayList<>(), numbers, new boolean[numbers.length]);
        return result;
    }

    private void backtrack(List<Integer> perm, int[] numbers, boolean[] pick) {
        if (perm.size() == numbers.length) {
            result.add(new ArrayList<>(perm));
            return;
        }
        for (int index = 0; index < numbers.length; index++) {
            if (!pick[index]) {
                perm.add(numbers[index]);
                pick[index] = true;
                backtrack(perm, numbers, pick);
                perm.remove(perm.size() - 1);
                pick[index] = false;
            }
        }
    } 
}
